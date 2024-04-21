package cn.lnkdoc.sdk.uia.instance.bccastle

import cn.lnkdoc.sdk.uia.common.response.UiaResponse
import cn.lnkdoc.sdk.uia.instance.AbstractInstance
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.bccastle.client.BccastleUiaClient
import cn.lnkdoc.sdk.uia.instance.bccastle.property.BccastleProperty
import cn.lnkdoc.sdk.uia.instance.bccastle.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.bccastle.request.UserInfoRequest

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class BccastleSdkInstance(property: BccastleProperty?) : AbstractInstance(), ISdkInstance {
    /**
     * constructor
     */
    init {
        client = BccastleUiaClient.getInstance(property!!)
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
