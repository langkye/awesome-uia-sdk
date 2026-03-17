package cn.lnkdoc.sdk.uia.starter.weibo

import cn.lnkdoc.sdk.uia.instance.weibo.property.WeiboProperty
import org.noear.solon.annotation.BindProps
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Weibo Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@BindProps(prefix = "uia-sdk.weibo")
@Inject(value = $$"${uia-sdk.weibo}")
@Configuration
open class WeiboSdkProperties : WeiboProperty()
