package cn.lnkdoc.sdk.uia.starter.jban

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.jban.JbanSdkInstance
import cn.lnkdoc.sdk.uia.instance.jban.JbanSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Jban Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.jban"])
open class JbanSdkConfiguration {

    /**
     * jban sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = JbanSdkInstance::class)
    open fun jbanSdkInstance(context: AppContext): JbanSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.jban", JbanSdkProperties::class.java)
        return Instance.of(JbanSdkInstanceProvider.NAME).function.invoke(properties) as JbanSdkInstance
    }
}
