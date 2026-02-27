package cn.lnkdoc.sdk.uia.instance.google.domain

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


/**
 * @document https://developers.google.com/identity/openid-connect/openid-connect?hl=zh-cn#discovery
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class UserInfo {
    /**
     * sub
     */
    @set:UiaJsonField(name = "sub")
    var sub: String? = null
    /**
     * given_name
     */
    @set:UiaJsonField(name = "given_name")
    var givenName: String? = null
    /**
     * family_name
     */
    @set:UiaJsonField(name = "family_name")
    var familyName: String? = null
    /**
     * locale
     */
    @set:UiaJsonField(name = "locale")
    var locale: String? = null
    /**
     * name
     */
    @set:UiaJsonField(name = "name")
    var name: String? = null
    /**
     * picture
     */
    @set:UiaJsonField(name = "picture")
    var picture: String? = null
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
