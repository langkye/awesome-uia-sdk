package cn.lnkdoc.sdk.uia.starter.gitlab

import cn.lnkdoc.sdk.uia.instance.gitlab.property.GitlabProperty
import org.noear.solon.annotation.BindProps
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Gitlab Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@BindProps(prefix = "uia-sdk.gitlab")
@Inject(value = $$"${uia-sdk.gitlab}")
@Configuration
open class GitlabSdkProperties : GitlabProperty()
