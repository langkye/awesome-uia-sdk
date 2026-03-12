package cn.lnkdoc.sdk.uia.starter.bccastle

import cn.lnkdoc.sdk.uia.instance.bccastle.property.BccastleProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Bccastle Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.bccastle")
open class BccastleSdkProperties : BccastleProperty()
