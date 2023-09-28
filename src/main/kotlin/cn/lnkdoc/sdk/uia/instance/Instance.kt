package cn.lnkdoc.sdk.uia.instance

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.bjtoon.BjtoonSdkInstance
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty
import cn.lnkdoc.sdk.uia.instance.jban.JbanSdkInstance
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty
import cn.lnkdoc.sdk.uia.instance.wx.WxSdkInstance
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty
import cn.lnkdoc.sdk.uia.instance.yztoon.YztoonSdkInstance
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
enum class Instance
/**
 * constructor
 *
 * @param function function
 * @param propertyClazz propertyClazz
 */(
    /**
     * function
     */
    val function: (IUiaProperty) -> ISdkInstance,
    /**
     * propertyClazz
     */
    val propertyClazz: Class<*>
) {
    /**
     * yztoon
     */
    YZTOON({ property -> yztoon(property) }, YztoonProperty::class.java),

    /**
     * bjtoon
     */
    BJTOON({ property -> bjtoon(property) }, BjtoonProperty::class.java),

    /**
     * jban
     */
    JBAN({ property -> jban(property) }, JbanProperty::class.java),

    /**
     * wx
     */
    WX({ property -> wx(property) }, WxProperty::class.java)
    ;

    companion object {
        // ~=============================== Tools ===============================~ //
        /**
         * of
         *
         * @param name name
         * @return instance
         */
        fun of(name: String): Instance {
            for (instance in entries) {
                if (instance.toString() == name) {
                    return instance
                }
            }
            throw UiaException("not match instance for “$name”")
        }

        /**
         * of
         *
         * @param propertyClazz propertyClazz
         * @return instance
         */
        fun of(propertyClazz: Class<*>): Instance {
            for (instance in entries) {
                if (instance.propertyClazz == propertyClazz) {
                    return instance
                }
            }
            throw UiaException("un support property type : $propertyClazz")
        }
    }
}

// ~=============================== Instances ===============================~ //
/**
 * of
 *
 * @param property property
 * @return instance
 */
private fun yztoon(property: IUiaProperty): YztoonSdkInstance {
    return YztoonSdkInstance(property as YztoonProperty)
}

/**
 * of
 *
 * @param property property
 * @return instance
 */
private fun bjtoon(property: IUiaProperty): ISdkInstance {
    return BjtoonSdkInstance(property as BjtoonProperty)
}

/**
 * of
 *
 * @param property property
 * @return instance
 */
private fun jban(property: IUiaProperty): JbanSdkInstance {
    return JbanSdkInstance(property as JbanProperty)
}

/**
 * of
 *
 * @param property property
 * @return instance
 */
private fun wx(property: IUiaProperty): WxSdkInstance {
    return WxSdkInstance(property as WxProperty)
}