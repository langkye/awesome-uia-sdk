plugins {
    id("uia.library")
}

dependencies {
    api(project(":awesome-uia-sdk-support:awesome-uia-alipay-sdk"))
    
    compileOnly(libs.solon3.api)
    compileOnly(libs.solon3.configuration.processor)
    annotationProcessor(libs.solon3.configuration.processor)
}
