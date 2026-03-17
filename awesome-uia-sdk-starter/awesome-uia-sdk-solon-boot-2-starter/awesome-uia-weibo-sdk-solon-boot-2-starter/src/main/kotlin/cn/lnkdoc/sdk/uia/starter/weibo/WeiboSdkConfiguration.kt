package cn.lnkdoc.sdk.uia.starter.weibo

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.weibo.WeiboSdkInstance
import cn.lnkdoc.sdk.uia.instance.weibo.WeiboSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Weibo Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.weibo"])
open class WeiboSdkConfiguration {

    /**
     * weibo sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = WeiboSdkInstance::class)
    open fun weiboSdkInstance(context: AppContext): WeiboSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.weibo", WeiboSdkProperties::class.java)
        return Instance.of(WeiboSdkInstanceProvider.NAME).function.invoke(properties) as WeiboSdkInstance
    }
}
