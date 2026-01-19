package cn.lnkdoc.sdk.uia.instance.bjtoon

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty
import com.google.auto.service.AutoService

@AutoService(SdkInstanceProvider::class)
class BjtoonSdkInstanceProvider : SdkInstanceProvider {
    override fun getName(): String = "BJTOON"

    override fun getPropertyClass(): Class<out IUiaProperty> = BjtoonProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = BjtoonSdkInstance(property as BjtoonProperty)
}
