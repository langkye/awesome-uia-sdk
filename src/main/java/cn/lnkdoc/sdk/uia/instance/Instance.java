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

    /**
     * of
     * 
     * @param property property
     * @return instance
     */
    private static YztoonSdkInstance yztoon(IUiaProperty property) {
        return new YztoonSdkInstance((YztoonProperty) property);
    }
    /**
     * of
     *
     * @param property property
     * @return instance
     */
    private static BjtoonSdkInstance bjtoon(IUiaProperty property) {
        return new BjtoonSdkInstance((BjtoonProperty) property);
    }
    /**
     * of
     *
     * @param property property
     * @return instance
     */
    private static JbanSdkInstance jban(IUiaProperty property) {
        return new JbanSdkInstance((JbanProperty) property);
    }
    /**
     * of
     *
     * @param property property
     * @return instance
     */
    private static WxSdkInstance wx(IUiaProperty property) {
        return new WxSdkInstance((WxProperty) property);
    }
    
    
    
    
    // ~=============================== Fileds/Constructor/Getter ===============================~ //
    /**
     * function
     */
    private final Function1<IUiaProperty, ISdkInstance> function;
    /**
     * propertyClazz
     */
    private final Class propertyClazz;


    /**
     * constructor
     * 
     * @param function function
     * @param propertyClazz propertyClazz
     */
    Instance(Function1<IUiaProperty, ISdkInstance> function, Class propertyClazz) {
        this.function = function;
        this.propertyClazz = propertyClazz;
    }

    /**
     * getter
     * 
     * @return function
     */
    public Function1<IUiaProperty, ISdkInstance> getFunction() {
        return function;
    }

    /**
     * getter
     * 
     * @return property clazz
     */
    public Class getPropertyClazz() {
        return propertyClazz;
    }

    // ~=============================== Tools ===============================~ //

    /**
     * of
     * 
     * @param name name
     * @return instance
     */
    public static Instance of(String name) {
        for (Instance instance : Instance.values()) {
            if (instance.toString().equals(name)) {
                return instance;
            }
        }
        throw new UiaException("not match instance for “" + name + "”");
    }

    /**
     * of
     * 
     * @param propertyClazz propertyClazz
     * @return instance
     */
    public static Instance of(Class propertyClazz) {
        for (Instance instance : Instance.values()) {
            if (instance.propertyClazz.equals(propertyClazz)) {
                return instance;
            }
        }
        throw new UiaException("un support property type : " + propertyClazz);
    }
}
