package cn.lnkdoc.sdk.uia.common.property

/**
 * uia property
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
interface IUiaProperty {
    /**
     * isPrintStack
     *
     * @return boolean
     */
    fun isPrintStack() : Boolean
    
    /**
     * isPrintStack
     *
     * @return boolean
     */
    fun isUseInterceptor() : Boolean = false
}