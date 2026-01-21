plugins {
    id("uia.library")
}

apply(plugin = "uia.library")

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-serialization-json")
    api("org.jetbrains.kotlin:kotlin-stdlib")
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    api("org.jetbrains.kotlin:kotlin-reflect")
    api("org.apache.httpcomponents.client5:httpclient5")
    api("com.squareup.okhttp3:okhttp") {
        exclude(group = "com.squareup.okio", module = "okio")
    }
    api("com.squareup.okio:okio")
    api("org.slf4j:slf4j-api")
    api("com.google.guava:guava")
    api("com.alibaba:fastjson")
    api("com.alibaba.fastjson2:fastjson2")
    api("com.alibaba.fastjson2:fastjson2-kotlin")
    api("com.google.code.gson:gson")
    api("io.leopard:javahost")
    api("io.vavr:vavr")
    api("org.apache.commons:commons-lang3")
    api("org.apache.commons:commons-collections4")
    api("commons-codec:commons-codec")
    implementation("ch.qos.logback:logback-classic")

    //implementation("com.google.auto.service:auto-service-annotations")
    //"kapt"("com.google.auto.service:auto-service")
}