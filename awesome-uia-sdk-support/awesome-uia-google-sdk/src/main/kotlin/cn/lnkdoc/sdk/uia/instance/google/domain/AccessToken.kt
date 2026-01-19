package cn.lnkdoc.sdk.uia.instance.google.domain

import com.alibaba.fastjson2.annotation.JSONField

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
open class AccessToken {
    /**
     * 访问令牌。通过该令牌调用需要授权类接口
     */
    @set:JSONField(name = "access_token")
    var accessToken: String? = null
    /**
     * refresh_token
     */
    @set:JSONField(name = "refresh_token")
    var refreshToken: String? = null
    /**
     * expires_in
     */
    @set:JSONField(name = "expires_in")
    var expiresIn: Int? = null
    /**
     * scope
     */
    @set:JSONField(name = "scope")
    var scope: String? = null
    /**
     * token_type
     */
    @set:JSONField(name = "token_type")
    var tokenType: String? = null
    /**
     * id_token
     */
    @set:JSONField(name = "id_token")
    var idToken: String? = null
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