rootProject.name = "awesome-uia-sdk"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    // 关键：让插件解析阶段也能从 build-logic 这个 included build 中找到插件
    includeBuild("build-logic")
}

// Bom
include("awesome-uia-bom")
include("awesome-uia-sdk-dependencies")

// Common
include("awesome-uia-sdk-common:awesome-uia-sdk-core")
include("awesome-uia-sdk-common:awesome-uia-sdk-serializer-core")
include("awesome-uia-sdk-common:awesome-uia-sdk-serializer-jackson")
include("awesome-uia-sdk-common:awesome-uia-sdk-serializer-gson")
include("awesome-uia-sdk-common:awesome-uia-sdk-serializer-fastjson")

// Spring boot 2 Starter
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-alipay-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-bccastle-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-bjtoon-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-gitee-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-github-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-gitlab-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-google-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-jban-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-weibo-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-wx-sdk-spring-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-2-starter:awesome-uia-yztoon-sdk-spring-boot-2-starter")

// Spring boot 3 Starter
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-alipay-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-bccastle-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-bjtoon-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-gitee-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-github-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-gitlab-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-google-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-jban-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-weibo-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-wx-sdk-spring-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-3-starter:awesome-uia-yztoon-sdk-spring-boot-3-starter")

// Spring boot 4 Starter
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-alipay-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-bccastle-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-bjtoon-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-gitee-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-github-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-gitlab-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-google-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-jban-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-weibo-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-wx-sdk-spring-boot-4-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-spring-boot-4-starter:awesome-uia-yztoon-sdk-spring-boot-4-starter")

// Solon boot 2 Starter
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-alipay-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-bccastle-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-bjtoon-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-gitee-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-github-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-gitlab-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-google-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-jban-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-weibo-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-wx-sdk-solon-boot-2-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-2-starter:awesome-uia-yztoon-sdk-solon-boot-2-starter")

// Solon boot 3 Starter
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-alipay-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-bccastle-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-bjtoon-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-gitee-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-github-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-gitlab-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-google-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-jban-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-weibo-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-wx-sdk-solon-boot-3-starter")
include("awesome-uia-sdk-starter:awesome-uia-sdk-solon-boot-3-starter:awesome-uia-yztoon-sdk-solon-boot-3-starter")

// SDK Support
include("awesome-uia-sdk-support:awesome-uia-alipay-sdk")
include("awesome-uia-sdk-support:awesome-uia-bccastle-sdk")
include("awesome-uia-sdk-support:awesome-uia-bjtoon-sdk")
include("awesome-uia-sdk-support:awesome-uia-gitee-sdk")
include("awesome-uia-sdk-support:awesome-uia-github-sdk")
include("awesome-uia-sdk-support:awesome-uia-gitlab-sdk")
include("awesome-uia-sdk-support:awesome-uia-google-sdk")
include("awesome-uia-sdk-support:awesome-uia-jban-sdk")
include("awesome-uia-sdk-support:awesome-uia-weibo-sdk")
include("awesome-uia-sdk-support:awesome-uia-wx-sdk")
include("awesome-uia-sdk-support:awesome-uia-yztoon-sdk")

// SDK All
include("awesome-uia-all-sdk")
