package cn.lnkdoc.sdk.uia.instance.gitlab.domain

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class RefreshToken {
    /**
     * access_token
     */
    @set:UiaJsonField(name = "access_token")
    var accessToken: String? = null

    /**
     * created_at
     */
    @set:UiaJsonField(name = "created_at")
    var createdAt: Int? = null

    /**
     * expires_in
     */
    @set:UiaJsonField(name = "expires_in")
    var expiresIn: Int? = null

    /**
     * refresh_token
     */
    @set:UiaJsonField(name = "refresh_token")
    var refreshToken: String? = null

    /**
     * scope
     */
    @set:UiaJsonField(name = "scope")
    var scope: String? = null

    /**
     * token_type
     */
    @set:UiaJsonField(name = "token_type")
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
