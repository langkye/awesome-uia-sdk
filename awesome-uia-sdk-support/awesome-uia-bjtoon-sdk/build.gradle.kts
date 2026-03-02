plugins {
    id("uia.library")
}

dependencies {
    api(project(":$CORE"))
    api(project(":${resolveCommonModuleName("serializer-jackson")}"))
    
    api(libs.bcprov.jdk15to18)
    api(libs.bcprov.jdk18on)
    implementation(libs.auto.service.annotations)
    kapt(libs.auto.service)
    
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
}
