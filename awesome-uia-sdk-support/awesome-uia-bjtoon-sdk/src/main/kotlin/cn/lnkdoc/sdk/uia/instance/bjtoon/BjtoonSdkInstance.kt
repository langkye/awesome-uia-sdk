package cn.lnkdoc.sdk.uia.instance.bjtoon

import cn.lnkdoc.sdk.uia.common.response.UiaResponse
import cn.lnkdoc.sdk.uia.instance.AbstractInstance
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.bjtoon.client.BjtoonUiaClient.Companion.getInstance
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.LogoutRequest
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.SsoStatusRequest
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.UserInfoRequest


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast")
open class BjtoonSdkInstance(property: BjtoonProperty) : AbstractInstance(), ISdkInstance {
    /**
     * constructor
     */
    init {
        client = getInstance(property)
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

    /**
     * logout
     *
     * @param accessToken accessToken
     * @return UserInfo
     */
    fun <T, R> logout(accessToken: R): UiaResponse<T> {
        return client.execute<Any>((accessToken as LogoutRequest)) as UiaResponse<T>
    }

    /**
     * get LoginStatus
     *
     * @param accessToken accessToken
     * @return UserInfo
     */
    fun <T, R> getLoginStatus(accessToken: R): UiaResponse<T> {
        return client.execute<Any>((accessToken as SsoStatusRequest)) as UiaResponse<T>
    }
}
