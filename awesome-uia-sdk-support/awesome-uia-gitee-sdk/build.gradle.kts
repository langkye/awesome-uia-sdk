dependencies {
    api(project(":$CORE"))
    api(project(":${resolveCommonModuleName("serializer-fastjson")}"))
    
    implementation("com.google.auto.service:auto-service-annotations")
    kapt(libs.auto.service)
}
