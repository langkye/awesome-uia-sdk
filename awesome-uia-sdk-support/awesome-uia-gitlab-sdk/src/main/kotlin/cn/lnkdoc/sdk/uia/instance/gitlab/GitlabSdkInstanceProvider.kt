package cn.lnkdoc.sdk.uia.instance.gitlab

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider
import cn.lnkdoc.sdk.uia.instance.gitlab.property.GitlabProperty
import com.google.auto.service.AutoService

@AutoService(SdkInstanceProvider::class)
class GitlabSdkInstanceProvider : SdkInstanceProvider {
    override fun getName(): String = "GITLAB"

    override fun getPropertyClass(): Class<out IUiaProperty> = GitlabProperty::class.java

    override fun createInstance(property: IUiaProperty): ISdkInstance = GitlabSdkInstance(property as GitlabProperty)
}
