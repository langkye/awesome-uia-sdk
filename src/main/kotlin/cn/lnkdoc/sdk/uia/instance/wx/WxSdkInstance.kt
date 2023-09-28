package cn.lnkdoc.sdk.uia.instance.wx

import cn.lnkdoc.sdk.uia.common.response.UiaResponse
import cn.lnkdoc.sdk.uia.instance.AbstractInstance
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.wx.client.WxUiaClient
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty
import cn.lnkdoc.sdk.uia.instance.wx.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.wx.request.UserInfoRequest

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class WxSdkInstance(property: WxProperty?) : AbstractInstance(), ISdkInstance {
    /**
     * constructor
     */
    init {
        client = WxUiaClient.getInstance(property!!)
    }

    /**
     * get accessToken
     *
     * @param r code
     * @return accessToken
     */
    override fun <T, R> getAccessToken(r: R): UiaResponse<T> {
        return client.execute<Any>((r as AccessTokenRequest)) as UiaResponse<T>
    }

    /**
     * get UserInfo
     *
     * @param accessToken accessToken
     * @return UserInfo
     */
    override fun <T, R> getUserInfo(accessToken: R): UiaResponse<T> {
        return client.execute<Any>((accessToken as UserInfoRequest)) as UiaResponse<T>
    }
}
