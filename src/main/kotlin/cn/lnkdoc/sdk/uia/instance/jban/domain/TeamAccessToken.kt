package cn.lnkdoc.sdk.uia.instance.jban.domain

import java.io.Serializable

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class TeamAccessToken : Serializable {
    /**
     * teamAccessToken
     */
    var teamAccessToken: String? = null
    /**
     * expireIn
     */
    var expireIn: String? = null

    companion object {
        private const val serialVersionUID = -508722906865178L
    }
}
