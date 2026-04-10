package cn.lnkdoc.sdk.uia.starter.google

import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.google.GoogleSdkInstance
import cn.lnkdoc.sdk.uia.instance.google.GoogleSdkInstanceProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Google Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@EnableConfigurationProperties(GoogleSdkProperties::class)
open class GoogleSdkAutoConfiguration {

    /**
     * google sdk instance
     *
     * @param properties google sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["googleSdkInstance", GoogleSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["googleSdkInstance"])
    open fun googleSdkInstance(properties: GoogleSdkProperties): GoogleSdkInstance {
        return Instance.of(GoogleSdkInstanceProvider.NAME).function.invoke(properties) as GoogleSdkInstance
    }
}
