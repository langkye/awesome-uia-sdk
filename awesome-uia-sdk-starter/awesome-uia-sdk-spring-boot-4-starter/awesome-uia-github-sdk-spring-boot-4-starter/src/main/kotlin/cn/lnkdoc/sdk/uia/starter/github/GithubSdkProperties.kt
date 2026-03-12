package cn.lnkdoc.sdk.uia.starter.github

import cn.lnkdoc.sdk.uia.instance.github.property.GithubProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Github Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.github")
open class GithubSdkProperties : GithubProperty()
