package cn.lnkdoc.sdk.uia.instance.weibo

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.weibo.property.WeiboProperty
import com.google.auto.service.AutoService


@AutoService(SdkInstanceProvider::class)
class WeiboSdkInstanceProvider : SdkInstanceProvider {
	companion object {
        const val NAME: String = "WEIBO"
    }

	override fun getName(): String = NAME

    override fun getPropertyClass(): Class<out IUiaProperty> = WeiboProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = WeiboSdkInstance(property as WeiboProperty)
}
