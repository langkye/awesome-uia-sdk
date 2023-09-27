package cn.lnkdoc.sdk.uia.common.util

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import org.apache.commons.lang3.StringUtils

/**
 *
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
object Assert {
    /**
     * required
     *
     * @param obj obj
     */
    @JvmStatic
    fun required(obj: Any?) {
        required(obj, null)
    }

    /**
     * required
     *
     * @param obj obj
     * @param message message
     */
    @JvmStatic
    fun required(obj: Any?, message: String?) {
        if (obj == null) {
            val msg = "the argument is null"
            throw UiaException(if (StringUtils.isBlank(message)) msg else message)
        }
        if (obj is String) {
            if ("" == obj.trim { it <= ' ' }) {
                val msg = "the string argument is blank"
                throw UiaException(if (StringUtils.isBlank(message)) msg else message)
            }
        }
        if (obj is Collection<*>) {
            if (obj.isEmpty()) {
                val msg = "the collection argument is empty"
                throw UiaException(if (StringUtils.isBlank(message)) msg else message)
            }
        }
        if (obj is Map<*, *>) {
            if (obj.isEmpty()) {
                val msg = "the map argument is empty"
                throw UiaException(if (StringUtils.isBlank(message)) msg else message)
            }
        }
    }
}