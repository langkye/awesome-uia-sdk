plugins {
    `kotlin-dsl`
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

// 这里不再用 libs catalog，直接写插件依赖坐标
dependencies {
    //implementation("org.springframework.boot:spring-boot-gradle-plugin:${libs.versions.springBoot.get()}")
    //implementation("io.spring.gradle:dependency-management-plugin:${libs.versions.springDependencyManagement.get()}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
}

// 注册插件
gradlePlugin {
    plugins {
        register("UiaLibrary") {
            id = "uia.library"
            implementationClass = "cn.lnkdoc.sdk.plugin.LibraryConventionPlugin"
        }
    }
}