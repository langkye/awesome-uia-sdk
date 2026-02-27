plugins {
    id("uia.library")
    kotlin("kapt")
}

dependencies {
    api(project(":${resolveCommonModuleName(shortName = "serializer-core")}"))
    
    api(libs.gson)

    compileOnly(libs.auto.service.annotations)
    kapt(libs.auto.service)

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
