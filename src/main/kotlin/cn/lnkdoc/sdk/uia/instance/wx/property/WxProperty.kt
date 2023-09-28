package cn.lnkdoc.sdk.uia.instance.wx.property

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class WxProperty : IUiaProperty {
    /**
     * printStack
     */
    var printStack = false
    /**
     * domain
     */
    var domain = "https://api.weixin.qq.com"
    /**
     * clientId
     */
    var clientId: String? = null
    /**
     * clientSecret
     */
    var clientSecret: String? = null
    /**
     * 通过code换取access_token	1万/分钟
     */
    var accessTokenPath = "/sns/oauth2/access_token"
    /**
     * 刷新access_token	5万/分钟
     */
    var refreshTokenPath = "/sns/oauth2/refresh_token"
    /**
     * accessTokenStatusPath
     */
    var accessTokenStatusPath = "sns/auth"
    /**
     * 获取用户基本信息	5万/分钟
     */
    var userInfoPath = "/sns/userinfo"
    /**
     * grantType
     */
    var grantType = UiaConstants.GRANT_TYPE_CODE
    /**
     * refreshTokenGrantType
     */
    var refreshTokenGrantType = UiaConstants.GRANT_TYPE_REFRESH

    /**
     * getter
     *
     * @return printStack
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }
}
