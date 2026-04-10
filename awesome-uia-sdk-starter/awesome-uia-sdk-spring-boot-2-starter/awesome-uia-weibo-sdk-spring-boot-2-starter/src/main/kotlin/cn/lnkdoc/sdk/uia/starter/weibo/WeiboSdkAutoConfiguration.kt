package cn.lnkdoc.sdk.uia.starter.weibo

import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.weibo.WeiboSdkInstance
import cn.lnkdoc.sdk.uia.instance.weibo.WeiboSdkInstanceProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Weibo Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@EnableConfigurationProperties(WeiboSdkProperties::class)
open class WeiboSdkAutoConfiguration {

    /**
     * weibo sdk instance
     *
     * @param properties weibo sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["weiboSdkInstance", WeiboSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["weiboSdkInstance"])
    open fun weiboSdkInstance(properties: WeiboSdkProperties): WeiboSdkInstance {
        return Instance.of(WeiboSdkInstanceProvider.NAME).function.invoke(properties) as WeiboSdkInstance
    }
}
