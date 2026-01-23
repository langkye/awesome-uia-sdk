package cn.lnkdoc.sdk.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.dependencies

class PlatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        // 只做平台相关的最小约定，避免引入 java/java-library/kotlin 插件
        pluginManager.apply("java-platform")
        pluginManager.apply("maven-publish")

        // 如果你需要统一平台模块的通用配置，可在这里追加
        // 例如：javaPlatform { allowDependencies() }

        // 扩展：让项目声明要管理的版本目录别名
        val ext = extensions.create("uiaPlatform", UiaPlatformExtension::class.java)

        afterEvaluate {
            val libs = extensions.getByType(VersionCatalogsExtension::class.java).named("libs")
            //val mixedAliases = (ext.libraries + ext.bundles).distinct()
            val aliases = (ext.libraries).distinct()

            dependencies {
                constraints {
                    // ① 处理 bundle/provider 形式
                    ext.bundleProviders.forEach { provider ->
                        provider.get().forEach { dep ->
                            add("api", dep)
                        }
                    }

                    // ② 处理 library/provider 形式
                    ext.libraryProviders.forEach { provider ->
                        add("api", provider.get())
                    }

                    // ② 处理字符串形式（bundle or library）
                    //mixedAliases.forEach { alias ->
                    //    val bundleProvider = libs.findBundle(alias)
                    //    if (bundleProvider.isPresent) {
                    //        bundleProvider.get().get().forEach { dep: MinimalExternalModuleDependency ->
                    //            add("api", dep)
                    //        }
                    //    } else {
                    //        val lib = libs.findLibrary(alias)
                    //            .orElseThrow { IllegalArgumentException("未找到版本目录别名/Bundle: $alias") }
                    //        add("api", lib)
                    //    }
                    //}
                    
                    // ③ 处理字符串形式（library alias）
                    aliases.forEach { alias ->
                        val lib = libs.findLibrary(alias)
                            .orElseThrow { IllegalArgumentException("未找到版本目录别名: $alias") }
                        add("api", lib)
                    }
                }
            }
        }
    }
}

open class UiaPlatformExtension {
    val libraries = mutableListOf<String>()
    //val bundles = mutableListOf<String>()
    internal val bundleProviders = mutableListOf<Provider<ExternalModuleDependencyBundle>>()
    internal val libraryProviders = mutableListOf<Provider<MinimalExternalModuleDependency>>()

    fun bundles(vararg providers: Provider<ExternalModuleDependencyBundle>) {
        bundleProviders += providers
    }

    fun libraries(vararg providers: Provider<MinimalExternalModuleDependency>) {
        libraryProviders += providers
    }
}

fun parseRequirement(raw: String?): List<String> {
    if (raw.isNullOrBlank()) return emptyList()
    return raw
        .removePrefix("[")
        .removeSuffix("]")
        .split(",")
        .map { it.trim().removePrefix("\"").removeSuffix("\"") }
        .filter { it.isNotBlank() }
}