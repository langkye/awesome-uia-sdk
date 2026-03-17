package cn.lnkdoc.sdk.uia.starter.yztoon

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class YztoonSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(YztoonSdkConfiguration::class.java)
    }
}
