package cn.lnkdoc.sdk.uia.starter.yztoon

import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Yztoon Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.yztoon")
open class YztoonSdkProperties : YztoonProperty()
