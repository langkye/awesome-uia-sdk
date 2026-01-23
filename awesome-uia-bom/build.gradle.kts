plugins {
    `java-platform`
    `maven-publish`
}

javaPlatform {
    allowDependencies()
}

// implementation: 依赖仅对当前模块内部可见。如果模块 A 依赖 B，B 依赖 implementation C，那么 A 无法 直接访问 C 的类。
// api: 依赖会暴露给消费者。如果模块 A 依赖 B，B 依赖 api C，那么 A 可以 直接访问 C 的类。
dependencies {
    // ① BOM: 官方 BOM
    //api(platform("org.springframework.boot:spring-boot-dependencies:${libs.versions.springBoot.get()}"))
    //api(platform("org.springframework.cloud:spring-cloud-dependencies:${libs.versions.springCloud.get()}"))
    //api(platform("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${libs.versions.springCloudAlibaba.get()}"))
    //api(platform("com.baomidou:mybatis-plus-bom:${libs.versions.mybatisPlusBoot3.get()}"))

    //api(platform(libs.testcontainersBom.get()))
    api(platform(libs.junit.bom.get()))
    //api(platform(libs.jacksonBom.get()))

    // ② 普通坐标: 自定义约束（不用 platform()）
    constraints {
        val version = project.version.toString()
        api("$GROUP_ID:$CORE_NAME:$version")
        api("$GROUP_ID:${resolveSupportModuleName("alipay")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("bccastle")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("bjtoon")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("gitee")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("github")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("gitlab")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("google")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("jban")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("weibo")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("wx")}:$version")
        api("$GROUP_ID:${resolveSupportModuleName("yztoon")}:$version")
        api("$GROUP_ID:$ALL_NAME:$version")

        // Kotlin
        val kotlinVersion = libs.versions.kotlin.get()
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
        api("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
        // 日志
        api("org.slf4j:slf4j-api:${libs.versions.slf4j.get()}")
        api("ch.qos.logback:logback-classic:${libs.versions.logback.get()}")
        api("net.logstash.logback:logstash-logback-encoder:${libs.versions.logstash.get()}")
        api("org.dom4j:dom4j:${libs.versions.dom4j.get()}")
        // 网络
        api("com.squareup.okhttp3:okhttp:${libs.versions.okhttp3.get()}")
        api("com.squareup.okio:okio:${libs.versions.okio.get()}")
        api("com.google.protobuf:protobuf-java:${libs.versions.protobuf.java.get()}")
        api("org.apache.httpcomponents.client5:httpclient5:${libs.versions.httpclient5.get()}")
        // 工具
        api("com.devskiller.friendly-id:friendly-id:${libs.versions.friendlyId.get()}")
        api("org.apache.commons:commons-lang3:${libs.versions.commons.lang3.get()}")
        api("org.apache.commons:commons-collections4:${libs.versions.commons.collections4.get()}")
        api("commons-codec:commons-codec:${libs.versions.commons.codec.get()}")
        api("com.alibaba:fastjson:${libs.versions.fastjson.get()}")
        api("com.alibaba.fastjson2:fastjson2:${libs.versions.fastjson.get()}")
        api("com.alibaba.fastjson2:fastjson2-kotlin:${libs.versions.fastjson.get()}")
        api("com.alibaba.fastjson2:fastjson2-extension:${libs.versions.fastjson.get()}")
        api("com.alibaba.fastjson2:fastjson2-extension-spring6:${libs.versions.fastjson2.extension.spring6.get()}")
        api("org.jetbrains.kotlinx:kotlinx-serialization-json:${libs.versions.kotlinx.serialization.json.get()}")
        api("com.google.code.gson:gson:${libs.versions.gson.get()}")
        api("com.alibaba:transmittable-thread-local:${libs.versions.transmittable.thread.local.get()}")
        api("org.yaml:snakeyaml:${libs.versions.snakeyaml.get()}")
        api("com.google.guava:guava:${libs.versions.guava.get()}")
        api("io.github.classgraph:classgraph:${libs.versions.classgraph.get()}")
        api("com.google.errorprone:error_prone_annotations:${libs.versions.error.prone.annotations.get()}")
        api("org.apache.commons:commons-text:${libs.versions.commons.text.get()}")
        api("io.grpc:grpc-netty:${libs.versions.grpcNetty.get()}")
        api("com.google.auto.service:auto-service-annotations:${libs.versions.auto.service.get()}")
        api("com.google.auto.service:auto-service:${libs.versions.auto.service.get()}")
        api("io.leopard:javahost:${libs.versions.javahost.get()}")
        api("io.vavr:vavr:${libs.versions.vavr.get()}")
        api("junit:junit:${libs.versions.junit.junit.get()}")
        // 加密
        api("org.bouncycastle:bcprov-jdk18on:${libs.versions.bcprov.jdk18on.get()}")
        api("org.bouncycastle:bcprov-jdk15to18:${libs.versions.bcprov.jdk15to18.get()}")
        // sdk
        api("com.alipay.sdk:alipay-sdk-java:${libs.versions.alipay.sdk.java.get()}")
    }
}
