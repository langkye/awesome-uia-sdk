rootProject.name = "build-logic"

dependencyResolutionManagement {
    // 是否限制子工程定义自己的 repositories
    //repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    //repositories {
    //    mavenCentral()
    //}

    // 根 #从 Gradle 7 开始,工程里有"gradle/libs.versions.toml", Gradle 就会自动生成一个名为 libs 的 version catalog，不需要你在 settings.gradle.kts 里再写
    // 引用顶级工程版本管理
    versionCatalogs {
        create("libs") {
            //from(files("gradle/libs.versions.toml"))
            from(files("../gradle/libs.versions.toml"))
        }
    }
}