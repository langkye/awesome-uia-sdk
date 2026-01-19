package cn.lnkdoc.sdk.uia.instance.alipay

/**
 * 加签模式
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
enum class SignMode (val signMode: String){
    /**
     * 公钥模式加签
     */
    PUBLIC_KEY("PUBLIC_KEY"),
    /**
     * 公钥证书模式加签
     */
    CERT("CERT"),
    ;

}