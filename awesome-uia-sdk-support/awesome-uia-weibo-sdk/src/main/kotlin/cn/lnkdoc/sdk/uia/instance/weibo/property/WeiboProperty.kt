package cn.lnkdoc.sdk.uia.instance.weibo.property

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class WeiboProperty : IUiaProperty {
    /**
     * printStack
     */
    var printStack = false
    /**
     * domain
     */
    var domain: String = "https://api.weibo.com"
    /**
     * clientId
     */
    lateinit var clientId: String
    /**
     * clientSecret
     */
    lateinit var clientSecret: String
    /**
     * redirect_uri
     */
    var redirectUri: String? = null
    /**
     * accessTokenUrl
     */
    var accessTokenUrl = "https://api.weibo.com/oauth2/access_token"
    /**
     * uidUrl
     */
    var uidUrl = "https://api.weibo.com/2/account/get_uid.json"
    /**
     * userInfoUrl
     */
    var userInfoUrl = "https://api.weibo.com/2/users/show.json"
    
    /**
     * isPrintStack
     *
     * @return boolean
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }
}