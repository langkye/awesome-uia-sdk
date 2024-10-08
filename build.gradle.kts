plugins {
    java
    `java-library`    // one of
    //`java-platform` // one of
    `maven-publish`
    signing
    id(site_gradle_plugin) version VERSION.SITE_GRADLE_PLUGIN_VERSION
    kotlin(jvm) version VERSION.KOTLIN_VERSION
}

group = GROUP_ID
version = PROJECT_VERSION
description = DESCRIPTION

sourceSets {
    main {
        java {
            srcDirs("src/main/java", "src/main/kotlin")
        }
        // default 
        //resources {
        //    srcDirs("src/main/resources")
        //}
    }
    test {
        java {
            srcDirs("src/test/java", "src/test/kotlin")
        }
        // default 
        //resources {
        //    srcDirs("src/test/resources")
        //}
    }
}

repositories {
    mavenLocal()
    //mavenCentral()
    maven {
        isAllowInsecureProtocol = true
        url = uri("https://repo.maven.apache.org/maven2")
    }
    maven {
        isAllowInsecureProtocol = true
        url = uri("https://s01.oss.sonatype.org/")
    }
    maven {
        isAllowInsecureProtocol = true
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    maven {
        isAllowInsecureProtocol = true
        url = uri("https://maven.aliyun.com/repository/public")
    }
}

dependencies {
    api(httpclient5)
    api(okhttp) {
        exclude(group = "com.squareup.okio", module = "okio")
    }
    api(okio)
    api(bcprovJdk15to18)
    //api(bcprov_jdk15on)
    api(bcprov_jdk18on)
    api(slf4j_api)
    api(guava)
    api(fastjson2)
    api(fastjson2kotlin)
    api(gson)
    api(javahost)
    api(vavr)
    api(common_lang3)
    api(commons_collections4)
    api(commons_codec)
    api(logback_classic)
    api(kotlinx_serialization_json)
    api(kotlin_stdlib)
    //api(kotlin(stdlib_jdk8))
    api(kotlin_stdlib_jdk8)
    api(kotlin_reflect)
    api(alipay_sdk_java) {
        exclude(group = "dom4j", module = "dom4j")
        exclude(group = "org.bouncycastle", module = "bcprov-jdk15on")
    }
    api(dom4j)

    testImplementation(junit)
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:deprecation")
    options.compilerArgs.add("-Xlint:-unchecked")
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks.javadoc {
    // level jdk 9+
    /*
    if (JavaVersion.current().isJava9Compatible) {
        // 生成HTML 5格式的输出。
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
        
    }*/
}

//打包任务构建时，生成javadoc
tasks.withType<Jar> {
    manifest {
        attributes["Multi-Release"] = "true"
    }
    from(tasks["javadoc"]) {
        into("/javadocs")
    }
}

//定义任务依赖
tasks.getByName("jar")
    .dependsOn("javadocJar")
    .dependsOn("javadoc") 
    //.dependsOn("sourceJar")

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

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

signing {
    //useInMemoryPgpKeys(findProperty("signingKey") as String?, findProperty("signingPassword") as String?)
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}
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