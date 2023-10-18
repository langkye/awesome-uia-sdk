package cn.lnkdoc.sdk.uia.instance.weibo.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.instance.weibo.property.WeiboProperty
import com.alibaba.fastjson2.annotation.JSONField


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class UserInfoRequest : AbstractUiaRequest(), IUiaRequest {
    /**
     * body
     */
    var body: Body? = null
    
    /**
     * request body
     *
     * @return request body
     */
    override fun <T> body(): T {
        return body!! as T
    }

    /**
     * request url
     *
     * @param property property
     * @return request url
     */
    override fun url(property: IUiaProperty): String {
        val varProperty = property as WeiboProperty
        required(varProperty, "配置不能为空")
        return try {
            var url = varProperty.userInfoUrl + "?access_token=${body?.accessToken}"
            if (body?.uid != null) {
                url+= "&uid=${body?.uid!!}"
            }
            if (body?.screenName != null && body?.uid == null) {
                url += "&screen_name=${body?.screenName!!}"
            }
            url
        } catch (e: Exception) {
            throw UiaException(e)
        }
    }

    /**
     * request method
     *
     * @return request method
     */
    override fun method(): HttpMethod {
        return HttpMethod.GET
    }

    @Suppress("unused")
    class Body {
        /**
         * 访问令牌。通过该令牌调用需要授权类接口
         */
        @set:JSONField(name = "access_token")
        var accessToken: String? = null
        /**
         * uid
         */
        @set:JSONField(name = "uid")
        var uid: String? = null
        /**
         * screen_name
         */
        @set:JSONField(name = "screen_name")
        var screenName: String? = null
    }
}

