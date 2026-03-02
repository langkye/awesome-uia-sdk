dependencies {
    api(project(":$CORE"))
    api(project(":${resolveCommonModuleName("serializer-jackson")}"))
    
    implementation("com.google.auto.service:auto-service-annotations")
    kapt(libs.auto.service)

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
}
