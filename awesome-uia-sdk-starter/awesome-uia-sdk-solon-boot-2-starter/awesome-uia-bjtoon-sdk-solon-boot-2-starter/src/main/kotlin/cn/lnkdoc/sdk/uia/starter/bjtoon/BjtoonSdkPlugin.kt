package cn.lnkdoc.sdk.uia.starter.bjtoon

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class BjtoonSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(BjtoonSdkConfiguration::class.java)
    }
}
