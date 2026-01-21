plugins {
    id("uia.library")
    alias(libs.plugins.kotlin.kapt)
}

apply(plugin = "uia.library")
apply(plugin = "kotlin-kapt")

dependencies {
    api(project(":$CORE"))
    api("com.alipay.sdk:alipay-sdk-java") {
        exclude(group = "dom4j", module = "dom4j")
        exclude(group = "org.bouncycastle", module = "bcprov-jdk15on")
    }
    api("org.bouncycastle:bcprov-jdk15to18")
    api("org.bouncycastle:bcprov-jdk18on")
    api("org.dom4j:dom4j")
    implementation("com.google.auto.service:auto-service-annotations")
    kapt(libs.auto.service)
}
