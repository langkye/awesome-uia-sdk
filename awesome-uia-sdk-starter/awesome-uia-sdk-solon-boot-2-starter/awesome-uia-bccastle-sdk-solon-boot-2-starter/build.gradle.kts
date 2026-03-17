plugins {
    id("uia.library")
}

dependencies {
    api(project(":awesome-uia-sdk-support:awesome-uia-bccastle-sdk"))
    
    compileOnly(libs.solon2.api)
}
