package cn.lnkdoc.sdk.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        //pluginManager.apply("org.springframework.boot")
        //pluginManager.apply("io.spring.dependency-management")
        pluginManager.apply("org.jetbrains.kotlin.jvm")
        //pluginManager.apply("org.jetbrains.kotlin.plugin.spring")

        dependencies {
            // 使用 loong-platform-bom 统一版本
            add("implementation", platform(project(":awesome-uia-bom")))

            //add("implementation", "org.springframework.boot:spring-boot-starter-actuator")
            //add("implementation", "org.springframework.boot:spring-boot-starter-validation")
            add("implementation", "org.jetbrains.kotlin:kotlin-reflect")

            //add("testImplementation", "org.springframework.boot:spring-boot-starter-test")
        }

        tasks.withType<KotlinCompile>().configureEach {
            compilerOptions {
                // Kotlin 目前最高支持到 JVM_21，JDK 用 25 也没问题，编译出的字节码是 21
                jvmTarget.set(JvmTarget.JVM_1_8)

                // 等价于原来的 freeCompilerArgs += "-Xjsr305=strict"
                freeCompilerArgs.add("-Xjsr305=strict")
            }
        }
        
        tasks.withType<Test>().configureEach {
            useJUnitPlatform()
        }
    }
}
