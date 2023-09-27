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
    mavenCentral()
    maven("https://s01.oss.sonatype.org/")
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}