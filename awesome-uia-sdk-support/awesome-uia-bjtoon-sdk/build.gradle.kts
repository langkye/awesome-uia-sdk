plugins {
    id("uia.library")
}

dependencies {
    api(project(":$CORE"))
    api("org.bouncycastle:bcprov-jdk15to18")
    api("org.bouncycastle:bcprov-jdk18on")
    implementation("com.google.auto.service:auto-service-annotations")
    kapt(libs.auto.service)
}
