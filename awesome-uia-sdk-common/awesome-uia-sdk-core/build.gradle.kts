dependencies {
    api(httpclient5)
    api(okhttp) {
        exclude(group = "com.squareup.okio", module = "okio")
    }
    api(okio)
    api(slf4j_api)
    api(guava)
    api(fastjson)
    api(fastjson2)
    api(fastjson2kotlin)
    api(gson)
    api(javahost)
    api(vavr)
    api(common_lang3)
    api(commons_collections4)
    api(commons_codec)
    api(logback_classic)
    api(kotlinx_serialization_json)
    api(kotlin_stdlib)
    api(kotlin_stdlib_jdk8)
    api(kotlin_reflect)
    
    testImplementation(junit)
}