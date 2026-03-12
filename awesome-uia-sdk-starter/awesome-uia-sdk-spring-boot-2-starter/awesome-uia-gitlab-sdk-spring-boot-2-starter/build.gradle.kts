plugins {
    id("uia.library")
    kotlin("kapt")
}

dependencies {
    api(project(":awesome-uia-sdk-support:awesome-uia-gitlab-sdk"))
    
    compileOnly(libs.spring.boot2.autoconfigure)
    kapt(libs.spring.boot2.configuration.processor)
}
