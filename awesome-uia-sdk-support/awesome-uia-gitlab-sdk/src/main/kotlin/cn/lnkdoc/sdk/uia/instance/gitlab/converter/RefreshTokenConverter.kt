package cn.lnkdoc.sdk.uia.instance.gitlab.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.gitlab.domain.RefreshToken
import cn.lnkdoc.sdk.uia.instance.gitlab.property.GitlabProperty
import cn.lnkdoc.sdk.uia.instance.gitlab.request.RefreshTokenRequest
import com.alibaba.fastjson2.into
import io.vavr.Tuple2
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

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
        val tuple = body as Tuple2<String, GitlabProperty>
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
        val tuple = body as Tuple2<RefreshTokenRequest, GitlabProperty>
        val property = tuple._2
        val accessTokenRequest = tuple._1

        val builder = okhttp3.FormBody.Builder()
        builder
            .addEncoded("client_id", property.clientId)
            .addEncoded("client_secret", property.clientSecret)
            .addEncoded("grant_type", "refresh_token")
            .addEncoded("refresh_token", accessTokenRequest.body())
            .addEncoded("redirect_uri", (URLEncoder.encode(property.redirectUri, StandardCharsets.UTF_8.name())))

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
