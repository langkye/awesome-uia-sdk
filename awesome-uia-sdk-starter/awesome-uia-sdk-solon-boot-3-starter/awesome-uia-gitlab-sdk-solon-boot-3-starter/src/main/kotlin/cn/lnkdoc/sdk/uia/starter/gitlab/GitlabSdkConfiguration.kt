package cn.lnkdoc.sdk.uia.starter.gitlab

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.gitlab.GitlabSdkInstance
import cn.lnkdoc.sdk.uia.instance.gitlab.GitlabSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Gitlab Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.gitlab"])
open class GitlabSdkConfiguration {

    /**
     * gitlab sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = GitlabSdkInstance::class)
    open fun gitlabSdkInstance(context: AppContext): GitlabSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.gitlab", GitlabSdkProperties::class.java)
        return Instance.of(GitlabSdkInstanceProvider.NAME).function.invoke(properties) as GitlabSdkInstance
    }
}
