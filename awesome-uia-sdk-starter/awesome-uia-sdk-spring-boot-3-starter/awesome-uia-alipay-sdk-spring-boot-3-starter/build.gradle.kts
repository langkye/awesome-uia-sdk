plugins {
    id("uia.library")
    kotlin("kapt")
}

dependencies {
    api(project(":awesome-uia-sdk-support:awesome-uia-alipay-sdk"))
    
    compileOnly(libs.spring.boot3.autoconfigure)
    kapt(libs.spring.boot3.configuration.processor)
}
