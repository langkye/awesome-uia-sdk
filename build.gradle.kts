import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.kotlinSpring) apply false
    alias(libs.plugins.siteGradlePlugin)
    id("org.gradle.idea")
}

val signingKeyId = project.findProperty("signing.keyId") as String?
//val signingKey = project.findProperty("signing.key") as String?
val keyFilePath = project.findProperty("signing.keyFilePath") as String?
val keyFile = if(keyFilePath != null) file(keyFilePath) else null
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

subprojects {
    
    if (!isInternalModule(project.name)) {
        apply(plugin = "maven-publish")
        apply(plugin = "signing")
    }
    
    if (isJavaPlatform(project.name)) {
        apply(plugin = "java-platform")
    }
    if (!isJavaPlatform(project.name)) {

        apply(plugin = "uia.library")
        apply(plugin = "java-library")
        apply(plugin = "kotlin")
        apply(plugin = "kotlin-kapt")
        
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
                options.release.set(8) // main -> --release 8
            }
        }

        tasks.withType<KotlinCompile>().configureEach {
            //kotlinOptions {
            //    jvmTarget = "1.8"
            //    freeCompilerArgs = listOf("-Xjsr305=strict")
            //}
            if (name == "compileKotlin") {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                    // 更严格：限制可用 JDK API 到 8（建议开启，避免误用 JDK9+ API）
                    freeCompilerArgs.add("-Xjdk-release=8")
                    freeCompilerArgs.add("-Xjsr305=strict")
                }
            }
        }

        // ---------- test：开发/测试使用 JDK17+ ----------
        tasks.withType<JavaCompile>().configureEach {
            if (name == "compileTestJava") {
                options.release.set(17)
            }
        }
        tasks.withType<KotlinCompile>().configureEach {
            if (name == "compileTestKotlin") {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }
        }

        tasks.withType<Test>().configureEach {
            // 测试运行时使用 JDK17 的 launcher
            javaLauncher.set(
                javaToolchains.launcherFor {
                    languageVersion.set(JavaLanguageVersion.of(17))
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
                jvmTarget.set(JvmTarget.JVM_17)
            }
        }

        // 如果你还在用 JUnit 6（需要 17+），确保 test 配置解析按 JVM17
        configurations.matching {
            it.name == "testCompileClasspath" || it.name == "testRuntimeClasspath"
        }.configureEach {
            attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 17)
        }
    }


    if (!isInternalModule(project.name)) {
        signing {

            //if (signingKeyId != null && signingPassword != null) {
            //    // 使用内存中的密钥和密码进行签名，不依赖外部 gpg 命令
            //    //useInMemoryPgpKeys(signingKey, signingPassword)
            //    useInMemoryPgpKeys(signingKeyId, signingPassword)
            //}
            if (keyFilePath != null && keyFile?.exists() == true) {
                // 读取文件内容并使用内存签名
                val keyContent = keyFile.readText()
                useInMemoryPgpKeys(signingKeyId, keyContent, signingPassword ?: "")
            }
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
                create<MavenPublication>("mavenJava") {
                    if (isJavaPlatform(project.name)) {
                        from(components["javaPlatform"])
                    } else{
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
                    val releasesRepositoryUrl = RELEASE_URL
                    val snapshotsRepositoryUrl= SNAPSHOTS_URL

                    isAllowInsecureProtocol = true
                    name = project.name
                    description = project.description

                    url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepositoryUrl else releasesRepositoryUrl)

                    credentials {
                        // find property from ~/.gradle/gradle.properties
                        //username = project.findProperty("ossrh.username") as String
                        username = project.findProperty("nexus.username") as String
                        //password = project.findProperty("ossrh.password") as String
                        password = project.findProperty("nexus.password") as String
                    }
                }
            }
        }
        
        tasks.withType<PublishToMavenRepository> {
            doFirst {
                println("Publishing ${project.name} to repository: ${repository.url}")
            }
        }
    }
}

// Root project cleanup - it should not produce artifacts anymore
tasks.findByName("jar")?.enabled = false
tasks.findByName("javadoc")?.enabled = false
tasks.findByName("sourcesJar")?.enabled = false
tasks.findByName("javadocJar")?.enabled = false

kotlin {
    jvmToolchain(8)
}

tasks.withType<PublishToMavenRepository> {
    doFirst {
        println("Publishing to repository: ${repository.url}")
        println("Username: ${repository.credentials.username}")
        //println("Password: ${repository.credentials.password}")
    }
}