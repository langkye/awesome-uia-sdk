package cn.lnkdoc.sdk.uia.instance.yztoon

import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.UiaResponse
import cn.lnkdoc.sdk.uia.instance.AbstractInstance
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.yztoon.client.YztoonUiaClient
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty

/**
 * @author langkye
 */
@Suppress("Unchecked_cast", "unused")
class YztoonSdkInstance(property: YztoonProperty) : AbstractInstance(), ISdkInstance {
    /**
     * constructor
     */
    init {
        client = YztoonUiaClient.getInstance(property)
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
     * @param accessToken accessToken
     * @return UserInfo
     */
    override fun <T, R> getUserInfo(accessToken: R): UiaResponse<T> {
        return client.execute<Any>((accessToken as IUiaRequest)) as UiaResponse<T>
    }
}