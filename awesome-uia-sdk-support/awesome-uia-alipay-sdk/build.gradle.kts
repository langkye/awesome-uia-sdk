plugins {
    id("uia.library")
    alias(libs.plugins.kotlin.kapt)
}

apply(plugin = "uia.library")
apply(plugin = "kotlin-kapt")

dependencies {
    api(project(":$CORE"))
    api(project(":${resolveCommonModuleName("serializer-jackson")}"))
    
    api(libs.alipay.sdk.java) {
        exclude(group = "dom4j", module = "dom4j")
        exclude(group = "org.bouncycastle", module = "bcprov-jdk15on")
        exclude(group = "com.google.guava", module = "guava")
        exclude(group = "org.apache.commons", module = "commons-lang3")
    }
    api(libs.bcprov.jdk15to18)
    api(libs.bcprov.jdk18on)
    api(libs.dom4j)
    implementation(libs.auto.service.annotations)
    kapt(libs.auto.service)

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
}
