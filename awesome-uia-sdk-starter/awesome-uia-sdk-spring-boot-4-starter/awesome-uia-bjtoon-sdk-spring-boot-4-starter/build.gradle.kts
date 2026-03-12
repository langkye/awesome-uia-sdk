plugins {
    id("uia.library")
    kotlin("kapt")
}

dependencies {
    api(project(":awesome-uia-sdk-support:awesome-uia-bjtoon-sdk"))
    
    compileOnly(libs.spring.boot4.autoconfigure)
    kapt(libs.spring.boot4.configuration.processor)
}
