package cn.lnkdoc.sdk.uia.starter.google

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class GoogleSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(GoogleSdkConfiguration::class.java)
    }
}
