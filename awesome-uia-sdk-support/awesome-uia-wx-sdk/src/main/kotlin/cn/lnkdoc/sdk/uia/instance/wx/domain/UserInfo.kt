package cn.lnkdoc.sdk.uia.instance.wx.domain

import cn.lnkdoc.sdk.uia.instance.wx.response.WxResponse

/**
 * 用户信息
 * <pre>
 * 建议：
 * 开发者最好保存用户unionID信息，以便以后在不同应用中进行用户信息互通。
 * 错误的Json返回示例:
 * {
 * "errcode":40003,"errmsg":"invalid openid"
 * }
</pre> *
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class UserInfo : WxResponse() {
    /**
     * 普通用户的标识，对当前开发者帐号唯一
     */
    var openid: String? = null
    /**
     * 普通用户昵称
     */
    var nickname: String? = null
    /**
     * 普通用户性别，1为男性，2为女性
     */
    var sex: Int? = null
    /**
     * 普通用户个人资料填写的省份
     */
    var province: String? = null
    /**
     * 普通用户个人资料填写的城市
     */
    var city: String? = null
    /**
     * 国家，如中国为CN
     */
    var country: String? = null
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    var headimgurl: String? = null
    /**
     * 用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
     */
    var privilege: String? = null
    /**
     * 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的。
     */
    var unionid: String? = null
}
