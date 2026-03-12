plugins {
    `java-platform`
    `maven-publish`
    id("uia.platform")
}

javaPlatform {
    allowDependencies()
}

uiaPlatform {
    libraries(libs.commons.codec)
    bundles(libs.bundles.project.requirement)
}

dependencies {
    constraints {
        val version = project.version.toString()
        // core
        api("$GROUP_ID:$CORE_NAME:$version")
        // support
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
        // all 
        api("$GROUP_ID:$ALL_NAME:$version")
        // Spring boot 2 Starter
        api("${GROUP_ID}:awesome-uia-alipay-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bccastle-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bjtoon-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitee-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-github-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitlab-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-google-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-jban-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-weibo-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-wx-sdk-spring-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-yztoon-sdk-spring-boot-2-starter:${version}")
        // Spring boot 3 Starter
        api("${GROUP_ID}:awesome-uia-alipay-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bccastle-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bjtoon-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitee-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-github-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitlab-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-google-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-jban-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-weibo-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-wx-sdk-spring-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-yztoon-sdk-spring-boot-3-starter:${version}")
        // Spring boot 4 Starter
        api("${GROUP_ID}:awesome-uia-alipay-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bccastle-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bjtoon-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitee-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-github-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitlab-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-google-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-jban-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-weibo-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-wx-sdk-spring-boot-4-starter:${version}")
        api("${GROUP_ID}:awesome-uia-yztoon-sdk-spring-boot-4-starter:${version}")
        // Solon boot 2 Starter
        api("${GROUP_ID}:awesome-uia-alipay-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bccastle-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bjtoon-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitee-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-github-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitlab-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-google-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-jban-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-weibo-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-wx-sdk-solon-boot-2-starter:${version}")
        api("${GROUP_ID}:awesome-uia-yztoon-sdk-solon-boot-2-starter:${version}")
        // Solon boot 3 Starter
        api("${GROUP_ID}:awesome-uia-alipay-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bccastle-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-bjtoon-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitee-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-github-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-gitlab-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-google-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-jban-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-weibo-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-wx-sdk-solon-boot-3-starter:${version}")
        api("${GROUP_ID}:awesome-uia-yztoon-sdk-solon-boot-3-starter:${version}")
    }
}
