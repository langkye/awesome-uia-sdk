package cn.lnkdoc.sdk.uia.starter.wx

import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Wx Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.wx")
open class WxSdkProperties : WxProperty()
