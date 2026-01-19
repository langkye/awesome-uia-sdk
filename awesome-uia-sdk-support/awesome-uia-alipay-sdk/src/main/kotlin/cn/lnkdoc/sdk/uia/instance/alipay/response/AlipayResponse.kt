package cn.lnkdoc.sdk.uia.instance.alipay.response

import com.alibaba.fastjson2.annotation.JSONField

/**
 * 公共响应参数
 *
 * @document https://opendocs.alipay.com/open/01emu5?pathHash=8f9c00bc
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class AlipayResponse<T> {
    /**
     * 网关返回码。</p>
     * 示例值：40004
     */
    @set:JSONField(name = "code")
    var code: String? = null
    /**
     * 网关返回码描述。</p>
     * 示例值：Business Failed
     */
    @set:JSONField(name = "msg")
    var msg: String? = null
    /**
     * 业务返回码。</p>
     * 示例值：ACQ.TRADE_HAS_SUCCESS
     */
    @set:JSONField(name = "sub_code")
    var subCode: String? = null
    /**
     * 业务返回码描述。</p>
     * 示例值：交易已被支付
     */
    @set:JSONField(name = "sub_msg")
    var subMsg: String? = null
    /**
     * 签名。</p>
     * 示例值：DZXh8eeTuAHoYE3w1J+POiPhfDxOYBfUNn1lkeT/V7P4zJdyojWEa6IZs6Hz0yDW5Cp/viufUb5I0/V5WENS3OYR8zRedqo6D+fUTdLHdc+EFyCkiQhBxIzgngPdPdfp1PIS7BdhhzrsZHbRqb7o4k3Dxc+AAnFauu4V6Zdwczo=
     */
    @set:JSONField(name = "sign")
    var sign: String? = null
    /**
     * body
     */
    var data : T? = null
}