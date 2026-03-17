package cn.lnkdoc.sdk.uia.starter.bccastle

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.bccastle.BccastleSdkInstance
import cn.lnkdoc.sdk.uia.instance.bccastle.BccastleSdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Bccastle Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.bccastle"])
open class BccastleSdkConfiguration {

    /**
     * bccastle sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = BccastleSdkInstance::class)
    open fun bccastleSdkInstance(context: AppContext): BccastleSdkInstance {
        val properties = context.cfg().toBean("uia-sdk.bccastle", BccastleSdkProperties::class.java)
        return Instance.of(BccastleSdkInstanceProvider.NAME).function.invoke(properties) as BccastleSdkInstance
    }
}
