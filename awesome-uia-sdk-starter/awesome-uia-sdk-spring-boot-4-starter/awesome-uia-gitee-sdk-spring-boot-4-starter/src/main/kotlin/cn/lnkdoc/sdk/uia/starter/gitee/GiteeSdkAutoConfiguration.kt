package cn.lnkdoc.sdk.uia.starter.gitee

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.gitee.GiteeSdkInstanceProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

/**
 * Gitee Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@AutoConfiguration
@EnableConfigurationProperties(GiteeSdkProperties::class)
open class GiteeSdkAutoConfiguration {

    /**
     * gitee sdk instance
     *
     * @param properties gitee sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["giteeSdkInstance", GiteeSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["giteeSdkInstance"])
    open fun giteeSdkInstance(properties: GiteeSdkProperties): ISdkInstance {
        return Instance.of(GiteeSdkInstanceProvider.NAME).function.invoke(properties)
    }
}
