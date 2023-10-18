package cn.lnkdoc.sdk.uia.example.weibo

import cn.lnkdoc.sdk.uia.UiaSdkInstance
import cn.lnkdoc.sdk.uia.example.alipay.Example
import cn.lnkdoc.sdk.uia.instance.weibo.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.weibo.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.weibo.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.weibo.request.UserInfoRequest
import cn.lnkdoc.sdk.uia.instance.weibo.property.WeiboProperty
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
    }

    private fun loadProperty(): WeiboProperty {
        val property = WeiboProperty()
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
        val body = UserInfoRequest.Body()
        body.accessToken = accessToken?.accessToken
        body.uid = accessToken?.uid
        request.body = body

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
        // 文档：https://open.weibo.com/wiki/Connect/login
        return "https://api.weibo.com/oauth2/authorize" +
                "?" +
                "client_id=${property.clientId}" +
                "&response_type=code" +
                "&state=state" +
                "&redirect_uri=${URLEncoder.encode(property.redirectUri, StandardCharsets.UTF_8.name())}"
    }
}
