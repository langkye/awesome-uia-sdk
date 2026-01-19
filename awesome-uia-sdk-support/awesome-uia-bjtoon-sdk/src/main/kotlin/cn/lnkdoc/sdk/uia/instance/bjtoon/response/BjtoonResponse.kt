package cn.lnkdoc.sdk.uia.instance.bjtoon.response

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class BjtoonResponse<T> {
    /**
     * data
     */
    var data: T? = null
        private set
    /**
     * meta
     */
    var meta: Meta? = null

    /**
     * data
     */
    fun setData(data: T) {
        this.data = data
    }

    /**
     * Meta class
     */
    class Meta {
        /**
         * code
         */
        var code: Int? = null
        /**
         * message
         */
        var message: String? = null
    }
}

