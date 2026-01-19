package cn.lnkdoc.sdk.uia.instance.jban

import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.UiaResponse
import cn.lnkdoc.sdk.uia.instance.AbstractInstance
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.jban.client.JbanUiaClient
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty

/**
 * @author langkye
 */
@Suppress("Unchecked_cast", "unused")
class JbanSdkInstance(property: JbanProperty) : AbstractInstance(), ISdkInstance {
    /**
     * instance
     */
    init {
        client = JbanUiaClient.getInstance(property)
    }

    /**
     * get accessToken
     *
     * @param r code
     * @return accessToken
     */
    override fun <T, R> getAccessToken(r: R): UiaResponse<T> {
        return client.execute<Any>((r as IUiaRequest)) as UiaResponse<T>
    }

    /**
     * get UserInfo
     *
     * @param accessToken r
     * @return UserInfo
     */
    override fun <T, R> getUserInfo(accessToken: R): UiaResponse<T> {
        return client.execute<Any>((accessToken as IUiaRequest)) as UiaResponse<T>
    }
}