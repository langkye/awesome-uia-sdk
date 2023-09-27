package cn.lnkdoc.sdk.uia.instance.bjtoon.property

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class BjtoonProperty : IUiaProperty {
    /**
     * printStack
     */
    var printStack = false
    /**
     * domain
     */
    lateinit var domain: String
    /**
     * clientId
     */
    lateinit var clientId: String
    /**
     * clientSecret
     */
    lateinit var clientSecret: String
    /**
     * isNeedsDecrypt
     */
    var isNeedsDecrypt = true
    /**
     * grantType
     */
    var grantType = UiaConstants.GRANT_TYPE_CODE
    /**
     * scope
     */
    var scope = UiaConstants.SCOPE_USER_INFO
    /**
     * accessTokenPath
     */
    var accessTokenPath = "/api/oauth/getAccessToken"
    /**
     * userInfoPath
     */
    var userInfoPath = "/api/info/getUserInfo"
    /**
     * ssoStatusPath
     */
    var ssoStatusPath = "/api/login/getSSOStatus"
    /**
     * logoutPath
     */
    var logoutPath = "/api/login/doSSOLogout"
    /**
     * authTicketPath
     */
    var authTicketPath = "/api/oauth/getAuthTicket"
    /**
     * registerPath
     */
    var registerPath = "/open/api/register/doUserRegisterByCertInfo"
    /**
     * redirectUri
     */
    var redirectUri = ""
    /**
     * getter
     *
     * @return printStack
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }
}

