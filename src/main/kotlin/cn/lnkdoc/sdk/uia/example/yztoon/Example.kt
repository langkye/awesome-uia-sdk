package cn.lnkdoc.sdk.uia.example.yztoon

import cn.lnkdoc.sdk.uia.UiaSdkInstance.getInstance
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty
import cn.lnkdoc.sdk.uia.instance.yztoon.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.yztoon.request.LogoutRequest
import cn.lnkdoc.sdk.uia.instance.yztoon.request.UserInfoRequest
import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.toJSONString
import org.slf4j.LoggerFactory

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
        val code = ""

        // authenticate
        val accessToken = authenticate(code)
        println(accessToken.toJSONString())

        // get user's info 
        val userInfo = getUserInfo(accessToken)
        println(userInfo.toJSONString())

        // logout
        val logout = logout()
        println(logout)
    }

    private fun loadProperty(): YztoonProperty {
        val property = YztoonProperty()
        property.domain = "https://yzt.beijing.gov.cn/am"
        property.clientId = ""
        property.clientSecret = ""
        property.redirectUrl = ""
        property.printStack = true
        property.isTrustDomain = true
        return property
    }

    private fun authenticate(code: String): AccessToken? {
        // load property
        val property = loadProperty()

        // build instance
        val instance = getInstance(property)

        // build request=
        val request = AccessTokenRequest()
        request.body = code

        // execute
        val executeResponse = instance.getAccessToken<AccessToken, AccessTokenRequest>(request)
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
        request.body = accessToken!!.accessToken

        // execute
        val executeResponse = instance.getUserInfo<UserInfo, UserInfoRequest>(request)
        if (executeResponse.isFailed) {
            throw RuntimeException(executeResponse.message)
        }
        return executeResponse.data
    }

    private fun logout(): Any? {
        // load property
        val property = loadProperty()

        // build instance
        val instance = getInstance(property)

        // build request=
        val request = LogoutRequest()

        // execute
        val executeResponse = instance.getAccessToken<Any, LogoutRequest>(request)
        if (executeResponse.isFailed) {
            throw RuntimeException(executeResponse.message)
        }
        return executeResponse.data
    }
}
