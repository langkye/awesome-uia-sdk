package cn.lnkdoc.sdk.uia.starter.wx

import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty
import org.noear.solon.annotation.BindProps
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Wx Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@BindProps(prefix = "uia-sdk.wx")
@Inject(value = $$"${uia-sdk.wx}")
@Configuration
open class WxSdkProperties : WxProperty()
