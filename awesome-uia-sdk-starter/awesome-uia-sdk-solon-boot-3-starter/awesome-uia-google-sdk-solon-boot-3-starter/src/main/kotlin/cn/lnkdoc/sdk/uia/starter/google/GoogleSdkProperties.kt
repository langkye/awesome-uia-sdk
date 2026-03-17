package cn.lnkdoc.sdk.uia.starter.google

import cn.lnkdoc.sdk.uia.instance.google.property.GoogleProperty
import org.noear.solon.annotation.BindProps
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Google Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@BindProps(prefix = "uia-sdk.google")
@Inject(value = $$"${uia-sdk.google}")
@Configuration
open class GoogleSdkProperties : GoogleProperty()
