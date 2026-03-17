package cn.lnkdoc.sdk.uia.starter.github

import cn.lnkdoc.sdk.uia.instance.github.property.GithubProperty
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject

/**
 * Github Sdk Properties
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Inject(value = $$"${uia-sdk.github}")
@Configuration
open class GithubSdkProperties : GithubProperty()
