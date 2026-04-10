package cn.lnkdoc.sdk.uia.starter.alipay

import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.alipay.AlipaySdkInstance
import cn.lnkdoc.sdk.uia.instance.alipay.AlipaySdkInstanceProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

/**
 * Alipay Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@AutoConfiguration
@EnableConfigurationProperties(AlipaySdkProperties::class)
open class AlipaySdkAutoConfiguration {

    /**
     * alipay sdk instance
     *
     * @param properties alipay sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["alipaySdkInstance", AlipaySdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["alipaySdkInstance"])
    open fun alipaySdkInstance(properties: AlipaySdkProperties): AlipaySdkInstance {
        return Instance.of(AlipaySdkInstanceProvider.NAME).function.invoke(properties) as AlipaySdkInstance
    }
}
