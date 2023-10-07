package cn.lnkdoc.sdk.uia.instance.wx.domain

import cn.lnkdoc.sdk.uia.instance.wx.response.WxResponse
import com.alibaba.fastjson2.annotation.JSONField

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class RefreshToken : WxResponse() {
    /**
     * 接口调用凭证
     */
    @set:JSONField(name = "access_token")
    var accessToken: String? = null
    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    @set:JSONField(name = "expires_in")
    var expiresIn: Long? = null
    /**
     * 用户刷新access_token
     */
    @set:JSONField(name = "refresh_token")
    var refreshToken: String? = null
    /**
     * 授权用户唯一标识
     */
    var openid: String? = null
    /**
     * 用户授权的作用域，使用逗号（,）分隔
     * see: [cn.lnkdoc.sdk.uia.instance.wx.Scope]
     */
    var scope: String? = null
    /**
     * 当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。
     */
    var unionid: String? = null
}
