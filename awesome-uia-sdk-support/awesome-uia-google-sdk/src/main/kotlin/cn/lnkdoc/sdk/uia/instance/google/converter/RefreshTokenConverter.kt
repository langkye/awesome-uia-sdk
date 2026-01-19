package cn.lnkdoc.sdk.uia.instance.google.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.google.domain.RefreshToken
import cn.lnkdoc.sdk.uia.instance.google.property.GoogleProperty
import cn.lnkdoc.sdk.uia.instance.google.request.RefreshTokenRequest
import com.alibaba.fastjson2.into
import io.vavr.Tuple2

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class RefreshTokenConverter : AccessTokenConverter(), IUiaConverter {
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val tuple = body as Tuple2<String, GoogleProperty>
        // convert json
        val string = tuple._1
        
        val data = string.into<RefreshToken>()

        if (!data.success) {
            throw UiaException(data.message)
        }
        return data as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val tuple = body as Tuple2<RefreshTokenRequest, GoogleProperty>
        val property = tuple._2
        val accessTokenRequest = tuple._1

        val builder = okhttp3.FormBody.Builder()
        builder
            .addEncoded("client_id", property.clientId)
            .addEncoded("client_secret", property.clientSecret)
            .addEncoded("grant_type", "refresh_token")
            .addEncoded("access_type", "offline")
            .addEncoded("refresh_token", accessTokenRequest.body())

        return builder.build() as T
    }

    /**
     * converter name
     *
     * @return converter name
     */
    override fun name(): String {
        return RefreshTokenRequest::class.java.getName()
    }
}
