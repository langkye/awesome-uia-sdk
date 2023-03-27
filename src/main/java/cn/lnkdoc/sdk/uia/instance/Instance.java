package cn.lnkdoc.sdk.uia.instance;

import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.BjtoonSdkInstance;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;
import cn.lnkdoc.sdk.uia.instance.jban.JbanSdkInstance;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;
import cn.lnkdoc.sdk.uia.instance.wx.WxSdkInstance;
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty;
import cn.lnkdoc.sdk.uia.instance.yztoon.YztoonSdkInstance;
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty;
import io.vavr.Function1;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings("ALL")
public enum Instance {
    /**
     * yztoon
     */
    YZTOON(Instance::yztoon, YztoonProperty.class),
    /**
     * bjtoon
     */
    BJTOON(Instance::bjtoon, BjtoonProperty.class),
    /**
     * jban
     */
    JBAN(Instance::jban, JbanProperty.class),
    /**
     * wx
     */
    WX(Instance::wx, WxProperty.class),
    ;

    
    // ~=============================== Instances ===============================~ //
    private static YztoonSdkInstance yztoon(IUiaProperty property) {
        return new YztoonSdkInstance((YztoonProperty) property);
    }
    
    private static BjtoonSdkInstance bjtoon(IUiaProperty property) {
        return new BjtoonSdkInstance((BjtoonProperty) property);
    }
    
    private static JbanSdkInstance jban(IUiaProperty property) {
        return new JbanSdkInstance((JbanProperty) property);
    }
    
    
    private static WxSdkInstance wx(IUiaProperty property) {
        return new WxSdkInstance((WxProperty) property);
    }
    
    
    
    
    // ~=============================== Fileds/Constructor/Getter ===============================~ //
    private final Function1<IUiaProperty, ISdkInstance> function;
    private final Class propertyClazz;


    Instance(Function1<IUiaProperty, ISdkInstance> function, Class propertyClazz) {
        this.function = function;
        this.propertyClazz = propertyClazz;
    }
    
    public Function1<IUiaProperty, ISdkInstance> getFunction() {
        return function;
    }

    public Class getPropertyClazz() {
        return propertyClazz;
    }

    // ~=============================== Tools ===============================~ //
    
    public static Instance of(String name) {
        for (Instance instance : Instance.values()) {
            if (instance.toString().equals(name)) {
                return instance;
            }
        }
        throw new UiaException("not match instance for “" + name + "”");
    }
    
    public static Instance of(Class propertyClazz) {
        for (Instance instance : Instance.values()) {
            if (instance.propertyClazz.equals(propertyClazz)) {
                return instance;
            }
        }
        throw new UiaException("un support property type : " + propertyClazz);
    }
}
