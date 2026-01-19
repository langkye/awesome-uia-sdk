package cn.lnkdoc.sdk.uia.instance.github.domain

import com.alibaba.fastjson2.annotation.JSONField

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class AccessToken {
    /**
     * accessToken
     */
    @set:JSONField(name = "access_token")
    var accessToken: String? = null

    /**
     * tokenType
     */
    @set:JSONField(name = "token_type")
    var tokenType: String? = null

    /**
     * scope
     */
    @set:JSONField(name = "scope")
    var scope: String? = null

    /**
     * error
     */
    @set:JSONField(name = "error")
    var error: String? = null
        set(value) {
            field=value
            success = false
            if (message == null) {
                message = value
            }
        }

    /**
     * error_description
     */
    @set:JSONField(name = "error_description")
    var errorDescription: String? = null
        set(value) {
            field=value
            success = false
            message = value
        }

    /**
     * error_uri
     */
    @set:JSONField(name = "error_uri")
    var errorUri: String? = null
        set(value) {
            field=value
            success = false
        }
    
    var success: Boolean = true
    var message: String? = null
}