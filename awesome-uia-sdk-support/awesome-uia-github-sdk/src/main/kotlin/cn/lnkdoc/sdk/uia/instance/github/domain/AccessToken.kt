package cn.lnkdoc.sdk.uia.instance.github.domain

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class AccessToken {
    /**
     * accessToken
     */
    @set:UiaJsonField(name = "access_token")
    var accessToken: String? = null

    /**
     * tokenType
     */
    @set:UiaJsonField(name = "token_type")
    var tokenType: String? = null

    /**
     * scope
     */
    @set:UiaJsonField(name = "scope")
    var scope: String? = null

    /**
     * error
     */
    @set:UiaJsonField(name = "error")
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
    @set:UiaJsonField(name = "error_description")
    var errorDescription: String? = null
        set(value) {
            field=value
            success = false
            message = value
        }

    /**
     * error_uri
     */
    @set:UiaJsonField(name = "error_uri")
    var errorUri: String? = null
        set(value) {
            field=value
            success = false
        }
    
    var success: Boolean = true
    var message: String? = null
}
