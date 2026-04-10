package cn.lnkdoc.sdk.uia.starter.github

import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.github.GithubSdkInstance
import cn.lnkdoc.sdk.uia.instance.github.GithubSdkInstanceProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * GitHub Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@EnableConfigurationProperties(GithubSdkProperties::class)
open class GithubSdkAutoConfiguration {

    /**
     * GitHub sdk instance
     *
     * @param properties GitHub sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["githubSdkInstance", GithubSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["githubSdkInstance"])
    open fun githubSdkInstance(properties: GithubSdkProperties): GithubSdkInstance {
        return Instance.of(GithubSdkInstanceProvider.NAME).function.invoke(properties) as GithubSdkInstance
    }
}
