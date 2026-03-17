package cn.lnkdoc.sdk.uia.starter.weibo

import org.noear.solon.core.AppContext
import org.noear.solon.core.Plugin

class WeiboSdkPlugin : Plugin {
    override fun start(context: AppContext) {
        context.beanMake(WeiboSdkConfiguration::class.java)
    }
}
