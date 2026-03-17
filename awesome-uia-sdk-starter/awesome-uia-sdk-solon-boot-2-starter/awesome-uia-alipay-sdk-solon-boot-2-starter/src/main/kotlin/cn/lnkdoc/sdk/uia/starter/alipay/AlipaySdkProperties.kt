package cn.lnkdoc.sdk.uia.starter.alipay

import cn.lnkdoc.sdk.uia.instance.alipay.property.AlipayProperty
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Alipay Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Inject(value = $$"${uia-sdk.alipay}")
@Configuration
open class AlipaySdkProperties : AlipayProperty()
