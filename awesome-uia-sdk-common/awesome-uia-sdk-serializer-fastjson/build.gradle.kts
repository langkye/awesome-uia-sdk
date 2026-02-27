plugins {
    id("uia.library")
    kotlin("kapt")
}

apply(plugin = "uia.library")

uiaLibrary {
    //removeLibrariesFromPom(libs.logback.classic)
    //removeLibrariesFromClasspath(libs.logback.classic)
}

dependencies {
    api(project(":${resolveCommonModuleName(shortName = "serializer-core")}"))
    
    api(libs.fastjson)
    api(libs.fastjson2)
    api(libs.fastjson2.kotlin)

    compileOnly(libs.auto.service.annotations)
    kapt(libs.auto.service)

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}