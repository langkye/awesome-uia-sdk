package cn.lnkdoc.sdk.uia.instance.gitee.domain

import com.alibaba.fastjson2.annotation.JSONField

/**
 * access_token
 * 
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
     * 令牌类型
     */
    @set:JSONField(name = "token_type")
    var tokenType: String? = null
    /**
     * expires_in
     */
    @set:JSONField(name = "expires_in")
    var expiresIn: Int? = null
    /**
     * refresh_token
     */
    @set:JSONField(name = "refresh_token")
    var refreshToken: String? = null
    /**
     * created_at
     */
    @set:JSONField(name = "created_at")
    var createdAt: String? = null
    /**
     * scope
     */
    @set:JSONField(name = "scope")
    var scope: String? = null

    @set:JSONField(name = "message")
    var message: String? = null
    @set:JSONField(name = "error")
    var error: String? = null
        set(value) {
            field=value
            success = false
            if (message == null) {
                message = value
            }
        }
    @set:JSONField(name = "error_description")
    var errorDescription: String? = null
        set(value) {
            field=value
            success = false
            message = value
        }
    @set:JSONField(name = "error_uri")
    var errorUri: String? = null
        set(value) {
            field=value
            success = false
        }
    var success: Boolean = true
}