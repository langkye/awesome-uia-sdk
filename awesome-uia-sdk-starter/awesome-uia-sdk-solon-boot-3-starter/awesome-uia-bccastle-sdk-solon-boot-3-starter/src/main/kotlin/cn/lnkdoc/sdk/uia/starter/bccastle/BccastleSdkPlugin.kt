package cn.lnkdoc.sdk.uia.starter.bccastle

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class BccastleSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(BccastleSdkConfiguration::class.java)
    }
}
