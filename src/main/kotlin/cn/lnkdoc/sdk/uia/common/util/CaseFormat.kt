package cn.lnkdoc.sdk.uia.common.util

/**
 *
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("FunctionName")
object CaseFormat {

    /**
     * UPPER_UNDERSCORE_2_LOWER_CAMEL
     *
     * @param string string
     * @return UPPER_UNDERSCORE_2_LOWER_CAMEL
     */
    @JvmStatic
    fun UPPER_UNDERSCORE_2_LOWER_CAMEL(string: String?): String? {
        if (string == null) {
            return null
        }
        val lowerCamelBuilder = StringBuilder()
        val array = string.split("_".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (i in array.indices) {
            var item = array[i]
            if (item.length > 1) {
                item = item.lowercase()
                val head = item.substring(0, 1)
                val tail = item.substring(1)
                lowerCamelBuilder.append(if (i == 0) head else head.uppercase()).append(tail)
            }
        }
        return lowerCamelBuilder.toString()
    }
}