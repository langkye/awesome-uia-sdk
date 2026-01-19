plugins {
    `java-library`
    `maven-publish`
    signing
    id(site_gradle_plugin) version VERSION.SITE_GRADLE_PLUGIN_VERSION
    kotlin(jvm) version VERSION.KOTLIN_VERSION
    kotlin("kapt") version VERSION.KOTLIN_VERSION apply false
}

allprojects {
    group = GROUP_ID
    version = PROJECT_VERSION

    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://repo.maven.apache.org/maven2") }
        maven { setUrl("https://s01.oss.sonatype.org/") }
        mavenLocal()
    }
}

subprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "signing")
    
    val signingKeyId = project.findProperty("signing.keyId") as String?
    //val signingKey = project.findProperty("signing.key") as String?
    val keyFilePath = project.findProperty("signing.keyFilePath") as String?
    val keyFile = if(keyFilePath != null) file(keyFilePath) else null
    val signingPassword = project.findProperty("signing.password") as String?
    println("[${project.name}] load signingKeyId: $signingKeyId")
    println("[${project.name}] read keyFilePath: $keyFilePath")
    
    if (project.name == BOM) {
        apply(plugin = "java-platform")
    }
    if (project.name != BOM) {
        
        apply(plugin = "java-library")
        apply(plugin = "kotlin")
        apply(plugin = "kotlin-kapt")
        
        dependencies {
            implementation(autoServiceAnnotations)
            "kapt"(autoService)
        }

        java {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(8))
            }
            withSourcesJar()
            withJavadocJar()
        }

        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = listOf("-Xjsr305=strict")
            }
        }

        tasks.withType<JavaCompile> {
            options.encoding = "UTF-8"
            options.compilerArgs.add("-Xlint:deprecation")
            options.compilerArgs.add("-Xlint:-unchecked")
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
    }

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
                    if (project.name == BOM) {
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