package cn.lnkdoc.sdk.uia.starter.google

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.google.GoogleSdkInstance
import cn.lnkdoc.sdk.uia.instance.google.GoogleSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Google Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.google"])
open class GoogleSdkConfiguration {

    /**
     * google sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = GoogleSdkInstance::class)
    open fun googleSdkInstance(context: AppContext): GoogleSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.google", GoogleSdkProperties::class.java)
        return Instance.of(GoogleSdkInstanceProvider.NAME).function.invoke(properties) as GoogleSdkInstance
    }
}
