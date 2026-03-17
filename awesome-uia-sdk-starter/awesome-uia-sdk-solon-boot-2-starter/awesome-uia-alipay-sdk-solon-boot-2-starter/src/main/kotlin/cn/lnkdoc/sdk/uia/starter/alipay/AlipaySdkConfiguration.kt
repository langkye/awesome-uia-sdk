package cn.lnkdoc.sdk.uia.starter.alipay

import cn.lnkdoc.sdk.uia.instance.ISdkInstance
import cn.lnkdoc.sdk.uia.instance.Instance
import cn.lnkdoc.sdk.uia.instance.alipay.AlipaySdkInstance
import cn.lnkdoc.sdk.uia.instance.alipay.AlipaySdkInstanceProvider
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Condition
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Import
import org.noear.solon.core.AppContext

/**
 * Alipay Sdk Configuration
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Configuration
@Import(scanPackages = ["cn.lnkdoc.sdk.uia.starter.alipay"])
open class AlipaySdkConfiguration {

    /**
     * alipay sdk instance
     *
     * @param context solon app context
     * @return [ISdkInstance]
     */
    @Bean
    @Condition(onMissingBean = AlipaySdkInstance::class)
    open fun alipaySdkInstance(context: AppContext): AlipaySdkInstance {
        val properties = context.cfg().toBean("uia-sdk.alipay", AlipaySdkProperties::class.java)
        return Instance.of(AlipaySdkInstanceProvider.NAME).function.invoke(properties) as AlipaySdkInstance
    }
}
