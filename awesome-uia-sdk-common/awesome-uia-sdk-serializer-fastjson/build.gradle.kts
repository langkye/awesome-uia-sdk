plugins {
    id("uia.library")
}

apply(plugin = "uia.library")

uiaLibrary {
    //removeLibrariesFromPom(libs.logback.classic)
    //removeLibrariesFromClasspath(libs.logback.classic)
}

dependencies {
    api(project(":${resolveCommonModuleName(shortName = "serializer-core")}"))
    
    api(libs.fastjson)
    api(libs.fastjson2)
    api(libs.fastjson2.kotlin)
}