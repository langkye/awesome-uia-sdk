package cn.lnkdoc.sdk.uia.instance.wx.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.instance.wx.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty
import cn.lnkdoc.sdk.uia.instance.wx.request.AccessTokenRequest
import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.TypeReference
import io.vavr.Tuple3
import okhttp3.OkHttpClient
import okhttp3.Request

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
        val json = body as String
        val accessToken = JSON.parseObject(json, object : TypeReference<AccessToken?>() {}) as AccessToken
        return accessToken as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val tuple = body as Tuple3<WxProperty, OkHttpClient, AccessTokenRequest>

        //请求对象
        val request: Request = Request.Builder()
            .url(tuple._3.url(tuple._1))
            .get()
            .build()
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
