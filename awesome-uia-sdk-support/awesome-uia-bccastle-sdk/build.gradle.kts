dependencies {
    api(project(":$CORE"))
    implementation("com.google.auto.service:auto-service-annotations")
    kapt(libs.auto.service)
}
