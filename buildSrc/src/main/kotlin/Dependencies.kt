@Suppress("unused")
object VERSION {

    //spring-cloud
    const val SPRING_CLOUD_VERSION = ""
    const val SPRING_CLOUD_GATEWAY_VERSION = ""

    //spring-cloud-alibaba
    const val SPRING_CLOUD_ALIBABA_VERSION = ""

    //dubbo
    const val DUBBO_VERSION = ""

    //spring-boot
    const val SPRING_BOOT_VERSION = ""
    const val SPRING_DEPENDENCY_MANAGEMENT_VERSION = ""

    const val LOMBOK_VERSION = ""

    const val SITE_GRADLE_PLUGIN_VERSION = "1.0.2"
    const val KOTLIN_VERSION = "1.9.10"
    const val KOTLIN_STDLIB_VERSION = KOTLIN_VERSION
    const val CORE_KTX_VERSION = ""
    const val APPCOMPAT_VERSION = ""
    const val CONSTRAINTLAYOUT_VERSION = ""
    const val JUNIT_VERSION = "4.13.2"
    const val ANDROIDX_JUNIT_VERSION = ""
    const val ESPRESSO_CORE_VERSION = ""
    const val MATERIAL_VERSION = ""

    const val SUPPORT_LIB_VERSION = ""
    const val RETROFIT_VERSION = ""
    const val GLIDE_VERSION = ""
    const val GSON_VERSION = "2.11.0"
    const val EVENTBUS_VERSION = ""
    const val SOUL_PERMISSION_VERSION = ""
    const val NICE_DIALOG_VERSION = ""
    const val COLOR_TRACK_TAB_VERSION = ""
    const val ROOM_VERSION =  ""

    const val JACKSON_MODULE_KOTLIN_VERSION = ""
    const val FAST_JSON_VERSION = ""
    const val SLF4J_VERSION = "1.7.36"
    const val LOGBACK_VERSION = "1.2.13"
    const val LOGSTASH_LOGBACK_ENCODER_VERSION = ""
    const val APM_TOOLKIT_LOGBACK1_X_VERSION = ""
    const val ARTHAS_SPRING_BOOT_STARTER_VERSION = ""
    const val BCPROV_JDK15ON_VERSION = "1.70"
    const val HUTOOL_VERSION = ""
    const val COMMON_LANG3_VERSION = "3.13.0"
    const val EASY_EXCEL_VERSION = ""
    const val EASY_CAPTCHA_VERSION = ""
    const val GUAVA_VERSION = "33.2.1-jre"
    const val MYSQL8_VERSION = ""
    const val MYSQL6_VERSION = ""
    const val MYSQL5_VERSION = ""
    const val COMPILEFLOW_VERSION = ""
    const val SPRING_CLOUD_STARTER_BOOTSTRAP_VERSION = ""
    const val HTTPCLIENT_VERSION = "4.5.14"
    const val HTTPCLIENT5_VERSION = "5.2.1"
    const val OKHTTP_VERSION = "4.11.0"
    const val OKIO = "3.9.0"
    const val BCPROV_JDK15TO18_VERSION = "1.78.1"
    const val FAST_JSON2_VERSION = "2.0.51"
    const val FAST_JSON2KOTLIN_VERSION = "2.0.51"
    const val JAVAHOST_VERSION = "0.9.12"
    const val VAVR_VERSION = "0.10.4"
    const val COLLECTIONS4_VERSION = "4.4"
    const val COMMONS_CODEC_VERSION = "1.16.0"
    const val KOTLINX_SERIALIZATION_JSON_VERSION = "1.6.0"
    const val ALIPAY_SDK_JAVA_VERSION = "4.39.123.ALL"
}

