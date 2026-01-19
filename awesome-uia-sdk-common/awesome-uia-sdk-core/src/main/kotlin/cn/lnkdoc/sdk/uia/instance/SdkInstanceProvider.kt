package cn.lnkdoc.sdk.uia.instance

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty

/**
 * SDK Instance Provider
 */
interface SdkInstanceProvider {
    /**
     * get instance name (e.g. ALIPAY, WX)
     */
    fun getName(): String

    /**
     * get property class supported by this provider
     */
    fun getPropertyClass(): Class<out IUiaProperty>

    /**
     * create instance
     */
    fun createInstance(property: IUiaProperty): ISdkInstance
}
