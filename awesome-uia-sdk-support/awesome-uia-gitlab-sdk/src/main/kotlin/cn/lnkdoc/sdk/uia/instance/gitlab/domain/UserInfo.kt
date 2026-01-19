package cn.lnkdoc.sdk.uia.instance.gitlab.domain

import com.alibaba.fastjson2.annotation.JSONField

/**
 * @document https://developers.google.com/identity/openid-connect/openid-connect?hl=zh-cn#discovery
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class UserInfo {
    /**
     * avatar_url
     */
    @set:JSONField(name = "avatar_url")
    var avatarUrl: String? = null

    /**
     * bio
     */
    @set:JSONField(name = "bio")
    var bio: String? = null

    /**
     * bot
     */
    @set:JSONField(name = "bot")
    var bot: Boolean? = null

    /**
     * can_create_group
     */
    @set:JSONField(name = "can_create_group")
    var canCreateGroup: Boolean? = null

    /**
     * can_create_project
     */
    @set:JSONField(name = "can_create_project")
    var canCreateProject: Boolean? = null

    /**
     * color_scheme_id
     */
    @set:JSONField(name = "color_scheme_id")
    var colorSchemeId: Int? = null

    /**
     * commit_email
     */
    @set:JSONField(name = "commit_email")
    var commitEmail: String? = null

    /**
     * confirmed_at
     */
    @set:JSONField(name = "confirmed_at")
    var confirmedAt: String? = null

    /**
     * created_at
     */
    @set:JSONField(name = "created_at")
    var createdAt: String? = null

    /**
     * current_sign_in_at
     */
    @set:JSONField(name = "current_sign_in_at")
    var currentSignInAt: String? = null

    /**
     * discord
     */
    @set:JSONField(name = "discord")
    var discord: String? = null

    /**
     * email
     */
    @set:JSONField(name = "email")
    var email: String? = null

    /**
     * `
     */
    @set:JSONField(name = "`")
    var `external` = null?: Boolean

    /**
     * extra_shared_runners_minutes_limit
     */
    @set:JSONField(name = "extra_shared_runners_minutes_limit")
    var extraSharedRunnersMinutesLimit: Any? = null

    /**
     * id
     */
    @set:JSONField(name = "id")
    var id: Int? = null

    /**
     * identities
     */
    @set:JSONField(name = "identities")
    var identities: List<Identity>? = null

    /**
     * job_title
     */
    @set:JSONField(name = "job_title")
    var jobTitle: String? = null

    /**
     * last_activity_on
     */
    @set:JSONField(name = "last_activity_on")
    var lastActivityOn: String? = null

    /**
     * last_sign_in_at
     */
    @set:JSONField(name = "last_sign_in_at")
    var lastSignInAt: String? = null

    /**
     * linkedin
     */
    @set:JSONField(name = "linkedin")
    var linkedin: String? = null

    /**
     * local_time
     */
    @set:JSONField(name = "local_time")
    var localTime: String? = null

    /**
     * location
     */
    @set:JSONField(name = "location")
    var location: String? = null

    /**
     * locked
     */
    @set:JSONField(name = "locked")
    var locked: Boolean? = null

    /**
     * name
     */
    @set:JSONField(name = "name")
    var name: String? = null

    /**
     * organization
     */
    @set:JSONField(name = "organization")
    var organization: String? = null

    /**
     * private_profile
     */
    @set:JSONField(name = "private_profile")
    var privateProfile: Boolean? = null

    /**
     * projects_limit
     */
    @set:JSONField(name = "projects_limit")
    var projectsLimit: Int? = null

    /**
     * pronouns
     */
    @set:JSONField(name = "pronouns")
    var pronouns: Any? = null

    /**
     * public_email
     */
    @set:JSONField(name = "public_email")
    var publicEmail: String? = null

    /**
     * scim_identities
     */
    @set:JSONField(name = "scim_identities")
    var scimIdentities: List<Any>? = null

    /**
     * shared_runners_minutes_limit
     */
    @set:JSONField(name = "shared_runners_minutes_limit")
    var sharedRunnersMinutesLimit: Any? = null

    /**
     * skype
     */
    @set:JSONField(name = "skype")
    var skype: String? = null

    /**
     * state
     */
    @set:JSONField(name = "state")
    var state: String? = null

    /**
     * theme_id
     */
    @set:JSONField(name = "theme_id")
    var themeId: Int? = null

    /**
     * twitter
     */
    @set:JSONField(name = "twitter")
    var twitter: String? = null

    /**
     * two_factor_enabled
     */
    @set:JSONField(name = "two_factor_enabled")
    var twoFactorEnabled: Boolean? = null

    /**
     * username
     */
    @set:JSONField(name = "username")
    var username: String? = null

    /**
     * web_url
     */
    @set:JSONField(name = "web_url")
    var webUrl: String? = null

    /**
     * website_url
     */
    @set:JSONField(name = "website_url")
    var websiteUrl: String? = null

    /**
     * work_information
     */
    @set:JSONField(name = "work_information")
    var workInformation: String? = null
    /**
     * raw
     */
    var raw: String? = null

    /**
     * message
     */
    var message: String? = null
        set(value) {
            field = value
            success = false
        }
    /**
     * success
     */
    var success: Boolean = true
    /**
     * error
     */
    @set:JSONField(name = "error")
    var error: String? = null
        set(value) {
            field = value
            success = false
            message = value
        }
    /**
     * error_description
     */
    @set:JSONField(name = "error_description")
    var errorDescription: String? = null
        set(value) {
            field = value
            success = false
            if (message == null) {
                message = value
            }
        }
}

@Suppress("unused", "MemberVisibilityCanBePrivate")
class Identity {
    /**
     * extern_uid
     */
    @set:JSONField(name = "extern_uid")
    var externUid: String? = null

    /**
     * provider
     */
    @set:JSONField(name = "provider")
    var provider: String? = null

    /**
     * saml_provider_id
     */
    @set:JSONField(name = "saml_provider_id")
    var samlProviderId: Any? = null
}