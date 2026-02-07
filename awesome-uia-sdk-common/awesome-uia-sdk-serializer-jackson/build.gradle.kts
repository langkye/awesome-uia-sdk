plugins {
    id("uia.library")
}

dependencies {
    api(project(":${resolveCommonModuleName(shortName = "serializer-core")}"))
    
    api(libs.jackson.databind.v2)
    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
    
    implementation(libs.auto.service.annotations)
    kapt(libs.auto.service)

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
