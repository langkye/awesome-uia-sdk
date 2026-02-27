package cn.lnkdoc.sdk.uia.instance.gitee.domain

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


/**
 * access_token
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class UserInfo {
    @set:UiaJsonField(name = "avatar_url")
    var avatarUrl: String? = null
    @set:UiaJsonField(name = "bio")
    var bio: String? = null
    @set:UiaJsonField(name = "blog")
    var blog: String? = null
    @set:UiaJsonField(name = "created_at")
    var createdAt: String? = null
    @set:UiaJsonField(name = "email")
    var email: String? = null
    @set:UiaJsonField(name = "events_url")
    var eventsUrl: String? = null
    @set:UiaJsonField(name = "followers")
    var followers: Int? = null
    @set:UiaJsonField(name = "followers_url")
    var followersUrl: String? = null
    @set:UiaJsonField(name = "following")
    var following: Int? = null
    @set:UiaJsonField(name = "following_url")
    var followingUrl: String? = null
    @set:UiaJsonField(name = "gists_url")
    var gistsUrl: String? = null
    @set:UiaJsonField(name = "html_url")
    var htmlUrl: String? = null
    @set:UiaJsonField(name = "id")
    var id: Int? = null
    @set:UiaJsonField(name = "login")
    var login: String? = null
    @set:UiaJsonField(name = "name")
    var name: String? = null
    @set:UiaJsonField(name = "organizations_url")
    var organizationsUrl: String? = null
    @set:UiaJsonField(name = "public_gists")
    var publicGists: Int? = null
    @set:UiaJsonField(name = "public_repos")
    var publicRepos: Int? = null
    @set:UiaJsonField(name = "received_events_url")
    var receivedEventsUrl: String? = null
    @set:UiaJsonField(name = "remark")
    var remark: String? = null
    @set:UiaJsonField(name = "repos_url")
    var reposUrl: String? = null
    @set:UiaJsonField(name = "stared")
    var stared: Int? = null
    @set:UiaJsonField(name = "starred_url")
    var starredUrl: String? = null
    @set:UiaJsonField(name = "subscriptions_url")
    var subscriptionsUrl: String? = null
    @set:UiaJsonField(name = "type")
    var type: String? = null
    @set:UiaJsonField(name = "updated_at")
    var updatedAt: String? = null
    @set:UiaJsonField(name = "url")
    var url: String? = null
    @set:UiaJsonField(name = "watched")
    var watched: Int? = null
    @set:UiaJsonField(name = "weibo")
    var weibo: String? = null
    @set:UiaJsonField(name = "message")
    var message: String? = null
        set(value) {
            field = value
            success = false
        }
    var success: Boolean = true
}
