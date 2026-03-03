plugins {
    id("uia.library")
}

apply(plugin = "uia.library")

uiaLibrary {
    removeLibrariesFromPom(libs.logback.classic)
}

dependencies {
    api(libs.kotlinx.serialization.json)
    api(libs.kotlin.stdlib)
    api(libs.kotlin.stdlib.jdk8)
    api(libs.kotlin.reflect)
    api(libs.httpclient5)
    api(libs.okhttp) {
        exclude(group = "com.squareup.okio", module = "okio")
    }
    api(libs.okhttp.jvm)
    api(libs.okio)
    api(libs.slf4j.api)
    api(libs.guava)
    api(libs.gson)
    api(libs.javahost)
    api(libs.vavr)
    api(libs.commons.codec)
    api(libs.commons.collections4)
    api(libs.commons.lang3)
    implementation(libs.logback.classic)

    //implementation("com.google.auto.service:auto-service-annotations")
    //"kapt"("com.google.auto.service:auto-service")
}