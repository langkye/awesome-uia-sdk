package cn.lnkdoc.sdk.uia.starter.bccastle

import cn.lnkdoc.sdk.uia.instance.bccastle.property.BccastleProperty
import org.noear.solon.annotation.BindProps
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Bccastle Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@BindProps(prefix = "uia-sdk.bccastle")
@Inject(value = $$"${uia-sdk.bccastle}")
@Configuration
open class BccastleSdkProperties : BccastleProperty()
