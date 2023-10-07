package cn.lnkdoc.sdk.uia.instance.alipay.converter

import cn.lnkdoc.sdk.uia.common.GrantType
import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.instance.alipay.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.alipay.property.AlipayProperty
import cn.lnkdoc.sdk.uia.instance.alipay.request.AccessTokenRequest
import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.TypeReference
import com.alibaba.fastjson2.parseObject
import com.alipay.api.AlipayClient
import com.alipay.api.AlipayResponse
import com.alipay.api.request.AlipaySystemOauthTokenRequest
import io.vavr.Tuple3

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class AccessTokenConverter : IUiaConverter {
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val alipayResponse = body as AlipayResponse
        val responseBody = alipayResponse.body.parseObject().getString("alipay_system_oauth_token_response")
        val response = JSON.parseObject(responseBody, object : TypeReference<AccessToken?>() {}) as AccessToken
        return response as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val tuple = body as Tuple3<AlipayProperty?, AlipayClient, IUiaRequest> 

        val request = AlipaySystemOauthTokenRequest()
        request.code = tuple._3.body()
        request.grantType = GrantType.AUTHORIZATION_CODE.code
        
        return request as T
    }

    /**
     * converter name
     *
     * @return converter name
     */
    override fun name(): String {
        return AccessTokenRequest::class.java.getName()
    }
}
