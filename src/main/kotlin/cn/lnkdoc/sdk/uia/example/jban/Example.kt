package cn.lnkdoc.sdk.uia.example.jban

import cn.lnkdoc.sdk.uia.UiaSdkInstance.getInstance
import cn.lnkdoc.sdk.uia.instance.jban.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.jban.domain.MobileInfo
import cn.lnkdoc.sdk.uia.instance.jban.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanAccessTokenRequest
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanMobileMd5UserRequest
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanUserInfoRequest
import com.alibaba.fastjson2.toJSONString
import org.slf4j.LoggerFactory

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
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
        println(accessToken.toJSONString())

        // get user's info 
        val userInfo = getUserInfo(accessToken)
        println(userInfo.toJSONString())

        // get openid
        val mobile = ""
        val openid = getOpenid(mobile)
        println(openid.toJSONString())
    }

    private fun loadProperty(): JbanProperty {
        val property = JbanProperty()
        property.domain = "https://open.jzb.beijing.gov.cn"
        property.clientId = ""
        property.clientSecret = ""
        property.openTeamId = ""
        //property.printStack = true
        return property
    }

    private fun authenticate(code: String): AccessToken? {
        // load your property
        val property = loadProperty()

        // build instance
        val instance = getInstance(property)

        // build request
        val request = JbanAccessTokenRequest()
        request.body = code

        // execute
        val executeResponse = instance.getAccessToken<AccessToken, JbanAccessTokenRequest>(request)

        // check success
        if (executeResponse.isFailed) {
            log.error(executeResponse.message)
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
        val request = JbanUserInfoRequest()
        request.body = accessToken?.accessToken

        // execute
        val executeResponse = instance.getUserInfo<UserInfo, JbanUserInfoRequest>(request)

        // check success
        if (executeResponse.isFailed) {
            log.error(executeResponse.message)
            throw RuntimeException(executeResponse.message)
        }
        return executeResponse.data
    }

    private fun getOpenid(mobile: String): MobileInfo? {
        // load your property
        val property = loadProperty()

        // build instance
        val instance = getInstance(property)

        // build request
        val request = JbanMobileMd5UserRequest()
        request.body = mobile

        // execute
        val executeResponse = instance.execute<MobileInfo, JbanMobileMd5UserRequest>(request)

        // check success
        if (executeResponse.isFailed) {
            log.error(executeResponse.message)
            throw RuntimeException(executeResponse.message)
        }
        return executeResponse.data
    }
}
