package cn.lnkdoc.sdk.uia.starter.github

import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.github.GithubSdkInstance
import cn.lnkdoc.sdk.uia.instance.github.GithubSdkInstanceProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

/**
 * Github Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@AutoConfiguration
@EnableConfigurationProperties(GithubSdkProperties::class)
open class GithubSdkAutoConfiguration {

    /**
     * github sdk instance
     *
     * @param properties github sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["githubSdkInstance", GithubSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["githubSdkInstance"])
    open fun githubSdkInstance(properties: GithubSdkProperties): GithubSdkInstance {
        return Instance.of(GithubSdkInstanceProvider.NAME).function.invoke(properties) as GithubSdkInstance
    }
}
