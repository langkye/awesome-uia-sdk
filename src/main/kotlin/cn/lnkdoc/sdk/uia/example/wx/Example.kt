package cn.lnkdoc.sdk.uia.example.wx

import cn.lnkdoc.sdk.uia.UiaSdkInstance.getInstance
import cn.lnkdoc.sdk.uia.instance.wx.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.wx.domain.RefreshToken
import cn.lnkdoc.sdk.uia.instance.wx.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty
import cn.lnkdoc.sdk.uia.instance.wx.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.wx.request.RefreshTokenRequest
import cn.lnkdoc.sdk.uia.instance.wx.request.UserInfoRequest
import com.alibaba.fastjson2.toJSONString
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
object Example {
    private val log = LoggerFactory.getLogger(Example::class.java)

    /**
     * main
     *
     * @param args args
     */
    @JvmStatic
    fun main(args: Array<String>) {
        println(buildLoginUrl())
        // third-party platform's code
        val code = ""

        // authenticate
        val accessToken = getAccessToken(code)
        println(accessToken.toJSONString())

        // get user's info
        val userInfo = getUserInfo(accessToken)
        println(userInfo.toJSONString())

        // refresh token
        val refreshToken = refreshToken(accessToken)
        println(refreshToken.toJSONString())
    }

    private fun loadProperty(): WxProperty {
        val property = WxProperty()
        property.clientId = ""
        property.clientSecret = ""
        property.redirectUri = ""
        //property.printStack = true
        return property
    }

    private fun getAccessToken(code: String): AccessToken? {
        // load property
        val property = loadProperty()

        // build instance
        val instance = getInstance(property)

        // build request
        val request = AccessTokenRequest()
        request.body = code
        val executeResponse = instance.getAccessToken<AccessToken, AccessTokenRequest>(request)

        // check success
        if (executeResponse.isFailed) {
            throw RuntimeException(executeResponse.message)
        }
        return executeResponse.data
    }

    private fun refreshToken(accessToken: AccessToken?): RefreshToken? {
        // load property
        val property = loadProperty()

        // build instance
        val instance = getInstance(property)

        // build request
        val request = RefreshTokenRequest()
        request.body = accessToken!!.refreshToken

        // execute
        val executeResponse = instance.execute<RefreshToken, RefreshTokenRequest>(request)

        // check success
        if (executeResponse.isFailed) {
            throw RuntimeException(executeResponse.message)
        }
        return executeResponse.data
    }

    private fun getUserInfo(accessToken: AccessToken?): UserInfo? {
        // load property
        val property = loadProperty()

        // build instance
        val instance = getInstance(property)

        // build request
        val request = UserInfoRequest()
        val body = UserInfoRequest.Body()
        body.accessToken = accessToken?.accessToken
        body.openid = accessToken?.openid
        request.body = body

        // execute
        val executeResponse = instance.execute<UserInfo, UserInfoRequest>(request)

        // check success
        if (executeResponse.isFailed) {
            throw RuntimeException(executeResponse.message)
        }
        return executeResponse.data
    }

    private fun buildLoginUrl(): String {
        return try {
            val property = loadProperty()
            val redirectUri = property.redirectUri
            //String encode = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);
            val encode = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8.displayName())
            val state = ""
            java.lang.String.join(
                "",
                "https://open.weixin.qq.com/connect/qrconnect?",
                "appid=" + property.clientId,
                "&redirect_uri=$encode",
                "&response_type=" + "code",
                "&scope=" + "snsapi_login",
                if (StringUtils.isBlank(state)) "" else "&state=$state",
                "#wechat_redirect"
            )
        } catch (e: UnsupportedEncodingException) {
            throw RuntimeException(e)
        }
    }
}
