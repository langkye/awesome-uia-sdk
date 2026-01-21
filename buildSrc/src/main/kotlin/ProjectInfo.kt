// ---------------------------------------------------------- Project info ----------------------------------------------------------
const val GROUP_ID = "cn.lnkdoc.sdk"
const val PROJECT_VERSION = "3.x-SNAPSHOT"
const val DESCRIPTION = """
    Awesome Uia SDK for Java
    Copyright © 2023 lnkdoc All rights reserved.
"""

const val TARGET_JAVA_VERSION = 8
const val TOOLCHAIN_JAVA_VERSION = 17
const val BOM_NAME = "awesome-uia-bom"
const val ALL_NAME = "awesome-uia-all-sdk"
const val CORE_NAME = "awesome-uia-sdk-core"
const val CORE = "awesome-uia-sdk-common:$CORE_NAME"
const val DEPENDENCIES_NAME = "awesome-uia-sdk-dependencies"
const val BUILD_LOGIC_NAME = "build-logic"
const val COMMON_NAME = "awesome-uia-sdk-common"
const val SUPPORT_NAME = "awesome-uia-sdk-support"

fun resolveSupportModuleName(shortName: String): String {
    return "awesome-uia-$shortName-sdk"
}

fun isJavaPlatform(name: String): Boolean {
    return name === BOM_NAME || name === DEPENDENCIES_NAME
}

fun isInternalModule(name: String): Boolean {
    return listOf(CORE, BOM_NAME, BUILD_LOGIC_NAME, COMMON_NAME, SUPPORT_NAME).contains(name)
}