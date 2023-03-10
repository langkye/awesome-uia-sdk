package cn.lnkdoc.sdk.uia.common.request;

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public abstract class AbstractUiaRequest implements IUiaRequest {
    @SuppressWarnings("ALL")
    protected static final Map<String, List<IUiaConverter>> converters = new HashMap<>();
    
    @SuppressWarnings({"rawtypes"})
    @Override
    public <T, R> List<IUiaConverter> getConvert() {
        List<IUiaConverter> converts = converters.get(this.getClass().getSimpleName());
        if (CollectionUtils.isEmpty(converts)) {
            loadConverters();
        }
        converts = converters.get(this.getClass().getSimpleName());

        if (CollectionUtils.isEmpty(converts)) {
            converts = new ArrayList<>();
            List<IUiaConverter> finalConverts = converts;
            converters.forEach((k, v) -> {
                if (k != null && k.contains(this.getClass().getSimpleName())) {
                    finalConverts.addAll(v);
                }
            });
        }

        if (CollectionUtils.isEmpty(converts)) {
            throw new UiaException("convert not found by name : " + this.getClass().getSimpleName());
        }
        
        return converts;
    }
    

    @SuppressWarnings("ALL")
    private static void loadConverters() {
        ServiceLoader<IUiaConverter> parseProviders = ServiceLoader.load(IUiaConverter.class);
        if (!parseProviders.iterator().hasNext()) {
            throw new UiaException("not fund parser provider for IConverter");
        }
        for (IUiaConverter converter : parseProviders) {
            List<IUiaConverter> converts = converters.get(converter.name());
            if (CollectionUtils.isEmpty(converts)) {
                converts = new ArrayList<>();
            }
            converts.add(converter);
            converters.put(converter.name(), converts);
        }
    }
}
