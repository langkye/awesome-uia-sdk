package cn.lnkdoc.sdk.uia.instance.yztoon

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty
import com.google.auto.service.AutoService


@AutoService(SdkInstanceProvider::class)
class YztoonSdkInstanceProvider : SdkInstanceProvider {
    override fun getName(): String = "YZTOON"

    override fun getPropertyClass(): Class<out IUiaProperty> = YztoonProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = YztoonSdkInstance(property as YztoonProperty)
}
