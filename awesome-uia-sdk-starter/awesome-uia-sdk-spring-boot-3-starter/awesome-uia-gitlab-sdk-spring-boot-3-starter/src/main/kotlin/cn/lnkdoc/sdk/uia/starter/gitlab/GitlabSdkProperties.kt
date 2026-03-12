package cn.lnkdoc.sdk.uia.starter.gitlab

import cn.lnkdoc.sdk.uia.instance.gitlab.property.GitlabProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Gitlab Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.gitlab")
open class GitlabSdkProperties : GitlabProperty()
