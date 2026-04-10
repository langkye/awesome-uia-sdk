package cn.lnkdoc.sdk.uia.starter.yztoon

import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.yztoon.YztoonSdkInstance
import cn.lnkdoc.sdk.uia.instance.yztoon.YztoonSdkInstanceProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Yztoon Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@EnableConfigurationProperties(YztoonSdkProperties::class)
open class YztoonSdkAutoConfiguration {

    /**
     * yztoon sdk instance
     *
     * @param properties yztoon sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["yztoonSdkInstance", YztoonSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["yztoonSdkInstance"])
    open fun yztoonSdkInstance(properties: YztoonSdkProperties): YztoonSdkInstance {
        return Instance.of(YztoonSdkInstanceProvider.NAME).function.invoke(properties) as YztoonSdkInstance
    }
}
