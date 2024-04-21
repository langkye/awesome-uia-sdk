package cn.lnkdoc.sdk.uia.instance.bccastle.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants
import cn.lnkdoc.sdk.uia.instance.bccastle.property.BccastleProperty
import cn.lnkdoc.sdk.uia.instance.bccastle.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.bccastle.request.AccessTokenRequest
import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.TypeReference
import io.vavr.Tuple2

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class AccessTokenConverter : IUiaConverter {
    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val tuple = body as Tuple2<BccastleProperty, AccessTokenRequest>
        val property = tuple._1
        val req = tuple._2
        
        //请求对象
        return okhttp3.FormBody.Builder()
            .addEncoded(UiaConstants.CLIENT_ID, property.clientId)
            .addEncoded(UiaConstants.CLIENT_SECRET, property.clientSecret)
            .addEncoded("code", req.body())
            .addEncoded(UiaConstants.GRANT_TYPE, property.grantType)
            .build() as T
    }
    
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val json = body as String
        val accessToken = JSON.parseObject(json, object : TypeReference<AccessToken?>() {}) as AccessToken
        return accessToken as T
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
