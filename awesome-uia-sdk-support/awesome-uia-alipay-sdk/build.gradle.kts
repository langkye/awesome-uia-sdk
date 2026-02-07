plugins {
    id("uia.library")
    alias(libs.plugins.kotlin.kapt)
}

apply(plugin = "uia.library")
apply(plugin = "kotlin-kapt")

dependencies {
    api(project(":$CORE"))
    api(project(":${resolveCommonModuleName("serializer-fastjson")}"))
    api(project(":${resolveCommonModuleName("serializer-fastjson")}"))
    
    api(libs.alipay.sdk.java) {
        exclude(group = "dom4j", module = "dom4j")
        exclude(group = "org.bouncycastle", module = "bcprov-jdk15on")
    }
    api(libs.bcprov.jdk15to18)
    api(libs.bcprov.jdk18on)
    api(libs.dom4j)
    implementation(libs.auto.service.annotations)
    kapt(libs.auto.service)
}