// ---------------------------------------------------------- Library ----------------------------------------------------------  
//系统库
const val stdlib_jdk8 = "stdlib-jdk8"
const val kotlin_stdlib_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${VERSION.KOTLIN_VERSION}"
const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${VERSION.KOTLIN_STDLIB_VERSION}"
const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${VERSION.KOTLIN_STDLIB_VERSION}"
@Suppress("unused")
const val kotlin_script_runtime = "org.jetbrains.kotlin:kotlin-script-runtime:${VERSION.KOTLIN_STDLIB_VERSION}"
@Suppress("unused")
const val kotlin_test = "org.jetbrains.kotlin:kotlin-test:${VERSION.KOTLIN_STDLIB_VERSION}"
@Suppress("unused")
const val kotlin_maven_allpen = "org.jetbrains.kotlin:kotlin-maven-allopen:${VERSION.KOTLIN_STDLIB_VERSION}"
@Suppress("unused")
const val kotlin_allpen = "org.jetbrains.kotlin:kotlin-allopen:${VERSION.KOTLIN_STDLIB_VERSION}"
@Suppress("unused")
const val kotlin_noarg = "org.jetbrains.kotlin:kotlin-noarg:${VERSION.KOTLIN_STDLIB_VERSION}"
@Suppress("unused")
const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${VERSION.KOTLIN_STDLIB_VERSION}"
const val site_gradle_plugin = "com.github.starestarrysky.site-gradle-plugin"
const val jvm = "jvm"

@Suppress("unused")
const val core_ktx = "androidx.core:core-ktx:${VERSION.CORE_KTX_VERSION}"
@Suppress("unused")
const val appcompat = "androidx.appcompat:appcompat:${VERSION.APPCOMPAT_VERSION}"
@Suppress("unused")
const val constraintlayout = "androidx.constraintlayout:constraintlayout:${VERSION.CONSTRAINTLAYOUT_VERSION}"
const val junit = "junit:junit:${VERSION.JUNIT_VERSION}"
@Suppress("unused")
const val androidx_junit = "androidx.test.ext:junit:${VERSION.ANDROIDX_JUNIT_VERSION}"
@Suppress("unused")
const val espresso_core = "androidx.test.espresso:espresso-core:${VERSION.ESPRESSO_CORE_VERSION}"
@Suppress("unused")
const val material = "com.google.android.material:material:${VERSION.MATERIAL_VERSION}"

//三方库
@Suppress("unused")
const val retrofit = "com.squareup.retrofit2:retrofit:${VERSION.RETROFIT_VERSION}"
@Suppress("unused")
const val glide = "com.github.bumptech.glide:glide:${VERSION.GLIDE_VERSION}"
const val gson = "com.google.code.gson:gson:${VERSION.GSON_VERSION}"
@Suppress("unused")
const val eventbus = "org.greenrobot:eventbus:${VERSION.EVENTBUS_VERSION}"
@Suppress("unused")
const val soulPermission = "com.qw:soulpermission:${VERSION.SOUL_PERMISSION_VERSION}"
@Suppress("unused")
const val niceDialog =  "com.github.SheHuan:NiceDialog:${VERSION.NICE_DIALOG_VERSION}"
@Suppress("unused")
const val colorTrackTab = "com.github.hanlonglin:ColorTrackTabLayout:${VERSION.COLOR_TRACK_TAB_VERSION}"
@Suppress("unused")
const val httpclient = "org.apache.httpcomponents:httpclient:${VERSION.HTTPCLIENT_VERSION}"
const val httpclient5 = "org.apache.httpcomponents.client5:httpclient5:${VERSION.HTTPCLIENT5_VERSION}"
const val okhttp = "com.squareup.okhttp3:okhttp:${VERSION.OKHTTP_VERSION}"
const val okio = "com.squareup.okio:okio:${VERSION.OKIO}"
const val bcprovJdk15to18 = "org.bouncycastle:bcprov-jdk15to18:${VERSION.BCPROV_JDK15TO18_VERSION}"
const val fastjson2 = "com.alibaba.fastjson2:fastjson2:${VERSION.FAST_JSON2_VERSION}"
const val fastjson2kotlin = "com.alibaba.fastjson2:fastjson2-kotlin:${VERSION.FAST_JSON2KOTLIN_VERSION}"
const val javahost = "io.leopard:javahost:${VERSION.JAVAHOST_VERSION}"
const val vavr = "io.vavr:vavr:${VERSION.VAVR_VERSION}"
const val commons_collections4 = "org.apache.commons:commons-collections4:${VERSION.COLLECTIONS4_VERSION}"
const val commons_codec = "commons-codec:commons-codec:${VERSION.COMMONS_CODEC_VERSION}"
const val kotlinx_serialization_json = "org.jetbrains.kotlinx:kotlinx-serialization-json:${VERSION.KOTLINX_SERIALIZATION_JSON_VERSION}"
const val alipay_sdk_java = "com.alipay.sdk:alipay-sdk-java:${VERSION.ALIPAY_SDK_JAVA_VERSION}"

