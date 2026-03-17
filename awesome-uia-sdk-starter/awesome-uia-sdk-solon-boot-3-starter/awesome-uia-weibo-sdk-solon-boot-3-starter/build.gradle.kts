plugins {
    id("uia.library")
}

dependencies {
    api(project(":awesome-uia-sdk-support:awesome-uia-weibo-sdk"))
    
    compileOnly(libs.solon3.api)
    compileOnly(libs.solon3.configuration.processor)
    annotationProcessor(libs.solon3.configuration.processor)
}
