package cn.lnkdoc.sdk.uia.instance.google.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.google.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.google.property.GoogleProperty
import cn.lnkdoc.sdk.uia.instance.google.request.AccessTokenRequest
import com.alibaba.fastjson2.into
import com.alibaba.fastjson2.parseObject
import io.vavr.Tuple2
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
open class AccessTokenConverter : IUiaConverter {
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

        val stringJSONObject = string.parseObject()

        stringJSONObject.into<AccessToken>()

        val data = stringJSONObject.into<AccessToken>()
        data.raw = string

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
        val tuple = body as Tuple2<AccessTokenRequest, GoogleProperty>
        val property = tuple._2
        val accessTokenRequest = tuple._1

        val builder = okhttp3.FormBody.Builder()
        builder
            .addEncoded("client_id", property.clientId)
            .addEncoded("client_secret", property.clientSecret)
            .addEncoded("grant_type", "authorization_code")
            .addEncoded("access_type", "offline")
            .addEncoded("code", accessTokenRequest.body())
        if (property.redirectUri != null) {
            builder
                .addEncoded("redirect_uri", URLEncoder.encode(property.redirectUri!!, StandardCharsets.UTF_8.name()))
        }

        return builder.build() as T
    }

    /**
     * build headers
     *
     * @param body body
     * @param <R> type
     * @param <T> type
     * @return response converted result
     */
    override fun <T, R> buildHeaders(body: R): T {
        val builder = okhttp3.Headers.Builder()
        return builder
            .add("Accept", "application/json")
            .build() as T
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
