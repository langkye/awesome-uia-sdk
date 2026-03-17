package cn.lnkdoc.sdk.uia.starter.jban

import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty
import org.noear.solon.annotation.BindProps
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Jban Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@BindProps(prefix = "uia-sdk.jban")
@Inject(value = $$"${uia-sdk.jban}")
@Configuration
open class JbanSdkProperties : JbanProperty()
