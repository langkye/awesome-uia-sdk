package cn.lnkdoc.sdk.uia.starter.wx

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class WxSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(WxSdkConfiguration::class.java)
    }
}
