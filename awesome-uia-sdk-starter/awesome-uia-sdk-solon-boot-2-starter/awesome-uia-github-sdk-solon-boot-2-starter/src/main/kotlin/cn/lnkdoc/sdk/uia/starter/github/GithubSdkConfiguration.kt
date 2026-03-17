package cn.lnkdoc.sdk.uia.starter.github

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.github.GithubSdkInstance
import cn.lnkdoc.sdk.uia.instance.github.GithubSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Github Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.github"])
open class GithubSdkConfiguration {

    /**
     * github sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = GithubSdkInstance::class)
    open fun githubSdkInstance(context: AppContext): GithubSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.github", GithubSdkProperties::class.java)
        return Instance.of(GithubSdkInstanceProvider.NAME).function.invoke(properties) as GithubSdkInstance
    }
}
