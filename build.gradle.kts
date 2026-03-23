import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.publish.maven.tasks.PublishToMavenRepository
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.time.Instant
import java.util.Base64

plugins {
    `java-library`
    `maven-publish`
    signing
    //id(site_gradle_plugin) version VERSION.SITE_GRADLE_PLUGIN_VERSION
    //kotlin(jvm) //version VERSION.KOTLIN_VERSION
    //kotlin("kapt") //version VERSION.KOTLIN_VERSION apply false
    //alias(libs.plugins.kotlin.kapt)
    id("uia.library")

    //alias(libs.plugins.springBoot) apply false
    //alias(libs.plugins.springDependencyManagement) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.site.gradle.plugin)
    id("org.gradle.idea")
    alias(libs.plugins.jreleaser)
    //alias(libs.plugins.kordamp)
}

val signingKeyId = project.findProperty("signing.keyId") as String?
//val signingKey = project.findProperty("signing.key") as String?
val keyFilePath = project.findProperty("signing.keyFilePath") as String?
val keyFile = if (keyFilePath != null) file(keyFilePath) else null
val signingPassword = project.findProperty("signing.password") as String?
println("[${project.name}] load signingKeyId: $signingKeyId")
println("[${project.name}] read keyFilePath: $keyFilePath")

allprojects {
    group = GROUP_ID
    version = PROJECT_VERSION
    description = DESCRIPTION

    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://repo.maven.apache.org/maven2") }
        maven { setUrl("https://s01.oss.sonatype.org/") }
        mavenLocal()
    }
}

// ----------------------------------------------------------
// 发布状态管理
// ----------------------------------------------------------
val releaseStateRoot = rootProject.layout.buildDirectory.dir("release-state/${PROJECT_VERSION}").get().asFile
val releaseManifestFile = releaseStateRoot.resolve("manifest.txt")
val releaseStagedDir = releaseStateRoot.resolve("staged")
val releaseDeployedDir = releaseStateRoot.resolve("deployed")
val releaseFailedDir = releaseStateRoot.resolve("failed")

fun releaseStagedFile(moduleName: String) = releaseStagedDir.resolve("$moduleName.done")
fun releaseDeployedFile(moduleName: String) = releaseDeployedDir.resolve("$moduleName.done")
fun releaseFailedFile(moduleName: String) = releaseFailedDir.resolve("$moduleName.log")

fun appendManifestLine(moduleName: String) {
    releaseStateRoot.mkdirs()
    val line = "$moduleName|$GROUP_ID|$PROJECT_VERSION"
    val existing = if (releaseManifestFile.exists()) releaseManifestFile.readLines() else emptyList()
    if (line !in existing) {
        releaseManifestFile.appendText(line + System.lineSeparator())
    }
}

fun markReleaseStaged(moduleName: String, reason: String) {
    val file = releaseStagedFile(moduleName)
    file.parentFile.mkdirs()
    file.writeText(
        buildString {
            appendLine("module=$moduleName")
            appendLine("group=$GROUP_ID")
            appendLine("version=$PROJECT_VERSION")
            appendLine("reason=$reason")
            appendLine("timestamp=${Instant.now()}")
        }
    )
}

fun markReleaseDeployed(moduleName: String, reason: String) {
    val file = releaseDeployedFile(moduleName)
    file.parentFile.mkdirs()
    file.writeText(
        buildString {
            appendLine("module=$moduleName")
            appendLine("group=$GROUP_ID")
            appendLine("version=$PROJECT_VERSION")
            appendLine("reason=$reason")
            appendLine("timestamp=${Instant.now()}")
        }
    )
}

fun markReleaseFailed(moduleName: String, message: String) {
    val file = releaseFailedFile(moduleName)
    file.parentFile.mkdirs()
    file.writeText(
        buildString {
            appendLine("module=$moduleName")
            appendLine("group=$GROUP_ID")
            appendLine("version=$PROJECT_VERSION")
            appendLine("timestamp=${Instant.now()}")
            appendLine(message)
        }
    )
}

fun isReleaseStaged(moduleName: String): Boolean = releaseStagedFile(moduleName).exists()
fun isReleaseDeployed(moduleName: String): Boolean = releaseDeployedFile(moduleName).exists()

fun looksLikePartialDeployFailure(message: String): Boolean {
    return message.contains("already deployed", ignoreCase = true) ||
        message.contains("Some artifacts were already deployed", ignoreCase = true) ||
        message.contains("staging repository", ignoreCase = true)
}

