import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

buildscript {
    extra["variable"] = "value"

    //--ext use in build.gradle.kts
    //val variable: String by extra
}

repositories {
    mavenLocal()
    //mavenCentral()
    maven { setUrl("https://repo.maven.apache.org/maven2") }
    maven { setUrl("https://s01.oss.sonatype.org/") }
    maven { setUrl("https://repo.maven.apache.org/maven2/") }
    maven { setUrl("https://maven.aliyun.com/repository/public") }
}