package cn.lnkdoc.sdk.uia.instance.bccastle

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.bccastle.property.BccastleProperty
import com.google.auto.service.AutoService


@AutoService(SdkInstanceProvider::class)
class BccastleSdkInstanceProvider : SdkInstanceProvider {
    override fun getName(): String = "BCCASTLE"

    override fun getPropertyClass(): Class<out IUiaProperty> = BccastleProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = BccastleSdkInstance(property as BccastleProperty)
}
