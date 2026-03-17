package cn.lnkdoc.sdk.uia.starter.github

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class GithubSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(GithubSdkConfiguration::class.java)
    }
}
