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
        api(libs.kotlin.stdlib.jdk8)
        api(libs.kotlin.reflect)
        // 日志
        api(libs.slf4j.api)
        api(libs.logback.classic)
        api(libs.logstash.logback.encoder)
        api(libs.dom4j)
        // 网络
        api(libs.okhttp)
        api(libs.okio)
        api(libs.protobuf.java)
        api(libs.httpclient5)
        // 工具
        api(libs.friendly.id)
        api(libs.commons.lang3)
        api(libs.commons.collections4)
        api(libs.commons.codec)
        api(libs.kotlinx.serialization.json)
        api(libs.gson)
        api(libs.transmittable.thread.local)
        api(libs.snakeyaml)
        api(libs.guava)
        api(libs.classgraph)
        api(libs.error.prone.annotations)
        api(libs.commons.text)
        api(libs.grpc.netty)
        api(libs.auto.service.annotations)
        api(libs.auto.service)
        api(libs.javahost)
        api(libs.vavr)
        api(libs.junit)
        // 加密
        api(libs.bcprov.jdk18on)
        api(libs.bcprov.jdk15to18)
        // sdk
        api(libs.alipay.sdk.java)
        api(libs.alipay.sdk.java.v3)
    }
}
