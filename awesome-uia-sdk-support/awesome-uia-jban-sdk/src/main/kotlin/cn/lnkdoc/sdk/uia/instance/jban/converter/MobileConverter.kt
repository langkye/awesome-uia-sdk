package cn.lnkdoc.sdk.uia.instance.jban.converter

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.instance.jban.domain.MobileInfo
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanMobileMd5UserRequest
import cn.lnkdoc.sdk.uia.instance.jban.response.JbanResponse
import cn.lnkdoc.sdk.uia.instance.jban.util.ApiUtil.getTeamAccessToken
import com.alibaba.fastjson2.into
import io.vavr.Tuple3
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class MobileConverter : IUiaConverter {
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val json = body as String
        val jbanResponse: JbanResponse<MobileInfo> = json.into<JbanResponse<MobileInfo>>()
        return jbanResponse.data as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val tuple = body as Tuple3<JbanProperty, OkHttpClient, JbanMobileMd5UserRequest>
        val teamAccessToken = getTeamAccessToken(tuple._1, tuple._2)
        
        // build header
        val headers: Headers = Headers.Builder()
            .add("Authorization", "Bearer $teamAccessToken")
            .build()

        // build mediaType
        //val mediaType: MediaType = ContentType.TEXT_PLAIN.mimeType.toMediaType()

        // build httpRequest
        val httpRequest: Request = Request.Builder()
            .url(tuple._3.url(tuple._1))
            .method(HttpMethod.GET.method, null)
            .headers(headers)
            .build()
        return httpRequest as T
    }

    /**
     * converter name
     *
     * @return converter name
     */
    override fun name(): String {
        return JbanMobileMd5UserRequest::class.java.getName()
    }
}
