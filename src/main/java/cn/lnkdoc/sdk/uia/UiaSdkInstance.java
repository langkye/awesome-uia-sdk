package cn.lnkdoc.sdk.uia;

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.Instance;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings("ALL")
public final class UiaSdkInstance {
    /**
     * auto load instance
     * 
     * @param property uia'property
     * @return uia'instance
     */
    public static ISdkInstance getInstance(IUiaProperty property) {
        return Instance.of(property.getClass()).getFunction().apply(property);
    }
}
