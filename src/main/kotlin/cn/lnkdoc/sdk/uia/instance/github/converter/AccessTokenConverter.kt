package cn.lnkdoc.sdk.uia.instance.github.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.github.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.github.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.github.property.GithubProperty
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
        val tuple = body as Tuple2<AccessTokenRequest, GithubProperty>
        val property = tuple._2
        val accessTokenRequest = tuple._1

        val builder = okhttp3.FormBody.Builder()
        builder
            .addEncoded("client_id", property.clientId)
            .addEncoded("client_secret", property.clientSecret)
            .addEncoded("code", accessTokenRequest.body())
        if (property.redirectUri != null) {
            builder
                .addEncoded("redirect_uri", property.redirectUri!!)
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
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val tuple = body as Tuple2<String, GithubProperty>
        // convert json
        val data = tuple._1.into<AccessToken>()
        
        if (!data.success) {
            throw UiaException(data.message)
        }
        
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

