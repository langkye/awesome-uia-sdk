package cn.lnkdoc.sdk.uia.starter.alipay

import cn.lnkdoc.sdk.uia.instance.alipay.property.AlipayProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Alipay Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.alipay")
open class AlipaySdkProperties : AlipayProperty()
