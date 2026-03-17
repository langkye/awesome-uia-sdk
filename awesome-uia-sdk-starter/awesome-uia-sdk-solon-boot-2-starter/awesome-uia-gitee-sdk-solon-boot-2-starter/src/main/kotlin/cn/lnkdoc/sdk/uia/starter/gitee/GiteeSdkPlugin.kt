package cn.lnkdoc.sdk.uia.starter.gitee

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class GiteeSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(GiteeSdkConfiguration::class.java)
    }
}
