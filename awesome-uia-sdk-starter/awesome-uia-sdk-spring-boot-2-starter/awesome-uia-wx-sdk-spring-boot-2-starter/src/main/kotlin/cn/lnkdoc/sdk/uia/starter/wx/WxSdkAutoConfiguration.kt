package cn.lnkdoc.sdk.uia.starter.wx

import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.wx.WxSdkInstance
import cn.lnkdoc.sdk.uia.instance.wx.WxSdkInstanceProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Wx Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@EnableConfigurationProperties(WxSdkProperties::class)
open class WxSdkAutoConfiguration {

    /**
     * wx sdk instance
     *
     * @param properties wx sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["wxSdkInstance", WxSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["wxSdkInstance"])
    open fun wxSdkInstance(properties: WxSdkProperties): WxSdkInstance {
        return Instance.of(WxSdkInstanceProvider.NAME).function.invoke(properties) as WxSdkInstance
    }
}
