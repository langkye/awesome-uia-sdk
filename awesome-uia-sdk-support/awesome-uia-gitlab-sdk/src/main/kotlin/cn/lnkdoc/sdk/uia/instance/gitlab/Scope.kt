package cn.lnkdoc.sdk.uia.instance.gitlab


/**
 * @document https://docs.gitlab.com/ee/integration/oauth_provider.html#view-all-authorized-applications
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate", "EnumEntryName")
enum class Scope(val scope: String) {
    /**
     * Grants complete read/write access to the API, including all groups and projects, the container registry, and the package registry.
     */
    api("api"),
    /**
     * Grants read-only access to the authenticated user’s profile through the /user API endpoint, which includes username, public email, and full name. Also grants access to read-only API endpoints under /users.
     */
    read_user("read_user"),
    /**
     * Grants read access to the API, including all groups and projects, the container registry, and the package registry.
     */
    read_api("read_api"),
    /**
     * Grants read-only access to repositories on private projects using Git-over-HTTP or the Repository Files API.
     */
    read_repository("read_repository"),
    /**
     * Grants read-write access to repositories on private projects using Git-over-HTTP (not using the API).
     */
    write_repository("write_repository"),
    /**
     * Grants read-only access to container registry images on private projects.
     */
    read_registry("read_registry"),
    /**
     * Grants read-only access to container registry images on private projects.
     */
    write_registry("write_registry"),
    /**
     * Grants permission to perform API actions as any user in the system, when authenticated as an administrator user.
     */
    sudo("sudo"),
    /**
     * Grants permission to authenticate with GitLab using OpenID Connect. Also gives read-only access to the user’s profile and group memberships.
     */
    openid("openid"),
    /**
     * Grants read-only access to the user’s profile data using OpenID Connect.
     */
    profile("profile"),
    /**
     * Grants read-only access to the user’s primary email address using OpenID Connect.
     */
    email("email"),
    /**
     * Grants permission to create runners.
     */
    create_runner("create_runner"),
    /**
     * Grants permission to perform Kubernetes API calls using the agent for Kubernetes.
     */
    k8s_proxy("k8s_proxy"),
    ;
    
    companion object {
        @JvmStatic
        fun join(vararg scope: Scope): String {
            val joinToString = scope.joinToString(separator = ",") {
                it.scope
            }
            return joinToString
        }
    }
}