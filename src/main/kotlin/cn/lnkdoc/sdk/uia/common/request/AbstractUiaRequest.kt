package cn.lnkdoc.sdk.uia.common.request

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import org.apache.commons.collections4.CollectionUtils
import java.util.*
import kotlin.collections.HashMap


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
abstract class AbstractUiaRequest : IUiaRequest {
    /**
     * get convert
     *
     * @return converts
     * @param <T> type
     * @param <R> type
     */
    override fun <T, R> getConvert(): List<IUiaConverter> {
        //var converts = converters[this.javaClass.getName()]
        var converts = converters.getOrDefault(this.javaClass.getName(), ArrayList())
        if (CollectionUtils.isEmpty(converts)) {
            loadConverters()
        }
        converts = converters.getOrDefault(this.javaClass.getName(), ArrayList())
        if (CollectionUtils.isEmpty(converts)) {
            converts = ArrayList()
            val finalConverts: MutableList<IUiaConverter> = converts
            converters.forEach { (k: String?, v: List<IUiaConverter?>?) ->
                if (k.contains(this.javaClass.getName())) {
                    finalConverts.addAll(v)
                }
            }
        }
        if (CollectionUtils.isEmpty(converts)) {
            throw UiaException("convert not found by name : " + this.javaClass.getName())
        }
        return converts
    }

    companion object {
        /**
         * converters
         */
        protected val converters: HashMap<String, MutableList<IUiaConverter>> = HashMap()

        /**
         * loadConverters
         */
        @JvmStatic
        private fun loadConverters() {
            val parseProviders = ServiceLoader.load(
                IUiaConverter::class.java
            )
            if (!parseProviders.iterator().hasNext()) {
                throw UiaException("not fund parser provider for IConverter")
            }
            for (converter in parseProviders) {
                val name = converter.name()
                var converts = converters[name]
                if (converts == null || CollectionUtils.isEmpty(converts)) {
                    converts = ArrayList()
                }
                converts.add(converter)
                converters[name] = converts
            }
        }
    }
}

