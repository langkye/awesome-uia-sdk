package cn.lnkdoc.sdk.uia.instance.gitee

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.gitee.property.GiteeProperty
import com.google.auto.service.AutoService


@AutoService(SdkInstanceProvider::class)
class GiteeSdkInstanceProvider : SdkInstanceProvider {
	companion object {
        const val NAME: String = "GITEE"
    }

	override fun getName(): String = NAME

    override fun getPropertyClass(): Class<out IUiaProperty> = GiteeProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = GiteeSdkInstance(property as GiteeProperty)
}
