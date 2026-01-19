package cn.lnkdoc.sdk.uia.instance.alipay

import cn.lnkdoc.sdk.uia.common.response.UiaResponse
import cn.lnkdoc.sdk.uia.instance.AbstractInstance
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.alipay.client.AlipayUiaClient
import cn.lnkdoc.sdk.uia.instance.alipay.property.AlipayProperty
import cn.lnkdoc.sdk.uia.instance.alipay.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.alipay.request.UserInfoRequest


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class AlipaySdkInstance(property: AlipayProperty?) : AbstractInstance(), ISdkInstance {
    /**
     * constructor
     */
    init {
        client = AlipayUiaClient.getInstance(property!!)
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
