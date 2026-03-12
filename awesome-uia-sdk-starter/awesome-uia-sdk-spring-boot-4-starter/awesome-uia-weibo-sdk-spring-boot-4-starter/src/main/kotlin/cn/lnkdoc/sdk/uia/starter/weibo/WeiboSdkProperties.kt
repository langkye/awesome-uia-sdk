package cn.lnkdoc.sdk.uia.starter.weibo

import cn.lnkdoc.sdk.uia.instance.weibo.property.WeiboProperty
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Weibo Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@ConfigurationProperties(prefix = "uia-sdk.weibo")
open class WeiboSdkProperties : WeiboProperty()
