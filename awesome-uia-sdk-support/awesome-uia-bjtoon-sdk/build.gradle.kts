plugins {
    id("uia.library")
}

dependencies {
    api(project(":$CORE"))
    api("org.bouncycastle:bcprov-jdk15to18")
    api("org.bouncycastle:bcprov-jdk18on")
    implementation(libs.auto.service.annotations)
    kapt(libs.auto.service)
}
