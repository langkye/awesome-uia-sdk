package cn.lnkdoc.sdk.uia.instance.weibo.response

import com.alibaba.fastjson2.annotation.JSONField

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
    @set:JSONField(name = "error_code")
    var errorCode: String? = null
    /**
     * request
     */
    @set:JSONField(name = "request")
    var request: String? = null
    /**
     * error_uri
     */
    @set:JSONField(name = "error_uri")
    var errorUri: String? = null
    /**
     * error
     */
    @set:JSONField(name = "error")
    var error: String? = null
        set(value) {
            field = value
            success = false
            message = value
        }
    /**
     * error_description
     */
    @set:JSONField(name = "error_description")
    var errorDescription: String? = null
        set(value) {
            field = value
            success = false
            if (message == null) {
                message = value
            }
        }
}