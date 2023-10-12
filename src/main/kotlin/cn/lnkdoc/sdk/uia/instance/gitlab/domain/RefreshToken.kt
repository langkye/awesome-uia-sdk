package cn.lnkdoc.sdk.uia.instance.gitlab.domain

import com.alibaba.fastjson.annotation.JSONField

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class RefreshToken {
    /**
     * access_token
     */
    @JSONField(name = "access_token")
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
    var refreshToken: String? = null

    /**
     * scope
     */
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
        set(value) {
            field = value
            success = false
        }
    /**
     * success
     */
    var success: Boolean = true
    /**
     * error
     */
    @set:com.alibaba.fastjson2.annotation.JSONField(name = "error")
    var error: String? = null
        set(value) {
            field = value
            success = false
            message = value
        }
    /**
     * error_description
     */
    @set:com.alibaba.fastjson2.annotation.JSONField(name = "error_description")
    var errorDescription: String? = null
        set(value) {
            field = value
            success = false
            if (message == null) {
                message = value
            }
        }
}