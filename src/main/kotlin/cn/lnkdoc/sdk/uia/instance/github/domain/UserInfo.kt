package cn.lnkdoc.sdk.uia.instance.github.domain

import com.alibaba.fastjson2.annotation.JSONField

/**
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
    @set:JSONField(name = "collaborators")
    var collaborators: Int? = null
    @set:JSONField(name = "company")
    var company: String? = null
    @set:JSONField(name = "created_at")
    var createdAt: String? = null
    @set:JSONField(name = "disk_usage")
    var diskUsage: Int? = null
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
    @set:JSONField(name = "gravatar_id")
    var gravatarId: String? = null
    @set:JSONField(name = "hireable")
    var hireable: String? = null
    @set:JSONField(name = "html_url")
    var htmlUrl: String? = null
    @set:JSONField(name = "id")
    var id: Int? = null
    @set:JSONField(name = "location")
    var location: String? = null
    @set:JSONField(name = "login")
    var login: String? = null
    @set:JSONField(name = "name")
    var name: String? = null
    @set:JSONField(name = "node_id")
    var nodeId: String? = null
    @set:JSONField(name = "organizations_url")
    var organizationsUrl: String? = null
    @set:JSONField(name = "owned_private_repos")
    var ownedPrivateRepos: Int? = null
    @set:JSONField(name = "plan")
    var plan: Plan? = null
    @set:JSONField(name = "private_gists")
    var privateGists: Int? = null
    @set:JSONField(name = "public_gists")
    var publicGists: Int? = null
    @set:JSONField(name = "public_repos")
    var publicRepos: Int? = null
    @set:JSONField(name = "received_events_url")
    var receivedEventsUrl: String? = null
    @set:JSONField(name = "repos_url")
    var reposUrl: String? = null
    @set:JSONField(name = "site_admin")
    var siteAdmin: Boolean? = null
    @set:JSONField(name = "starred_url")
    var starredUrl: String? = null
    @set:JSONField(name = "subscriptions_url")
    var subscriptionsUrl: String? = null
    @set:JSONField(name = "total_private_repos")
    var totalPrivateRepos: Int? = null
    @set:JSONField(name = "twitter_username")
    var twitterUsername: String? = null
    @set:JSONField(name = "two_factor_authentication")
    var twoFactorAuthentication: Boolean? = null
    @set:JSONField(name = "type")
    var type: String? = null
    @set:JSONField(name = "updated_at")
    var updatedAt: String? = null
    @set:JSONField(name = "url")
    var url: String? = null
    @set:JSONField(name = "message")
    var message: String? = null
        set(value) {
            field=value
            success = false
        }
    @set:JSONField(name = "documentation_url")
    var documentationUrl: String? = null
        set(value) {
            field=value
            success = false
        }
    var success: Boolean = true
}

@Suppress("unused")
class Plan {
    @set:JSONField(name = "collaborators")
    var collaborators: Int? = null
    @set:JSONField(name = "name")
    var name: String? = null
    @set:JSONField(name = "private_repos")
    var privateRepos: Int? = null
    @set:JSONField(name = "space")
    var space: Int? = null
}