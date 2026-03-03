package cn.lnkdoc.sdk.uia.instance.yztoon.response

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
open class YztoonResponse<T> {
    /**
     * code
     */
    @set:UiaJsonField("error")
    var code: String? = null
    /**
     * message
     */
    @set:UiaJsonField("error_description")
    var message: String? = null
    
    fun getError(): String? {
        return code
    }
}