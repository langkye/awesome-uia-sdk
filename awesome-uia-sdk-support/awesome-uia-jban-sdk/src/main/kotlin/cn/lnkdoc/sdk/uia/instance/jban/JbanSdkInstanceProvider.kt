package cn.lnkdoc.sdk.uia.instance.jban

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty
import com.google.auto.service.AutoService


@AutoService(SdkInstanceProvider::class)
class JbanSdkInstanceProvider : SdkInstanceProvider {
    override fun getName(): String = "JBAN"

    override fun getPropertyClass(): Class<out IUiaProperty> = JbanProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = JbanSdkInstance(property as JbanProperty)
}
