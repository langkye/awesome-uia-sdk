package cn.lnkdoc.sdk.uia.instance.alipay.property

import cn.lnkdoc.sdk.uia.common.SignType
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.alipay.SignMode

/**
 * property
 *
 * @document https://opendocs.alipay.com/open/263/105809?pathHash=033b7786
 *           https://opendocs.alipay.com/open/01emu5?pathHash=8f9c00bc
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class AlipayProperty : IUiaProperty {
    /**
     * printStack
     */
    var printStack = false

    /**
     * 加签模式
     */
    var signMode: String = SignMode.PUBLIC_KEY.signMode

    /**
     * 应用APP_ID
     */
    var appId: String? = null

    /**
     * 支付宝网关（服务地址）
     */
    var alipayGatewayUrl: String = "https://openapi.alipay.com/gateway.do"

    /**
     * 签名方式
     */
    var signType: String = SignType.RSA.signType

    /**
     * 编码集，支持 GBK/UTF-8
     */
    var charset: String = "UTF-8"

    /**
     * 支付宝公钥
     */
    var alipayPublicKey: String? = null

    /**
     * 应用私钥
     */
    var appPrivateKey: String? = null

    /**
     * 参数返回格式，只支持 JSON（固定）
     */
    var format: String = "json"

    /**
     * 应用公钥证书文件本地路径
     */
    var appCertPath: String? = null

    /**
     * 支付宝公钥证书文件本地路径
     */
    var alipayCertPath: String? = null

    /**
     * 支付宝根证书文件本地路径
     */
    var alipayRootCertPath: String? = null

    /**
     * 回调地址
     */
    var redirectUri: String? = null

    /**
     * getter
     *
     * @return printStack
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }

}