package cn.lnkdoc.sdk.uia.starter.gitee

import cn.lnkdoc.sdk.uia.instance.gitee.property.GiteeProperty
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Gitee Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Inject(value = $$"${uia-sdk.gitee}")
@Configuration
open class GiteeSdkProperties : GiteeProperty()
