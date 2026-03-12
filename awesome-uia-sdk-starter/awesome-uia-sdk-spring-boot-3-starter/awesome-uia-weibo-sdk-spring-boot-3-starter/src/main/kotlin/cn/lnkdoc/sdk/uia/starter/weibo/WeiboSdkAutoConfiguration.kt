package cn.lnkdoc.sdk.uia.starter.weibo

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.weibo.WeiboSdkInstanceProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

/**
 * Weibo Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@AutoConfiguration
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
    open fun weiboSdkInstance(properties: WeiboSdkProperties): ISdkInstance {
        return Instance.of(WeiboSdkInstanceProvider.NAME).function.invoke(properties)
    }
}
