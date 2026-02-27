package cn.lnkdoc.sdk.uia.instance.gitlab.domain

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


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
    @set:UiaJsonField(name = "avatar_url")
    var avatarUrl: String? = null

    /**
     * bio
     */
    @set:UiaJsonField(name = "bio")
    var bio: String? = null

    /**
     * bot
     */
    @set:UiaJsonField(name = "bot")
    var bot: Boolean? = null

    /**
     * can_create_group
     */
    @set:UiaJsonField(name = "can_create_group")
    var canCreateGroup: Boolean? = null

    /**
     * can_create_project
     */
    @set:UiaJsonField(name = "can_create_project")
    var canCreateProject: Boolean? = null

    /**
     * color_scheme_id
     */
    @set:UiaJsonField(name = "color_scheme_id")
    var colorSchemeId: Int? = null

    /**
     * commit_email
     */
    @set:UiaJsonField(name = "commit_email")
    var commitEmail: String? = null

    /**
     * confirmed_at
     */
    @set:UiaJsonField(name = "confirmed_at")
    var confirmedAt: String? = null

    /**
     * created_at
     */
    @set:UiaJsonField(name = "created_at")
    var createdAt: String? = null

    /**
     * current_sign_in_at
     */
    @set:UiaJsonField(name = "current_sign_in_at")
    var currentSignInAt: String? = null

    /**
     * discord
     */
    @set:UiaJsonField(name = "discord")
    var discord: String? = null

    /**
     * email
     */
    @set:UiaJsonField(name = "email")
    var email: String? = null

    /**
     * `
     */
    @set:UiaJsonField(name = "`")
    var `external`: Boolean? = null

    /**
     * extra_shared_runners_minutes_limit
     */
    @set:UiaJsonField(name = "extra_shared_runners_minutes_limit")
    var extraSharedRunnersMinutesLimit: Any? = null

    /**
     * id
     */
    @set:UiaJsonField(name = "id")
    var id: Int? = null

    /**
     * identities
     */
    @set:UiaJsonField(name = "identities")
    var identities: List<Identity>? = null

    /**
     * job_title
     */
    @set:UiaJsonField(name = "job_title")
    var jobTitle: String? = null

    /**
     * last_activity_on
     */
    @set:UiaJsonField(name = "last_activity_on")
    var lastActivityOn: String? = null

    /**
     * last_sign_in_at
     */
    @set:UiaJsonField(name = "last_sign_in_at")
    var lastSignInAt: String? = null

    /**
     * linkedin
     */
    @set:UiaJsonField(name = "linkedin")
    var linkedin: String? = null

    /**
     * local_time
     */
    @set:UiaJsonField(name = "local_time")
    var localTime: String? = null

    /**
     * location
     */
    @set:UiaJsonField(name = "location")
    var location: String? = null

    /**
     * locked
     */
    @set:UiaJsonField(name = "locked")
    var locked: Boolean? = null

    /**
     * name
     */
    @set:UiaJsonField(name = "name")
    var name: String? = null

    /**
     * organization
     */
    @set:UiaJsonField(name = "organization")
    var organization: String? = null

    /**
     * private_profile
     */
    @set:UiaJsonField(name = "private_profile")
    var privateProfile: Boolean? = null

    /**
     * projects_limit
     */
    @set:UiaJsonField(name = "projects_limit")
    var projectsLimit: Int? = null

    /**
     * pronouns
     */
    @set:UiaJsonField(name = "pronouns")
    var pronouns: Any? = null

    /**
     * public_email
     */
    @set:UiaJsonField(name = "public_email")
    var publicEmail: String? = null

    /**
     * scim_identities
     */
    @set:UiaJsonField(name = "scim_identities")
    var scimIdentities: List<Any>? = null

    /**
     * shared_runners_minutes_limit
     */
    @set:UiaJsonField(name = "shared_runners_minutes_limit")
    var sharedRunnersMinutesLimit: Any? = null

    /**
     * skype
     */
    @set:UiaJsonField(name = "skype")
    var skype: String? = null

    /**
     * state
     */
    @set:UiaJsonField(name = "state")
    var state: String? = null

    /**
     * theme_id
     */
    @set:UiaJsonField(name = "theme_id")
    var themeId: Int? = null

    /**
     * twitter
     */
    @set:UiaJsonField(name = "twitter")
    var twitter: String? = null

    /**
     * two_factor_enabled
     */
    @set:UiaJsonField(name = "two_factor_enabled")
    var twoFactorEnabled: Boolean? = null

    /**
     * username
     */
    @set:UiaJsonField(name = "username")
    var username: String? = null

    /**
     * web_url
     */
    @set:UiaJsonField(name = "web_url")
    var webUrl: String? = null

    /**
     * website_url
     */
    @set:UiaJsonField(name = "website_url")
    var websiteUrl: String? = null

    /**
     * work_information
     */
    @set:UiaJsonField(name = "work_information")
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
    @set:UiaJsonField(name = "error")
    var error: String? = null
        set(value) {
            field = value
            success = false
            message = value
        }
    /**
     * error_description
     */
    @set:UiaJsonField(name = "error_description")
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
    @set:UiaJsonField(name = "extern_uid")
    var externUid: String? = null

    /**
     * provider
     */
    @set:UiaJsonField(name = "provider")
    var provider: String? = null

    /**
     * saml_provider_id
     */
    @set:UiaJsonField(name = "saml_provider_id")
    var samlProviderId: Any? = null
}
