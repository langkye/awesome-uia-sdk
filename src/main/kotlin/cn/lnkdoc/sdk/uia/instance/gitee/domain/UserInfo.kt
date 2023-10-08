package cn.lnkdoc.sdk.uia.instance.gitee.domain

import com.alibaba.fastjson2.annotation.JSONField

/**
 * access_token
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class UserInfo {
    @set:JSONField(name = "avatar_url")
    var avatarUrl: String? = null
    @set:JSONField(name = "bio")
    var bio: String? = null
    @set:JSONField(name = "blog")
    var blog: String? = null
    @set:JSONField(name = "created_at")
    var createdAt: String? = null
    @set:JSONField(name = "email")
    var email: String? = null
    @set:JSONField(name = "events_url")
    var eventsUrl: String? = null
    @set:JSONField(name = "followers")
    var followers: Int? = null
    @set:JSONField(name = "followers_url")
    var followersUrl: String? = null
    @set:JSONField(name = "following")
    var following: Int? = null
    @set:JSONField(name = "following_url")
    var followingUrl: String? = null
    @set:JSONField(name = "gists_url")
    var gistsUrl: String? = null
    @set:JSONField(name = "html_url")
    var htmlUrl: String? = null
    @set:JSONField(name = "id")
    var id: Int? = null
    @set:JSONField(name = "login")
    var login: String? = null
    @set:JSONField(name = "name")
    var name: String? = null
    @set:JSONField(name = "organizations_url")
    var organizationsUrl: String? = null
    @set:JSONField(name = "public_gists")
    var publicGists: Int? = null
    @set:JSONField(name = "public_repos")
    var publicRepos: Int? = null
    @set:JSONField(name = "received_events_url")
    var receivedEventsUrl: String? = null
    @set:JSONField(name = "remark")
    var remark: String? = null
    @set:JSONField(name = "repos_url")
    var reposUrl: String? = null
    @set:JSONField(name = "stared")
    var stared: Int? = null
    @set:JSONField(name = "starred_url")
    var starredUrl: String? = null
    @set:JSONField(name = "subscriptions_url")
    var subscriptionsUrl: String? = null
    @set:JSONField(name = "type")
    var type: String? = null
    @set:JSONField(name = "updated_at")
    var updatedAt: String? = null
    @set:JSONField(name = "url")
    var url: String? = null
    @set:JSONField(name = "watched")
    var watched: Int? = null
    @set:JSONField(name = "weibo")
    var weibo: String? = null
    @set:JSONField(name = "message")
    var message: String? = null
        set(value) {
            field = value
            success = false
        }
    var success: Boolean = true
}