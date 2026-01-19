package cn.lnkdoc.sdk.uia.instance.jban.util

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.instance.jban.domain.AppAccessToken
import cn.lnkdoc.sdk.uia.instance.jban.domain.TeamAccessToken
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty
import cn.lnkdoc.sdk.uia.instance.jban.response.JbanResponse
import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.into
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.apache.hc.core5.http.ContentType
import org.slf4j.LoggerFactory

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
object ApiUtil {
    private val log = LoggerFactory.getLogger(ApiUtil::class.java)

    /**
     * getter
     *
     * @param property property
     * @param client client
     * @return team_access_token
     */
    fun getTeamAccessToken(property: JbanProperty, client: OkHttpClient): String? {
        val accessToken = getAppAccessToken(property, client)

        // build request url
        val url: String = java.lang.String.join("", property.domain, property.teamAccessTokenPath)
        val logMessage = String.format("[%s][%s]", HttpMethod.POST.method, url)
        var success = false
        var string = ""

        // build mediaType
        val mediaType: MediaType = ContentType.APPLICATION_JSON.mimeType.toMediaType()

        //body
        val reqBody = JSONObject()
        reqBody["appAccessToken"] = accessToken
        reqBody["openTeamId"] = property.openTeamId

        // build requestBody
        val body: RequestBody = reqBody.toJSONString().toRequestBody(mediaType)
        
        // build httpRequest
        val httpRequest: Request = Request.Builder()
            .url(url)
            .method(HttpMethod.POST.method, body)
            .build()

        // call 
        try {
            client.newCall(httpRequest).execute().use { response ->
                // fetch request
                val responseBody = response.body
                required(responseBody, "请求无响应内容：[$url]")
                string = responseBody!!.string()
                val jbanResponse: JbanResponse<TeamAccessToken> = string.into<JbanResponse<TeamAccessToken>>()
                success = true
                val responseSuccess = "0".toInt() == jbanResponse.code
                if (responseSuccess) {
                    return jbanResponse.data!!.teamAccessToken
                }
                throw UiaException(jbanResponse.msg)
            }
        } catch (e: UiaException) {
            throw e
        } catch (e: Exception) {
            throw UiaException(e)
        } finally {
            log.debug("{}[{}][{}]", logMessage, success, string)
        }
    }

    /**
     * getter
     *
     * @param property property
     * @param client client
     * @return app_access_token
     */
    fun getAppAccessToken(property: JbanProperty, client: OkHttpClient): String? {
        // build request url
        val url = java.lang.String.join("", property.domain, property.appAccessTokenPath)
        val logMessage = String.format("[%s][%s]", HttpMethod.POST.method, url)
        var success = false
        var string = ""

        // build mediaType
        val mediaType: MediaType = ContentType.APPLICATION_JSON.mimeType.toMediaType()


        //body
        val reqBody = JSONObject()
        reqBody["appKey"] = property.clientId
        reqBody["appSecret"] = property.clientSecret

        // build requestBody
        val body: RequestBody = reqBody.toJSONString().toRequestBody(mediaType)

        // build httpRequest
        val httpRequest: Request = Request.Builder()
            .url(url)
            .method(HttpMethod.POST.method, body)
            .build()

        // call 
        try {
            client.newCall(httpRequest).execute().use { response ->

                // fetch request
                val responseBody = response.body
                required(responseBody, "请求无响应内容：[$url]")
                string = responseBody!!.string()
                val jbanResponse: JbanResponse<AppAccessToken> = string.into<JbanResponse<AppAccessToken>>()
                success = true
                val responseSuccess = "0".toInt() == jbanResponse.code
                if (responseSuccess) {
                    return jbanResponse.data!!.appAccessToken
                }
                throw UiaException(jbanResponse.msg)
            }
        } catch (e: UiaException) {
            throw e
        } catch (e: Exception) {
            throw UiaException(e)
        } finally {
            log.debug("{}[{}][{}]", logMessage, success, string)
        }
    }
}
