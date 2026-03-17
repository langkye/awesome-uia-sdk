package cn.lnkdoc.sdk.uia.starter.gitlab

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class GitlabSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(GitlabSdkConfiguration::class.java)
    }
}
