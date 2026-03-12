package cn.lnkdoc.sdk.uia.starter.google

import cn.lnkdoc.sdk.uia.instance.google.property.GoogleProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Google Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.google")
open class GoogleSdkProperties : GoogleProperty()
