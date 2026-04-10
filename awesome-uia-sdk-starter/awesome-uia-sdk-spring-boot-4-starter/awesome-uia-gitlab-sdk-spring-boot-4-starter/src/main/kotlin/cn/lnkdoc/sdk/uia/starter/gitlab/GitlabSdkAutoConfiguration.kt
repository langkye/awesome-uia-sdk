package cn.lnkdoc.sdk.uia.starter.gitlab

import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.gitlab.GitlabSdkInstance
import cn.lnkdoc.sdk.uia.instance.gitlab.GitlabSdkInstanceProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

/**
 * Gitlab Sdk AutoConfiguration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@AutoConfiguration
@EnableConfigurationProperties(GitlabSdkProperties::class)
open class GitlabSdkAutoConfiguration {

    /**
     * gitlab sdk instance
     *
     * @param properties gitlab sdk properties
     * @return ISdkInstance
     */
    @Bean(name = ["gitlabSdkInstance", GitlabSdkInstanceProvider.NAME])
    @ConditionalOnMissingBean(name = ["gitlabSdkInstance"])
    open fun gitlabSdkInstance(properties: GitlabSdkProperties): GitlabSdkInstance {
        return Instance.of(GitlabSdkInstanceProvider.NAME).function.invoke(properties) as GitlabSdkInstance
    }
}
