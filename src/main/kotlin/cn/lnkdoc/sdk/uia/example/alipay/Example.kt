package cn.lnkdoc.sdk.uia.example.alipay

import cn.lnkdoc.sdk.uia.UiaSdkInstance
import cn.lnkdoc.sdk.uia.common.SignType
import cn.lnkdoc.sdk.uia.instance.alipay.SignMode
import cn.lnkdoc.sdk.uia.instance.alipay.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.alipay.domain.RefreshToken
import cn.lnkdoc.sdk.uia.instance.alipay.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.alipay.property.AlipayProperty
import cn.lnkdoc.sdk.uia.instance.alipay.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.alipay.request.RefreshTokenRequest
import cn.lnkdoc.sdk.uia.instance.alipay.request.UserInfoRequest
import com.alibaba.fastjson2.*
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
        val code = "7f027e108af0458a906118a81441DX82"

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

    private fun loadProperty(): AlipayProperty {
        val property = AlipayProperty()
        property.appId = ""
        property.appPrivateKey = ""
        property.alipayPublicKey = ""
        property.signMode = SignMode.PUBLIC_KEY.signMode
        property.signType = SignType.RSA.signType
        property.alipayGatewayUrl = "https://openapi.alipay.com/gateway.do"
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
    
    private fun buildOauthUrl(): String {
        val property = loadProperty()
        return "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm" +
                "?" +
                "app_id=${property.appId}" +
                "&scope=auth_user" +
                "&redirect_uri=${URLEncoder.encode(property.redirectUri, StandardCharsets.UTF_8.name())}" +
                "&state=init"
    }
}