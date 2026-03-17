plugins {
    id("uia.library")
}

dependencies {
    api(project(":awesome-uia-sdk-support:awesome-uia-weibo-sdk"))
    
    compileOnly(libs.solon2.api)
}
