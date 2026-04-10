package cn.lnkdoc.sdk.uia.starter.bjtoon

import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.bjtoon.BjtoonSdkInstance
import cn.lnkdoc.sdk.uia.instance.bjtoon.BjtoonSdkInstanceProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

/**
 * Bjtoon Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@AutoConfiguration
@EnableConfigurationProperties(BjtoonSdkProperties::class)
open class BjtoonSdkAutoConfiguration {

    /**
     * bjtoon sdk instance
     *
     * @param properties bjtoon sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["bjtoonSdkInstance", BjtoonSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["bjtoonSdkInstance"])
    open fun bjtoonSdkInstance(properties: BjtoonSdkProperties): BjtoonSdkInstance {
        return Instance.of(BjtoonSdkInstanceProvider.NAME).function.invoke(properties) as BjtoonSdkInstance
    }
}
