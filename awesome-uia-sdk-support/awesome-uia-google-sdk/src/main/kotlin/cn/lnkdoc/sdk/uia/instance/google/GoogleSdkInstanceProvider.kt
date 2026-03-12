package cn.lnkdoc.sdk.uia.instance.google

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.google.property.GoogleProperty
import com.google.auto.service.AutoService


@AutoService(SdkInstanceProvider::class)
class GoogleSdkInstanceProvider : SdkInstanceProvider {
	companion object {
        const val NAME: String = "GOOGLE"
    }

	override fun getName(): String = NAME

    override fun getPropertyClass(): Class<out IUiaProperty> = GoogleProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = GoogleSdkInstance(property as GoogleProperty)
}
