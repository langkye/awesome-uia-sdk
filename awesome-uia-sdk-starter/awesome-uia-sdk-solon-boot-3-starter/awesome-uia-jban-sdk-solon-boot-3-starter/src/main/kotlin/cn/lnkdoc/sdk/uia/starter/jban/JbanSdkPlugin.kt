package cn.lnkdoc.sdk.uia.starter.jban

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class JbanSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(JbanSdkConfiguration::class.java)
    }
}
