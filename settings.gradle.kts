rootProject.name = "awesome-uia-sdk"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    // 关键：让插件解析阶段也能从 build-logic 这个 included build 中找到插件
    includeBuild("build-logic")
}


include("awesome-uia-bom")
include("awesome-uia-sdk-dependencies")

include("awesome-uia-sdk-common:awesome-uia-sdk-core")
include("awesome-uia-sdk-common:awesome-uia-sdk-serializer-core")
include("awesome-uia-sdk-common:awesome-uia-sdk-serializer-jackson")
include("awesome-uia-sdk-common:awesome-uia-sdk-serializer-gson")
include("awesome-uia-sdk-common:awesome-uia-sdk-serializer-fastjson2")
include("awesome-uia-sdk-common:awesome-uia-sdk-serializer-fastjson")

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

include("awesome-uia-all-sdk")
