package cn.lnkdoc.sdk.uia.starter.jban

import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Jban Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.jban")
open class JbanSdkProperties : JbanProperty()
