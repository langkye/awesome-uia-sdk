package cn.lnkdoc.sdk.uia.starter.alipay

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.alipay.AlipaySdkInstanceProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Alipay Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@EnableConfigurationProperties(AlipaySdkProperties::class)
open class AlipaySdkAutoConfiguration {

    /**
     * alipay sdk instance
     *
     * @param properties alipay sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["alipaySdkInstance", AlipaySdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["alipaySdkInstance", AlipaySdkInstanceProvider.NAME])
    open fun alipaySdkInstance(properties: AlipaySdkProperties): ISdkInstance {
        return Instance.of(AlipaySdkInstanceProvider.NAME).function.invoke(properties)
    }
}
