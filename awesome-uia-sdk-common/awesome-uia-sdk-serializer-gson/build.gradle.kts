plugins {
    id("uia.library")
}

dependencies {
    api(project(":${resolveCommonModuleName(shortName = "serializer-core")}"))
    
    api(libs.gson)
}
