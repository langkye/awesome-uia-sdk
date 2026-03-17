package cn.lnkdoc.sdk.uia.starter.yztoon

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.yztoon.YztoonSdkInstance
import cn.lnkdoc.sdk.uia.instance.yztoon.YztoonSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Yztoon Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.yztoon"])
open class YztoonSdkConfiguration {

    /**
     * yztoon sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = YztoonSdkInstance::class)
    open fun yztoonSdkInstance(context: AppContext): YztoonSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.yztoon", YztoonSdkProperties::class.java)
        return Instance.of(YztoonSdkInstanceProvider.NAME).function.invoke(properties) as YztoonSdkInstance
    }
}
