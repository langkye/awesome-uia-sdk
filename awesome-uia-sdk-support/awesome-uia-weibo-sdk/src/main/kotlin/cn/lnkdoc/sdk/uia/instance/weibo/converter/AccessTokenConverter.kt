package cn.lnkdoc.sdk.uia.instance.weibo.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.weibo.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.weibo.property.WeiboProperty
import cn.lnkdoc.sdk.uia.instance.weibo.request.AccessTokenRequest
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
        val tuple = body as Tuple2<String, WeiboProperty>
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
        val tuple = body as Tuple2<AccessTokenRequest, WeiboProperty>
        val property = tuple._2
        val accessTokenRequest = tuple._1

        val builder = okhttp3.FormBody.Builder()
        builder
            .addEncoded("client_id", property.clientId)
            .addEncoded("client_secret", property.clientSecret)
            .addEncoded("grant_type", "authorization_code")
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
