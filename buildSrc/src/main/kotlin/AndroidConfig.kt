@Suppress("unused", "Property_Name")
object AndroidConfig {
    var compileSdkVersion = 29
    var buildToolsVersion = "29.0.3"
    val defaultConfig = DefaultConfig()
 
    class DefaultConfig {
        val applicationId = "cn.lnkdoc.sdk"
        val minSdkVersion = 16
        val targetSdkVersion = 29
        val versionCode = 1
        val versionName = "1.0"
    }
}