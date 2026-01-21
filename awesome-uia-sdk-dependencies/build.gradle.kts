plugins {
    `java-platform`
    `maven-publish`
}

dependencies {
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
    }
}
