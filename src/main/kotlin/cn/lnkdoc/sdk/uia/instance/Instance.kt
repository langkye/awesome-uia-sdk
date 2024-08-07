package cn.lnkdoc.sdk.uia.instance

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.alipay.AlipaySdkInstance
import cn.lnkdoc.sdk.uia.instance.alipay.property.AlipayProperty
import cn.lnkdoc.sdk.uia.instance.bjtoon.BjtoonSdkInstance
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty
import cn.lnkdoc.sdk.uia.instance.gitee.GiteeSdkInstance
import cn.lnkdoc.sdk.uia.instance.gitee.property.GiteeProperty
import cn.lnkdoc.sdk.uia.instance.github.GithubSdkInstance
import cn.lnkdoc.sdk.uia.instance.github.property.GithubProperty
import cn.lnkdoc.sdk.uia.instance.gitlab.GitlabSdkInstance
import cn.lnkdoc.sdk.uia.instance.gitlab.property.GitlabProperty
import cn.lnkdoc.sdk.uia.instance.google.GoogleSdkInstance
import cn.lnkdoc.sdk.uia.instance.google.property.GoogleProperty
import cn.lnkdoc.sdk.uia.instance.bccastle.BccastleSdkInstance
import cn.lnkdoc.sdk.uia.instance.bccastle.property.BccastleProperty
import cn.lnkdoc.sdk.uia.instance.jban.JbanSdkInstance
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty
import cn.lnkdoc.sdk.uia.instance.weibo.WeiboSdkInstance
import cn.lnkdoc.sdk.uia.instance.weibo.property.WeiboProperty
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
    WX({ property -> wx(property) }, WxProperty::class.java),

    /**
     * alipay
     */
    ALIPAY({ property -> alipay(property) }, AlipayProperty::class.java),

    /**
     * github
     */
    GITHUB({ property -> github(property) }, GithubProperty::class.java),

    /**
     * gitee
     */
    GITEE({ property -> gitee(property) }, GiteeProperty::class.java),

    /**
     * google
     */
    GOOGLE({ property -> google(property) }, GoogleProperty::class.java),

    /**
     * gitlab
     */
    GITLAB({ property -> gitlab(property) }, GitlabProperty::class.java),

    /**
     * weibo
     */
    WEIBO({ property -> weibo(property) }, WeiboProperty::class.java),

    /**
     * bccastle
     */
    BCCASTLE({ property -> bccastle(property) }, BccastleProperty::class.java),
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
 * of yztoon
 *
 * @param property property
 * @return instance
 */
private fun yztoon(property: IUiaProperty): YztoonSdkInstance {
    return YztoonSdkInstance(property as YztoonProperty)
}

/**
 * of bjtoon
 *
 * @param property property
 * @return instance
 */
private fun bjtoon(property: IUiaProperty): ISdkInstance {
    return BjtoonSdkInstance(property as BjtoonProperty)
}

/**
 * of jban
 *
 * @param property property
 * @return instance
 */
private fun jban(property: IUiaProperty): JbanSdkInstance {
    return JbanSdkInstance(property as JbanProperty)
}

/**
 * of wx
 *
 * @param property property
 * @return instance
 */
private fun wx(property: IUiaProperty): WxSdkInstance {
    return WxSdkInstance(property as WxProperty)
}

/**
 * of alipay
 *
 * @param property property
 * @return instance
 */
private fun alipay(property: IUiaProperty): AlipaySdkInstance {
    return AlipaySdkInstance(property as AlipayProperty)
}

/**
 * of github
 *
 * @param property property
 * @return instance
 */
private fun github(property: IUiaProperty): GithubSdkInstance {
    return GithubSdkInstance(property as GithubProperty)
}

/**
 * of gitee
 *
 * @param property property
 * @return instance
 */
private fun gitee(property: IUiaProperty): GiteeSdkInstance {
    return GiteeSdkInstance(property as GiteeProperty)
}

/**
 * of google
 *
 * @param property property
 * @return instance
 */
private fun google(property: IUiaProperty): GoogleSdkInstance {
    return GoogleSdkInstance(property as GoogleProperty)
}

/**
 * of gitlab
 *
 * @param property property
 * @return instance
 */
private fun gitlab(property: IUiaProperty): GitlabSdkInstance {
    return GitlabSdkInstance(property as GitlabProperty)
}

/**
 * of weibo
 *
 * @param property property
 * @return instance
 */
private fun weibo(property: IUiaProperty): WeiboSdkInstance {
    return WeiboSdkInstance(property as WeiboProperty)
}

/**
 * of bccastle
 *
 * @param property property
 * @return instance
 */
private fun bccastle(property: IUiaProperty): BccastleSdkInstance {
    return BccastleSdkInstance(property as BccastleProperty)
}