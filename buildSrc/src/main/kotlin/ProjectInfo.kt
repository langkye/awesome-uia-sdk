// ---------------------------------------------------------- Project info ----------------------------------------------------------
const val GROUP_ID = "cn.lnkdoc.sdk"
const val PROJECT_VERSION = "3.x-SNAPSHOT"
const val DESCRIPTION = """
    Awesome Uia SDK for Java
    Copyright © 2023 lnkdoc All rights reserved.
"""

const val BOM = "awesome-uia-sdk-bom"
const val ALL_MODULE = "awesome-uia-all-sdk"
const val CORE_MODULE = "awesome-uia-sdk-core"
const val CORE = "awesome-uia-sdk-common:$CORE_MODULE"

fun resolveSupportModuleName(shortName: String): String {
    return "awesome-uia-$shortName-sdk"
}