@Suppress("unused")
const val jackson_module_kotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:${VERSION.JACKSON_MODULE_KOTLIN_VERSION}"
@Suppress("unused")
const val fastjson = "com.alibaba:fastjson:${VERSION.FAST_JSON_VERSION}"
@Suppress("unused")
const val spring_cloud_dependencies = "org.springframework.cloud:spring-cloud-dependencies:${VERSION.SPRING_CLOUD_VERSION}"
@Suppress("unused")
const val spring_cloud_alibaba_dependencies = "com.alibaba.cloud:spring-cloud-alibaba-dependencies:${VERSION.SPRING_CLOUD_ALIBABA_VERSION}"
@Suppress("unused")
const val spring_cloud_starter_bootstrap = "org.springframework.cloud:spring-cloud-starter-bootstrap:${VERSION.SPRING_CLOUD_STARTER_BOOTSTRAP_VERSION}"

@Suppress("unused")
const val spring_boot_starter_web = "org.springframework.boot:spring-boot-starter-web:${VERSION.SPRING_BOOT_VERSION}"
@Suppress("unused")
const val spring_boot_devtools = "org.springframework.boot:spring-boot-devtools"
@Suppress("unused")
const val arthas_spring_boot_starter = "com.taobao.arthas:arthas-spring-boot-starter:${VERSION.ARTHAS_SPRING_BOOT_STARTER_VERSION}"


@Suppress("unused")
const val room =  "androidx.room:room-runtime:${VERSION.ROOM_VERSION}"
@Suppress("unused")
const val room_compiler =  "androidx.room:room-compiler:${VERSION.ROOM_VERSION}"

@Suppress("unused")
const val lombok = "org.projectlombok:lombok:${VERSION.LOMBOK_VERSION}"
@Suppress("unused")
const val bcprov_jdk15on = "org.bouncycastle:bcprov-jdk15on:${VERSION.BCPROV_JDK15ON_VERSION}"
@Suppress("unused")
const val hutool_all = "cn.hutool:hutool-all:${VERSION.HUTOOL_VERSION}"
const val common_lang3 = "org.apache.commons:commons-lang3:${VERSION.COMMON_LANG3_VERSION}"
@Suppress("unused")
const val easyexcel = "com.alibaba:easyexcel:${VERSION.EASY_EXCEL_VERSION}"
@Suppress("unused")
const val easy_captcha = "com.github.whvcse:easy-captcha:${VERSION.EASY_CAPTCHA_VERSION}"
const val guava = "com.google.guava:guava:${VERSION.GUAVA_VERSION}"

//dubbo
@Suppress("unused")
const val dubbo = "org.apache.dubbo:dubbo-spring-boot-starter:${VERSION.DUBBO_VERSION}"

//work flow
@Suppress("unused")
const val compileflow = "com.alibaba.compileflow:compileflow:${VERSION.COMPILEFLOW_VERSION}"

//mysql
@Suppress("unused")
const val mysql8 = "mysql:mysql-connector-java:${VERSION.MYSQL8_VERSION}"
@Suppress("unused")
const val mysql5 = "mysql:mysql-connector-java:${VERSION.MYSQL5_VERSION}"

//log
const val slf4j_api = "org.slf4j:slf4j-api:${VERSION.SLF4J_VERSION}"
@Suppress("unused")
const val logback_core = "ch.qos.logback:logback-core:${VERSION.LOGBACK_VERSION}"
const val logback_classic = "ch.qos.logback:logback-classic:${VERSION.LOGBACK_VERSION}"
@Suppress("unused")
const val logstash_logback_encoder = "net.logstash.logback:logstash-logback-encoder:${VERSION.LOGSTASH_LOGBACK_ENCODER_VERSION}"
@Suppress("unused")
const val apm_toolkit_logback_1_x = "org.apache.skywalking:apm-toolkit-logback-1.x:${VERSION.APM_TOOLKIT_LOGBACK1_X_VERSION}"

//plugins
@Suppress("unused")
const val spring_boot_gradle_plugin = "org.springframework.boot:spring-boot-gradle-plugin:${VERSION.SPRING_BOOT_VERSION}"