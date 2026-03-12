package cn.lnkdoc.sdk.uia.starter.jban

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.jban.JbanSdkInstanceProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Jban Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@EnableConfigurationProperties(JbanSdkProperties::class)
open class JbanSdkAutoConfiguration {

    /**
     * jban sdk instance
     *
     * @param properties jban sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["jbanSdkInstance", JbanSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["jbanSdkInstance"])
    open fun jbanSdkInstance(properties: JbanSdkProperties): ISdkInstance {
        return Instance.of(JbanSdkInstanceProvider.NAME).function.invoke(properties)
    }
}
