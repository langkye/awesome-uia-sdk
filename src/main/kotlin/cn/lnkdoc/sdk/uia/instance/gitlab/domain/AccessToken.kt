package cn.lnkdoc.sdk.uia.instance.gitlab.domain

import com.alibaba.fastjson2.annotation.JSONField

/**
 * @document https://developers.google.com/identity/openid-connect/openid-connect?hl=zh-cn#discovery
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class AccessToken {
    /**
     * access_token
     */
    @set:JSONField(name = "access_token")
    var accessToken: String? = null

    /**
     * created_at
     */
    @JSONField(name = "created_at")
    var createdAt: Int? = null

    /**
     * expires_in
     */
    @JSONField(name = "expires_in")
    var expiresIn: Int? = null

    /**
     * refresh_token
     */
    @JSONField(name = "refresh_token")
    var refreshToken: String?
            /**
             * scope
             */
            = null
    @JSONField(name = "scope")
    var scope: String? = null

    /**
     * token_type
     */
    @JSONField(name = "token_type")
    var tokenType: String? = null
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