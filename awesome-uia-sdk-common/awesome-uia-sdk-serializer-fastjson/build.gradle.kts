plugins {
    id("uia.library")
}

apply(plugin = "uia.library")

uiaLibrary {
    //removeLibrariesFromPom(libs.logback.classic)
    //removeLibrariesFromClasspath(libs.logback.classic)
}

dependencies {
    api("com.alibaba:fastjson")
    api("com.alibaba.fastjson2:fastjson2")
    api("com.alibaba.fastjson2:fastjson2-kotlin")
}