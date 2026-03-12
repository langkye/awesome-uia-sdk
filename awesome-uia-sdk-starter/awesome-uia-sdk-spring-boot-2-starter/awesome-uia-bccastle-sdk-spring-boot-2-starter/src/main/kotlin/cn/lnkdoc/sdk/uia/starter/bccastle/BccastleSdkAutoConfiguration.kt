package cn.lnkdoc.sdk.uia.starter.bccastle

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.bccastle.BccastleSdkInstanceProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Bccastle Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@EnableConfigurationProperties(BccastleSdkProperties::class)
open class BccastleSdkAutoConfiguration {

    /**
     * bccastle sdk instance
     *
     * @param properties bccastle sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["bccastleSdkInstance", BccastleSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["bccastleSdkInstance"])
    open fun bccastleSdkInstance(properties: BccastleSdkProperties): ISdkInstance {
        return Instance.of(BccastleSdkInstanceProvider.NAME).function.invoke(properties)
    }
}
