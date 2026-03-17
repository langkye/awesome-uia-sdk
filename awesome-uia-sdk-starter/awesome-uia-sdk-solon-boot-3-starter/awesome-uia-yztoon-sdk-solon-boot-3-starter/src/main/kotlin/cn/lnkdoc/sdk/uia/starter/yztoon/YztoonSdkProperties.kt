package cn.lnkdoc.sdk.uia.starter.yztoon

import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty
import org.noear.solon.annotation.BindProps
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Yztoon Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@BindProps(prefix = "uia-sdk.yztoon")
@Inject(value = $$"${uia-sdk.yztoon}")
@Configuration
open class YztoonSdkProperties : YztoonProperty()
