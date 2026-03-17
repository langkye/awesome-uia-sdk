package cn.lnkdoc.sdk.uia.starter.gitee

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.gitee.GiteeSdkInstance
import cn.lnkdoc.sdk.uia.instance.gitee.GiteeSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Gitee Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.gitee"])
open class GiteeSdkConfiguration {

    /**
     * gitee sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = GiteeSdkInstance::class)
    open fun giteeSdkInstance(context: AppContext): GiteeSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.gitee", GiteeSdkProperties::class.java)
        return Instance.of(GiteeSdkInstanceProvider.NAME).function.invoke(properties) as GiteeSdkInstance
    }
}
