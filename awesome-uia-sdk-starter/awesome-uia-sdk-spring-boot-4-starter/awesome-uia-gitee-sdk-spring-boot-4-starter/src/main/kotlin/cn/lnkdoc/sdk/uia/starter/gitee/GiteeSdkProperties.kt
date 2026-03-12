package cn.lnkdoc.sdk.uia.starter.gitee

import cn.lnkdoc.sdk.uia.instance.gitee.property.GiteeProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Gitee Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.gitee")
open class GiteeSdkProperties : GiteeProperty()