/**
 * Central Portal published API
 * GET /api/v1/publisher/published?namespace=...&name=...&version=...
 */
fun remoteVersionExists(moduleName: String): Boolean {
    return try {
        val baseUrl = "https://central.sonatype.com/api/v1/publisher/published"
        val namespace = URLEncoder.encode(GROUP_ID, Charsets.UTF_8.name())
        val name = URLEncoder.encode(moduleName, Charsets.UTF_8.name())
        val version = URLEncoder.encode(PROJECT_VERSION, Charsets.UTF_8.name())

        val url = "$baseUrl?namespace=$namespace&name=$name&version=$version"
        val conn = (URL(url).openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            connectTimeout = 5_000
            readTimeout = 5_000
            instanceFollowRedirects = true

            // todo
            val user = project.findProperty("JRELEASER_MAVENCENTRAL_USERNAME") as String?
            val pass = project.findProperty("JRELEASER_MAVENCENTRAL_PASSWORD") as String?
            if (!user.isNullOrBlank() && !pass.isNullOrBlank()) {
                val token = Base64.getEncoder()
                    .encodeToString("$user:$pass".toByteArray(Charsets.UTF_8))
                setRequestProperty("Authorization", "Basic $token")
            }
        }

        if (conn.responseCode != 200) {
            println("[ERROR] [${conn.responseCode}] ${conn.responseMessage}")
            return false
        }
        val body = conn.inputStream.bufferedReader().use { it.readText() }
        body.contains("\"published\":true", ignoreCase = true)
    } catch (ex: Exception) {
        println("[ERROR] ${ex.message}")
        false
    }
}

