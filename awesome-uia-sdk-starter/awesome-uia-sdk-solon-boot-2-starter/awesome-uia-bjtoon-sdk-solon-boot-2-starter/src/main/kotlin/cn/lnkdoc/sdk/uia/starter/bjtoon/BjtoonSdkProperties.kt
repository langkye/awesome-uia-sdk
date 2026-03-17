package cn.lnkdoc.sdk.uia.starter.bjtoon

import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Bjtoon Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Inject(value = $$"${uia-sdk.bjtoon}")
@Configuration
open class BjtoonSdkProperties : BjtoonProperty()
