package cn.lnkdoc.sdk.uia.starter.wx

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.wx.WxSdkInstance
import cn.lnkdoc.sdk.uia.instance.wx.WxSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Wx Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.wx"])
open class WxSdkConfiguration {

    /**
     * wx sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = WxSdkInstance::class)
    open fun wxSdkInstance(context: AppContext): WxSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.wx", WxSdkProperties::class.java)
        return Instance.of(WxSdkInstanceProvider.NAME).function.invoke(properties) as WxSdkInstance
    }
}