subprojects {

    if (!isInternalModule(project.name)) {
        apply(plugin = "maven-publish")
        apply(plugin = "signing")
        apply(plugin = "org.jreleaser")
        //apply(plugin = "org.kordamp.gradle.java-project")
    }

    if (isJavaPlatform(project.name)) {
        apply(plugin = "java-platform")
        apply(plugin = "uia.platform")
    }
    if (!isJavaPlatform(project.name)) {

        apply(plugin = "uia.library")
        apply(plugin = "java-library")
        apply(plugin = "kotlin")
        apply(plugin = "kotlin-kapt")

        val targetJava =
            // spring-boot-3 => jdk17+
            if (project.name.contains("spring-boot-3", true)) {
                TOOLCHAIN_JAVA_VERSION
            }
            // spring-boot-4 => jdk17+
            else if (project.name.contains("spring-boot-4", true)) {
                TOOLCHAIN_JAVA_VERSION
            }
            // solon-3 => jdk17+
            else if (project.name.contains("solon-boot-3", true)) {
                TOOLCHAIN_JAVA_VERSION
            }
            // other
            else {
                TARGET_JAVA_VERSION
            }

        dependencies {
            //implementation("com.google.auto.service:auto-service-annotations")
            //"kapt"("com.google.auto.service:auto-service")
        }

        java {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(TOOLCHAIN_JAVA_VERSION))
            }
            withSourcesJar()
            withJavadocJar()
        }

        tasks.withType<JavaCompile>().configureEach {
            options.encoding = "UTF-8"
            options.compilerArgs.add("-Xlint:deprecation")
            options.compilerArgs.add("-Xlint:-unchecked")
            if (name == "compileJava") {
                options.release.set(resolveReleaseJdkVersion(targetJava)) // main -> --release 8
            }
        }

        tasks.withType<KotlinCompile>().configureEach {
            //kotlinOptions {
            //    jvmTarget = "1.8"
            //    freeCompilerArgs = listOf("-Xjsr305=strict")
            //}
            if (name == "compileKotlin") {
                compilerOptions {
                    jvmTarget.set(JvmTarget.fromTarget(targetJava.toString()))
                    // 更严格：限制可用 JDK API 到 8（建议开启，避免误用 JDK9+ API）
                    freeCompilerArgs.add("-Xjdk-release=${resolveReleaseJdkVersion(targetJava)}")
                    freeCompilerArgs.add("-Xjsr305=strict")
                }
            }
        }

        // ---------- test：开发/测试使用 JDK17+ ----------
        tasks.withType<JavaCompile>().configureEach {
            if (name == "compileTestJava") {
                options.release.set(TOOLCHAIN_JAVA_VERSION)
            }
        }
        tasks.withType<KotlinCompile>().configureEach {
            if (name == "compileTestKotlin") {
                compilerOptions {
                    jvmTarget.set(JvmTarget.fromTarget(TOOLCHAIN_JAVA_VERSION.toString()))
                }
            }
        }

        tasks.withType<Test>().configureEach {
            // 测试运行时使用 JDK17 的 launcher
            javaLauncher.set(
                javaToolchains.launcherFor {
                    languageVersion.set(JavaLanguageVersion.of(TOOLCHAIN_JAVA_VERSION))
                }
            )
            useJUnitPlatform()
        }

        tasks.withType<Javadoc> {
            options.encoding = "UTF-8"
        }

        //打包任务构建时，生成javadoc
        tasks.withType<Jar> {
            manifest {
                attributes["Multi-Release"] = "true"
            }
            val javadocTask = tasks.findByName("javadoc")
            if (javadocTask != null) {
                from(javadocTask) {
                    into("/javadocs")
                }
            }
        }

        // 关键：kapt 生成 test stubs 的 Kotlin 任务也要切到 17（否则就会像你现在这样 1.8 vs 17）
        tasks.matching { it.name == "kaptGenerateStubsTestKotlin" }.configureEach {
            @Suppress("UNCHECKED_CAST")
            (this as KotlinCompile).compilerOptions {
                jvmTarget.set(JvmTarget.fromTarget(TOOLCHAIN_JAVA_VERSION.toString()))
            }
        }
        tasks.matching { it.name == "kaptGenerateStubsKotlin" }.configureEach {
            @Suppress("UNCHECKED_CAST")
            (this as KotlinCompile).compilerOptions {
                jvmTarget.set(JvmTarget.fromTarget(targetJava.toString()))
            }
        }

        // 如果你还在用 JUnit 6（需要 17+），确保 test 配置解析按 JVM17
        configurations.matching {
            it.name == "testCompileClasspath" || it.name == "testRuntimeClasspath"
        }.configureEach {
            attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, TOOLCHAIN_JAVA_VERSION)
        }
    }


    if (!isInternalModule(project.name)) {
        signing {

            //if (signingKeyId != null && signingPassword != null) {
            //    // 使用内存中的密钥和密码进行签名，不依赖外部 gpg 命令
            //    //useInMemoryPgpKeys(signingKey, signingPassword)
            //    useInMemoryPgpKeys(signingKeyId, signingPassword)
            //}
            // 有key文件
            if (keyFilePath != null && keyFile?.exists() == true) {
                // 读取文件内容并使用内存签名
                val keyContent = keyFile.readText()
                useInMemoryPgpKeys(signingKeyId, keyContent, signingPassword ?: "")
            }
            // 无key文件
            else {
                // 如果没有提供内存密钥，则回退到使用本地 gpg 代理
                useGpgCmd()
            }
            // Only sign if we have the publication (some modules might not have it yet)
            afterEvaluate {
                if (publishing.publications.findByName("mavenJava") != null) {
                    sign(publishing.publications["mavenJava"])
                }
            }
        }

        publishing {
            publications {
                withType<MavenPublication>().configureEach {
                    versionMapping {
                        allVariants {
                            fromResolutionResult()
                        }
                    }
                }

                create<MavenPublication>("mavenJava") {
                    // bom项目
                    if (isJavaPlatform(project.name)) {
                        from(components["javaPlatform"])
                    }
                    // 普通项目
                    else {
                        from(components["java"])
                    }

                    pom {
                        name.set(project.name)
                        description.set(project.description)
                        url.set("https://github.com/langkye/awesome-uia-sdk")

                        inceptionYear.set("2023")

                        organization {
                            name.set("lnkdoc")
                            url.set("https://github.com/lnkdoc")
                        }

                        developers {
                            developer {
                                id.set("langkye")
                                name.set("langkye")
                                email.set("langkye@gmail.com")
                            }
                        }

                        contributors {
                            contributor {
                                name.set("langkye")
                                email.set("langkye@gmail.com")
                                url.set("https://www.github.com/langkye")
                                roles.add("developer")
                                timezone.set("UTC+8")
                                properties.put("manager", "true")
                            }
                        }

                        licenses {
                            license {
                                name.set("The Apache License, Version 2.0")
                                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                            }
                        }

                        scm {
                            connection.set("scm:git:git@github.com:langkye/awesome-uia-sdk.git")
                            developerConnection.set("scm:git:git@github.com:langkye/awesome-uia-sdk.git")
                            url.set("https://github.com/langkye/awesome-uia-sdk/tree/${version}")
                        }
                    }
                }
            }

            repositories {
                maven {
                    val releasesRepositoryUrl = RELEASE_CENTRAL_URL
                    val snapshotsRepositoryUrl = SNAPSHOTS_CENTRAL_URL

                    isAllowInsecureProtocol = true
                    name = project.name
                    description = project.description

                    url = uri(
                        if (version.toString().endsWith("SNAPSHOT")) snapshotsRepositoryUrl else releasesRepositoryUrl
                    )

                    credentials {
                        // find property from ~/.gradle/gradle.properties
                        //username = project.findProperty("ossrh.username") as String?
                        username = project.findProperty("nexus.username") as String?
                        //username = project.findProperty("private.username") as String?
                        //password = project.findProperty("ossrh.password") as String?
                        password = project.findProperty("nexus.password") as String?
                        //password = project.findProperty("private.password") as String?
                    }
                }

                // ② 新增：本地 staging 仓库，供 JReleaser 使用
                maven {
                    name = "localStaging"
                    // 这里用 layout.buildDirectory 保证每个子模块各自的 build 目录
                    url = uri(layout.buildDirectory.dir("staging-deploy"))
                }
            }
        }

        // https://jreleaser.org/guide/latest/reference/project.html
        // https://jreleaser.org/guide/latest/examples/maven/maven-central.html#_portal_publisher_api
        // https://jreleaser.org/guide/latest/examples/maven/maven-central.html#_gradle
        jreleaser {
            project {
                //name = project.name
                version.set(PROJECT_VERSION)
                description.set(DESCRIPTION)
                authors.add("langkye")
                license = "Apache-2.0"
                inceptionYear = "2023"
                tags.set(listOf("awesome", "uia", "sdk"))
                maintainers.set(listOf("langkye"))
                copyright = "Copyright © 2023 lnkdoc All rights reserved."
                vendor = "Lnkdoc Inc"

                links {
                    homepage = "https://github.com/langkye/awesome-uia-sdk"
                    documentation = "https://github.com/langkye/awesome-uia-sdk"
                    license = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                    bugTracker = "https://github.com/langkye/awesome-uia-sdk/issues"
                    vcsBrowser = "https://github.com/langkye/awesome-uia-sdk"
                }

                snapshot {
                    pattern = ".*-SNAPSHOT.*"
                    fullChangelog = true
                }

                // A list of icons.
                icon {
                    // Publicly available URL. PNG format is preferred.
                    //  
                    url = "https://img2024.cnblogs.com/blog/2065380/202603/2065380-20260318105846014-737009118.png"

                    // Marks this icon as the primary one.
                    // Only a single icon may be set as primary.
                    // 
                    primary = true
                    // Image width in pixels.
                    // 
                    width = 250
                    // Image height in pixels.
                    // 
                    height = 250
                    // Additional properties used when evaluating templates.
                    // Key will be capitalized and prefixed with `icon`, i.e, `icon`.
                    extraProperties.put("favicon", "icon")
                }
            }

            signing {
                active = org.jreleaser.model.Active.ALWAYS
                armored = true
            }

            deploy {
                maven {
                    mavenCentral {
                        create("sonatypePortal") {
                            active = org.jreleaser.model.Active.RELEASE
                            url = "https://central.sonatype.com/api/v1/publisher/"
                            //closeRepository = true
                            //releaseRepository = true
                            stagingRepository("build/staging-deploy")
                            //stagingRepository("build/libs")
                            //stagingRepository("build")
                            connectTimeout = 20
                            readTimeout = 60
                            //autoPublish = false
                        }
                    }

                    //nexus2 {
                    //    create("privateNexus") {
                    //        active = org.jreleaser.model.Active.RELEASE
                    //        url = PRIVATE_RELEASE_URL
                    //        snapshotUrl = PRIVATE_SNAPSHOTS_URL
                    //        snapshotSupported = true
                    //        closeRepository = true
                    //        releaseRepository = true
                    //        stagingRepository("build/staging-deploy")
                    //        //stagingRepository("build/libs")
                    //        //stagingRepository("build")
                    //        connectTimeout = 20
                    //        readTimeout = 60
                    //    }
                    //}
                }
            }

            //distributions {
            //    // 让 JReleaser 从 Maven publication 读取构件
            //    // 如果你后续有额外发布目标，可以在这里继续扩展
            //}
        }

        tasks.matching { it.name == "publishAllPublicationsToLocalStagingRepository" }.configureEach {
            onlyIf {
                !isReleaseDeployed(project.name)
            }

            doFirst {
                appendManifestLine(project.name)
                println("Publishing ${project.name} to local staging repository: ${project.path}")
            }

            doLast {
                markReleaseStaged(project.name, "local-staging-success")
                println("[${project.name}] 已发布到本地 staging，写入 staged 标记：${releaseStagedFile(project.name).absolutePath}")
            }
        }

        tasks.matching { it.name == "jreleaserDeploy" }.configureEach {
            dependsOn("prepareReleaseManifest")
            dependsOn("publishAllPublicationsToLocalStagingRepository")

            onlyIf {
                val deployed = isReleaseDeployed(project.name)
                val remoteExists = remoteVersionExists(project.name)

                if (deployed) {
                    println("[${project.name}] 已存在 deployed 标记，跳过 jreleaserDeploy。")
                } else if (remoteExists) {
                    println("[${project.name}] Central Portal 已显示已发布，跳过 jreleaserDeploy。")
                }

                !deployed && !remoteExists
            }

            doFirst {
                appendManifestLine(project.name)
                println("[${project.name}] 准备执行 jreleaserDeploy: ${GROUP_ID}:${project.name}:${PROJECT_VERSION}")
                if (!isReleaseStaged(project.name)) {
                    println("[${project.name}] 警告：尚未发现 staged 标记，但仍将继续尝试部署。")
                }
            }

            doLast {
                markReleaseDeployed(project.name, "jreleaser-deploy-success")
                println("[${project.name}] 远端部署成功，已写入 deployed 标记：${releaseDeployedFile(project.name).absolutePath}")
            }
        }

        tasks.withType<PublishToMavenRepository>().configureEach {
            onlyIf {
                !isReleaseDeployed(project.name)
            }

            doFirst {
                appendManifestLine(project.name)
                println("Publishing ${project.name} to repository: ${repository.url}")
            }
        }

        if (project == rootProject) {
            gradle.addListener(object : TaskExecutionListener {
                override fun beforeExecute(task: Task) {
                    // no-op
                }

                override fun afterExecute(task: Task, state: TaskState) {
                    if (task is PublishToMavenRepository && state.failure != null) {
                        val moduleName = task.project.name
                        val msg = state.failure?.message ?: "unknown failure"

                        markReleaseFailed(moduleName, msg)

                        if (looksLikePartialDeployFailure(msg)) {
                            // 这里只能补 staged，不要直接补 deployed
                            markReleaseStaged(moduleName, "partial-success-detected")
                            println("[$moduleName] 检测到部分成功部署，已补写 staged 标记。")
                        }
                    }
                }
            })
        }

        tasks.register("resumeRelease") {
            group = "publishing"
            description = "基于 staged/deployed 标记继续未完成模块发布"
            dependsOn("prepareReleaseManifest")
            dependsOn("publishAllPublicationsToLocalStagingRepository")
            //dependsOn("jreleaserUpload")
            dependsOn("jreleaserDeploy")
        }
    }

    tasks.register("cleanReleaseState") {
        group = "publishing"
        description = "清理当前版本的发布状态"

        doLast {
            if (releaseStateRoot.exists()) {
                releaseStateRoot.deleteRecursively()
                println("Deleted release state: ${releaseStateRoot.absolutePath}")
            }
        }
    }

    tasks.register("prepareReleaseManifest") {
        group = "publishing"
        description = "生成发布清单，并可选探测远端版本是否已存在"

        doLast {
            releaseStateRoot.mkdirs()
            println("Release manifest: ${releaseManifestFile.absolutePath}")
            println("Release state dir: ${releaseStateRoot.absolutePath}")
        }
    }
}

// Root project cleanup - it should not produce artifacts anymore
tasks.findByName("jar")?.enabled = false
tasks.findByName("javadoc")?.enabled = false
tasks.findByName("sourcesJar")?.enabled = false
tasks.findByName("javadocJar")?.enabled = false

kotlin {
    jvmToolchain(TOOLCHAIN_JAVA_VERSION)
}

tasks.withType<PublishToMavenRepository> {
    doFirst {
        println("Publishing ${project.name} to repository: ${repository.url}")
        println("Username: ${repository.credentials.username}")
        //println("Password: ${repository.credentials.password}")
    }
}
