package cn.lnkdoc.sdk.uia.instance.alipay

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.alipay.property.AlipayProperty
import com.google.auto.service.AutoService


@AutoService(SdkInstanceProvider::class)
class AlipaySdkInstanceProvider : SdkInstanceProvider {
    companion object {
        const val NAME: String = "ALIPAY"
    }

	override fun getName(): String = NAME

    override fun getPropertyClass(): Class<out IUiaProperty> = AlipayProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = AlipaySdkInstance(property as AlipayProperty)
}
