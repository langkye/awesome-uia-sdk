package cn.lnkdoc.sdk.uia.example.google

import cn.lnkdoc.sdk.uia.UiaSdkInstance
import cn.lnkdoc.sdk.uia.example.alipay.Example
import cn.lnkdoc.sdk.uia.instance.google.domain.RefreshToken
import cn.lnkdoc.sdk.uia.instance.google.request.RefreshTokenRequest
import cn.lnkdoc.sdk.uia.instance.google.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.google.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.google.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.google.request.UserInfoRequest
import cn.lnkdoc.sdk.uia.instance.google.property.GoogleProperty
import com.alibaba.fastjson2.toJSONString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
object Example {
    private val logger: Logger = LoggerFactory.getLogger(Example::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        println(buildOauthUrl())
        // third-party platform's code
        val code = ""

        // authenticate
        val accessToken = authenticate(code)
        val accessTokenJSONString = accessToken.toJSONString()
        println(accessTokenJSONString)

        // get user's info
        val userInfo = getUserInfo(accessToken)
        val userInfoJSONString = userInfo.toJSONString()
        println(userInfoJSONString)

        // refresh token
        val refresh = refresh(accessToken)
        println(refresh.toJSONString())
    }

    private fun loadProperty(): GoogleProperty {
        val property = GoogleProperty()
        property.clientId = ""
        property.clientSecret = ""
        property.redirectUri = ""
        property.printStack = true
        return property
    }

    private fun authenticate(code: String): AccessToken? {
        // load your property
        val loadProperty = loadProperty()

        // build instance
        val instance = UiaSdkInstance.getInstance(loadProperty)

        // build request
        val request = AccessTokenRequest()
        request.body = code

        // execute
        val executeResponse = instance.getAccessToken<AccessToken, AccessTokenRequest>(request)

        // check success
        if (executeResponse.isFailed) {
            throw RuntimeException(executeResponse.message)
        }

        return executeResponse.data
    }

    private fun getUserInfo(accessToken: AccessToken?): UserInfo? {
        // load your property
        val loadProperty = loadProperty()

        // build instance
        val instance = UiaSdkInstance.getInstance(loadProperty)

        // build request
        val request = UserInfoRequest()
        request.body = accessToken?.accessToken

        // execute
        val executeResponse = instance.getUserInfo<UserInfo, UserInfoRequest>(request)

        // check success
        if (executeResponse.isFailed) {
            throw RuntimeException(executeResponse.message)
        }
        return executeResponse.data
    }

    private fun refresh(accessToken: AccessToken?): RefreshToken? {
        // load your property
        val loadProperty = loadProperty()

        // build instance
        val instance = UiaSdkInstance.getInstance(loadProperty)

        // build request
        val request = RefreshTokenRequest()
        request.body = accessToken?.refreshToken

        // execute
        val executeResponse = instance.execute<RefreshToken, RefreshTokenRequest>(request)

        // check success
        if (executeResponse.isFailed) {
            throw RuntimeException(executeResponse.message)
        }
        return executeResponse.data
    }

    private fun buildOauthUrl(): String {
        val property = loadProperty()
        // 文档：https://developers.google.com/identity/protocols/oauth2/web-server?hl=zh-cn#creatingclient
        return "https://accounts.google.com/o/oauth2/v2/auth" +
                "?" +
                "client_id=${property.clientId}" +
                "&scope=${URLEncoder.encode(property.scope, StandardCharsets.UTF_8.name())}" +
                "&response_type=code" +
                "&include_granted_scopes=true" +
                "&access_type=offline" +
                "&state=state" +
                "&redirect_uri=${URLEncoder.encode(property.redirectUri, StandardCharsets.UTF_8.name())}"
    }
}
