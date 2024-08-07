package cn.lnkdoc.sdk.uia.example.bccastle

import cn.lnkdoc.sdk.uia.UiaSdkInstance.getInstance
import cn.lnkdoc.sdk.uia.instance.bccastle.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.bccastle.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.bccastle.property.BccastleProperty
import cn.lnkdoc.sdk.uia.instance.bccastle.request.AccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.bccastle.request.UserInfoRequest
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

    private fun loadProperty(): BccastleProperty {
        val property = BccastleProperty()
        property.domain = "https://domain"
        property.clientId = ""
        property.clientSecret = ""
        property.printStack = true
        property.useInterceptor = true
        return property
    }

    private fun authenticate(code: String): AccessToken? {
        // load your property
        val property = loadProperty()

        // build instance
        val instance = getInstance(property)

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
        val property = loadProperty()

        // build instance
        val instance = getInstance(property)

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
}