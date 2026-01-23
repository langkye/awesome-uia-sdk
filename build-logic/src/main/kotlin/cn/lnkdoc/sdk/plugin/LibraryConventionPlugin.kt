package cn.lnkdoc.sdk.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.ModuleDependency
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


        // 1) 创建一个“可声明、不可消费、不可解析”的内部配置：只用来挂 BOM
        val internalBomCfg = configurations.maybeCreate("uiaInternalBom").apply {
            isCanBeConsumed = false
            isCanBeResolved = false
        }

        // 2) 把 BOM 依赖声明到这个内部配置上（✅允许声明）
        val internalBom = dependencies.platform(project(":awesome-uia-bom")) as ModuleDependency
        dependencies {
            add(internalBomCfg.name, internalBom)

            add("implementation", "org.jetbrains.kotlin:kotlin-reflect")
        }

        // 3) 让 classpath 配置继承 internalBomCfg（✅不在 classpath 上“声明依赖”，而是继承）
        configurations.matching {
            it.name == "compileClasspath" ||
                    it.name == "runtimeClasspath" ||
                    it.name == "testCompileClasspath" ||
                    it.name == "testRuntimeClasspath"
        }.configureEach {
            extendsFrom(internalBomCfg)
        }

        // 4) kapt 的配置只在 kapt 插件应用后才存在：用 withPlugin 延迟处理
        pluginManager.withPlugin("org.jetbrains.kotlin.kapt") {
            configurations.matching { it.name == "kapt" || it.name == "kaptTest" }.configureEach {
                extendsFrom(internalBomCfg)
            }
        }











        // 内部 BOM：只用于“解析”，不要挂到 implementation/api 这类会发布出去的配置上
        //val internalBom = dependencies.platform(project(":awesome-uia-bom")) as ModuleDependency
        dependencies {
            //// 注意：不要再 add("implementation", platform(...)) 了，会影响发布元数据
            //add("compileClasspath", internalBom)
            //add("runtimeClasspath", internalBom)
            //
            //add("testCompileClasspath", internalBom)
            //add("testRuntimeClasspath", internalBom)
            //
            //// kapt 相关（如果模块启用了 kapt，这里可以提前挂上；未启用时也不会造成太大问题）
            //add("kapt", internalBom)
            //add("kaptTest", internalBom)
            //
            //add("implementation", "org.jetbrains.kotlin:kotlin-reflect")




            // 使用 awesome-uia-bom 统一版本
            //add("implementation", platform(project(":awesome-uia-bom")))
            //add("implementation", platform(project(":aawesome-uia-sdk-dependencies")))

            //add("implementation", "org.springframework.boot:spring-boot-starter-actuator")
            //add("implementation", "org.springframework.boot:spring-boot-starter-validation")
            //add("implementation", "org.jetbrains.kotlin:kotlin-reflect")

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
