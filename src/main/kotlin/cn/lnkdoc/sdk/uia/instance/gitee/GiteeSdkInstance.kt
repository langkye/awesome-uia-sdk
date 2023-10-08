package cn.lnkdoc.sdk.uia.instance.gitee

import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.UiaResponse
import cn.lnkdoc.sdk.uia.instance.AbstractInstance
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.gitee.client.GiteeUiaClient
import cn.lnkdoc.sdk.uia.instance.gitee.property.GiteeProperty
import cn.lnkdoc.sdk.uia.instance.gitee.request.AccessTokenRequest

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast")
class GiteeSdkInstance(property: GiteeProperty) : AbstractInstance(), ISdkInstance {
    /**
     * constructor
     */
    init {
        client = GiteeUiaClient.getInstance(property)
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
        return client.execute<Any>((accessToken as IUiaRequest)) as UiaResponse<T>
    }
}
