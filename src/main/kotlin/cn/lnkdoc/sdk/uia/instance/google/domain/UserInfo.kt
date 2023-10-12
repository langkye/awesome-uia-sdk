package cn.lnkdoc.sdk.uia.instance.google.domain

import com.alibaba.fastjson2.annotation.JSONField

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
    @set:JSONField(name = "sub")
    var sub: String? = null
    /**
     * given_name
     */
    @set:JSONField(name = "given_name")
    var givenName: String? = null
    /**
     * family_name
     */
    @set:JSONField(name = "family_name")
    var familyName: String? = null
    /**
     * locale
     */
    @set:JSONField(name = "locale")
    var locale: String? = null
    /**
     * name
     */
    @set:JSONField(name = "name")
    var name: String? = null
    /**
     * picture
     */
    @set:JSONField(name = "picture")
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