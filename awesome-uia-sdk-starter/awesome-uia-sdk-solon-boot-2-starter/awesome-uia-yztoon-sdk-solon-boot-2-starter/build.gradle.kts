plugins {
    id("uia.library")
}

dependencies {
    api(project(":awesome-uia-sdk-support:awesome-uia-yztoon-sdk"))
    
    compileOnly(libs.solon2.api)
}
