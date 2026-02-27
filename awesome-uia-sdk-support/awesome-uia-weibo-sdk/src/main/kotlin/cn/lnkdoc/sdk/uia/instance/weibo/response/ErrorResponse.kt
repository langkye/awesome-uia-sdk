package cn.lnkdoc.sdk.uia.instance.weibo.response

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
open class ErrorResponse {
    /**
     * raw
     */
    var raw: String? = null
    /**
     * message
     */
    var message: String? = null
    /**
     * success
     */
    var success: Boolean = true
    /**
     * error_code
     */
    @set:UiaJsonField(name = "error_code")
    var errorCode: String? = null
    /**
     * request
     */
    @set:UiaJsonField(name = "request")
    var request: String? = null
    /**
     * error_uri
     */
    @set:UiaJsonField(name = "error_uri")
    var errorUri: String? = null
    /**
     * error
     */
    @set:UiaJsonField(name = "error")
    var error: String? = null
        set(value) {
            field = value
            success = false
            message = value
        }
    /**
     * error_description
     */
    @set:UiaJsonField(name = "error_description")
    var errorDescription: String? = null
        set(value) {
            field = value
            success = false
            if (message == null) {
                message = value
            }
        }
}
