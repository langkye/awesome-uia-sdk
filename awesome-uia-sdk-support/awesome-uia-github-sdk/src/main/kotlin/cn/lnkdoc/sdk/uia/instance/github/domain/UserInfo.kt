package cn.lnkdoc.sdk.uia.instance.github.domain

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


/**
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
    @set:UiaJsonField(name = "collaborators")
    var collaborators: Int? = null
    @set:UiaJsonField(name = "company")
    var company: String? = null
    @set:UiaJsonField(name = "created_at")
    var createdAt: String? = null
    @set:UiaJsonField(name = "disk_usage")
    var diskUsage: Int? = null
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
    @set:UiaJsonField(name = "gravatar_id")
    var gravatarId: String? = null
    @set:UiaJsonField(name = "hireable")
    var hireable: String? = null
    @set:UiaJsonField(name = "html_url")
    var htmlUrl: String? = null
    @set:UiaJsonField(name = "id")
    var id: Int? = null
    @set:UiaJsonField(name = "location")
    var location: String? = null
    @set:UiaJsonField(name = "login")
    var login: String? = null
    @set:UiaJsonField(name = "name")
    var name: String? = null
    @set:UiaJsonField(name = "node_id")
    var nodeId: String? = null
    @set:UiaJsonField(name = "organizations_url")
    var organizationsUrl: String? = null
    @set:UiaJsonField(name = "owned_private_repos")
    var ownedPrivateRepos: Int? = null
    @set:UiaJsonField(name = "plan")
    var plan: Plan? = null
    @set:UiaJsonField(name = "private_gists")
    var privateGists: Int? = null
    @set:UiaJsonField(name = "public_gists")
    var publicGists: Int? = null
    @set:UiaJsonField(name = "public_repos")
    var publicRepos: Int? = null
    @set:UiaJsonField(name = "received_events_url")
    var receivedEventsUrl: String? = null
    @set:UiaJsonField(name = "repos_url")
    var reposUrl: String? = null
    @set:UiaJsonField(name = "site_admin")
    var siteAdmin: Boolean? = null
    @set:UiaJsonField(name = "starred_url")
    var starredUrl: String? = null
    @set:UiaJsonField(name = "subscriptions_url")
    var subscriptionsUrl: String? = null
    @set:UiaJsonField(name = "total_private_repos")
    var totalPrivateRepos: Int? = null
    @set:UiaJsonField(name = "twitter_username")
    var twitterUsername: String? = null
    @set:UiaJsonField(name = "two_factor_authentication")
    var twoFactorAuthentication: Boolean? = null
    @set:UiaJsonField(name = "type")
    var type: String? = null
    @set:UiaJsonField(name = "updated_at")
    var updatedAt: String? = null
    @set:UiaJsonField(name = "url")
    var url: String? = null
    var raw: String? = null
    @set:UiaJsonField(name = "message")
    var message: String? = null
        set(value) {
            field=value
            success = false
        }
    @set:UiaJsonField(name = "documentation_url")
    var documentationUrl: String? = null
        set(value) {
            field=value
            success = false
        }
    var success: Boolean = true
}

@Suppress("unused")
class Plan {
    @set:UiaJsonField(name = "collaborators")
    var collaborators: Int? = null
    @set:UiaJsonField(name = "name")
    var name: String? = null
    @set:UiaJsonField(name = "private_repos")
    var privateRepos: Int? = null
    @set:UiaJsonField(name = "space")
    var space: Int? = null
}
