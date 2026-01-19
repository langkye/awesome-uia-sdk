package cn.lnkdoc.sdk.uia.instance.jban.property

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class JbanProperty : IUiaProperty {
    /**
     * printStack
     */
    var printStack: Boolean = false
    /**
     * domain
     * 测试：[...](https://jzb-open-pre.jdcloud.com)
     * 生产-互联网：[...](https://open.jzb.beijing.gov.cn)
     * 生产-政务内网：[...](https://open.jzb.beijing.egov.cn)
     */
    var domain = "https://jzb-open-pre.jdcloud.com"
    /**
     * clientId
     */
    var clientId: String? = null
    /**
     * clientSecret
     */
    var clientSecret: String? = null
    /**
     * openTeamId
     */
    var openTeamId: String? = null
    /**
     * accessTokenPath
     */
    var accessTokenPath = "/open-api/auth/v1/access_token"
    /**
     * appAccessTokenPath
     */
    var appAccessTokenPath = "/open-api/auth/v1/app_access_token"
    /**
     * teamAccessTokenPath
     */
    var teamAccessTokenPath = "/open-api/auth/v1/team_access_token"
    /**
     * mobileMd5Path
     */
    var mobileMd5Path = "/open-api/contact/v1/user/md5?mobileMd5="

    /**
     * printStack
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }
}
