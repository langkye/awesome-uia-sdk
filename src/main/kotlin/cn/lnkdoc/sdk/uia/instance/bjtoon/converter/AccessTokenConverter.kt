package cn.lnkdoc.sdk.uia.instance.bjtoon.converter

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants
import cn.lnkdoc.sdk.uia.instance.bjtoon.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.bjtoon.response.BjtoonResponse
import cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption.CryptoClient
import com.alibaba.fastjson2.*
import io.vavr.Tuple2


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast")
open class AccessTokenConverter : IUiaConverter {
    private var name: String = AccessTokenRequest::class.java.getName()
    
    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val tuple = body as Tuple2<AccessTokenRequest, BjtoonProperty>
        val bjtoonProperty = tuple._2
        val accessTokenRequest = tuple._1
        val authToken = CryptoClient.encryptWithAES(
            bjtoonProperty.clientId + ":" + bjtoonProperty.clientSecret + ":" + System.currentTimeMillis(),
            bjtoonProperty.clientSecret
        )
        
        return okhttp3.FormBody.Builder()
            .addEncoded(UiaConstants.CLIENT_ID, bjtoonProperty.clientId)
            .addEncoded(UiaConstants.CLIENT_SECRET, bjtoonProperty.clientSecret)
            .addEncoded(UiaConstants.REDIRECT_URI, bjtoonProperty.redirectUri)
            .addEncoded(UiaConstants.GRANT_CODE, accessTokenRequest.body())
            .addEncoded(UiaConstants.GRANT_TYPE, bjtoonProperty.grantType)
            .addEncoded(UiaConstants.AUTH_TOKEN, authToken)
            .addEncoded(UiaConstants.SCOPE, bjtoonProperty.scope)
            .addEncoded(UiaConstants.TOON_TYPE, accessTokenRequest.toonType)
            .addEncoded(UiaConstants.STATE, accessTokenRequest.state)
            .addEncoded(UiaConstants.IN_TYPE, accessTokenRequest.inType)
            .addEncoded(UiaConstants.LOCAL_CHECK, accessTokenRequest.localCheck)
            .build() as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val tuple = body as Tuple2<String, BjtoonProperty>
        // convert json
        val response = tuple._1.into<BjtoonResponse<AccessToken>>()
        val data = response.data
        return data as T
    }

    /**
     * converter name
     *
     * @return converter name
     */
    override fun name(): String {
        return name
    }
}

