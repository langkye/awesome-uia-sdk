package cn.lnkdoc.sdk.uia.starter.bjtoon

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.bjtoon.BjtoonSdkInstance
import cn.lnkdoc.sdk.uia.instance.bjtoon.BjtoonSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Bjtoon Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.bjtoon"])
open class BjtoonSdkConfiguration {

    /**
     * bjtoon sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = BjtoonSdkInstance::class)
    open fun bjtoonSdkInstance(context: AppContext): BjtoonSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.bjtoon", BjtoonSdkProperties::class.java)
        return Instance.of(BjtoonSdkInstanceProvider.NAME).function.invoke(properties) as BjtoonSdkInstance
    }
}
