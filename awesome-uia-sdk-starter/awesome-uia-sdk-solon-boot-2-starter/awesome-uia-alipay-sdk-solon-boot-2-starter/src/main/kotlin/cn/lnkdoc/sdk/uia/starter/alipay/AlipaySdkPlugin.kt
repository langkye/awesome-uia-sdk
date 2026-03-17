package cn.lnkdoc.sdk.uia.starter.alipay

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class AlipaySdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(AlipaySdkConfiguration::class.java)
    }
}
