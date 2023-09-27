package cn.lnkdoc.sdk.uia.instance.jban.convert

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter
import cn.lnkdoc.sdk.uia.instance.jban.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanUserInfoRequest
import cn.lnkdoc.sdk.uia.instance.jban.response.JbanResponse
import cn.lnkdoc.sdk.uia.instance.jban.util.ApiUtil.getAppAccessToken
import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.into
import io.vavr.Tuple3
import okhttp3.Headers
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.apache.http.entity.ContentType

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class UserInfoConverter : IUiaConverter {
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val json = body as String
        val jbanResponse: JbanResponse<UserInfo> = json.into<JbanResponse<UserInfo>>()
        return jbanResponse.data as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val tuple = body as Tuple3<JbanProperty, OkHttpClient, JbanUserInfoRequest>
        val appAccessToken = getAppAccessToken(tuple._1, tuple._2)

        //请求头
        val headers: Headers = Headers.Builder()
            .add("Content-Type", ContentType.APPLICATION_JSON.mimeType)
            .build()

        //请求体
        val reqBody = JSONObject()
        reqBody["appAccessToken"] = appAccessToken
        reqBody["code"] = tuple._3.body
        val requestBody: RequestBody = reqBody.toJSONString().toRequestBody(ContentType.APPLICATION_JSON.mimeType.toMediaType())

        //请求对象
        val request: Request = Request.Builder()
            .url(tuple._3.url(tuple._1)) //.method(HttpMethod.POST.name(), null)
            .post(requestBody)
            .headers(headers)
            .build()
        return request as T
    }

    /**
     * converter name
     *
     * @return converter name
     */
    override fun name(): String {
        return JbanUserInfoRequest::class.java.getName()
    }
}
