package cn.lnkdoc.sdk.uia.instance.github

import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.UiaResponse
import cn.lnkdoc.sdk.uia.instance.AbstractInstance
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.github.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.github.client.GithubUiaClient
import cn.lnkdoc.sdk.uia.instance.github.property.GithubProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast")
class GithubSdkInstance(property: GithubProperty) : AbstractInstance(), ISdkInstance {
    /**
     * constructor
     */
    init {
        client = GithubUiaClient.getInstance(property)
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
