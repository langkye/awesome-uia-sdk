package cn.lnkdoc.sdk.uia

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
object UiaSdkInstance {
    /**
     * auto load instance
     *
     * @param property uia property
     * @return uia instance
     */
    @JvmStatic
    fun getInstance(property: IUiaProperty): ISdkInstance {
        return Instance.of(property::class.java).function.invoke(property)
    }
}
