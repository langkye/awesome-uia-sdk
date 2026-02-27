package cn.lnkdoc.sdk.uia.instance.wx

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty
import com.google.auto.service.AutoService


@AutoService(SdkInstanceProvider::class)
class WxSdkInstanceProvider : SdkInstanceProvider {
    override fun getName(): String = "WX"

    override fun getPropertyClass(): Class<out IUiaProperty> = WxProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = WxSdkInstance(property as WxProperty)
}
