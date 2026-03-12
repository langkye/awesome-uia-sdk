package cn.lnkdoc.sdk.uia.starter.bjtoon

import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

/**
 * Bjtoon Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@ConfigurationProperties(prefix = "uia-sdk.bjtoon")
open class BjtoonSdkProperties : BjtoonProperty()
