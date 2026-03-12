package cn.lnkdoc.sdk.uia.instance.github

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.github.property.GithubProperty
import com.google.auto.service.AutoService


@AutoService(SdkInstanceProvider::class)
class GithubSdkInstanceProvider : SdkInstanceProvider {
	companion object {
        const val NAME: String = "GITHUB"
    }

	override fun getName(): String = NAME

    override fun getPropertyClass(): Class<out IUiaProperty> = GithubProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = GithubSdkInstance(property as GithubProperty)
}
