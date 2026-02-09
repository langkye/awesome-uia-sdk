package cn.lnkdoc.sdk.uia.instance

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
class Instance private constructor(
    /**
     * function
     */
    val function: (IUiaProperty) -> ISdkInstance,
    /**
     * propertyClazz
     */
    val propertyClazz: Class<*>
) {

    companion object {
        private val nameCache = ConcurrentHashMap<String, Instance>()
        private val classCache = ConcurrentHashMap<Class<*>, Instance>()

        init {
            load()
        }

        @JvmStatic
        fun load(classLoader: ClassLoader? = null) {
            val loader = if (classLoader != null) {
                ServiceLoader.load(SdkInstanceProvider::class.java, classLoader)
            } else {
                ServiceLoader.load(SdkInstanceProvider::class.java)
            }
            
            loader.forEach { provider ->
                val instance = Instance({ property -> provider.createInstance(property) }, provider.getPropertyClass())
                nameCache[provider.getName().uppercase(Locale.getDefault())] = instance
                classCache[provider.getPropertyClass()] = instance
            }
        }

        /**
         * The name support: [cn.lnkdoc.sdk.uia.instance.SdkInstanceProvider.getName]
         */
        @JvmStatic
        fun of(name: String): Instance {
            return nameCache[name.uppercase(Locale.getDefault())]
                ?: throw IllegalArgumentException("Unsupported instance type: $name. Ensure the corresponding platform module is included in your dependencies.")
        }

        @JvmStatic
        fun of(propertyClazz: Class<*>): Instance {
            return classCache[propertyClazz]
                ?: throw IllegalArgumentException("Unsupported property type: ${propertyClazz.name}. Ensure the corresponding platform module is included in your dependencies.")
        }
        
        // Keep old enum-like constants for backward compatibility if needed, 
        // but they will only be available if the corresponding module is in classpath.
        // For a more robust migration, we could use lazy initialization or just let users use of()
    }
}
