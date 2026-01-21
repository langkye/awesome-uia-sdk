dependencies {
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("alipay")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("bccastle")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("bjtoon")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("gitee")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("github")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("gitlab")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("google")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("jban")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("weibo")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("wx")}"))
    api(project(":awesome-uia-sdk-support:${resolveSupportModuleName("yztoon")}"))
    
    //testImplementation("junit:junit")
    testImplementation(kotlin("test"))
}