package cn.lnkdoc.sdk.uia.instance.alipay.domain

import com.alibaba.fastjson2.annotation.JSONField

/**
 * 用户信息
 *
 * @document https://opendocs.alipay.com/open/02ailg
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class UserInfo {
    /**
     * 支付宝用户的userId。<p/>
     * 示例值：2088102104794936
     */
    @set:JSONField(name = "user_id")
    var userId : String? = null
    /**
     * 用户头像地址。 注意：如果没有数据（用户未设置）时不会返回该信息，请做好容错。<p/>
     * 示例值：2088102104794936
     */
    @set:JSONField(name = "avatar")
    var avatar : String? = null
    /**
     * 市名称。<p/>
     * 示例值：安庆
     */
    @set:JSONField(name = "city")
    var city : String? = null
    /**
     * 用户昵称。 注意：如果没有数据（用户未设置）时不会返回该信息，请做好容错。<p/>
     * 示例值：支付宝小二
     */
    @set:JSONField(name = "nick_name")
    var nickName : String? = null
    /**
     * 省份名称。<p/>
     * 示例值：安徽省
     */
    @set:JSONField(name = "province")
    var province : String? = null
    /**
     * 性别。枚举值如下： F：女性； M：男性。<p/>
     * 示例值：F
     */
    @set:JSONField(name = "gender")
    var gender : String? = null
    /**
     * raw
     */
    var raw: String? = null
}