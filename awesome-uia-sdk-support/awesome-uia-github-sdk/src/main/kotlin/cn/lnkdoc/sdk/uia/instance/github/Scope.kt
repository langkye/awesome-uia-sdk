package cn.lnkdoc.sdk.uia.instance.github

/**
 * @document https://docs.github.com/zh/apps/oauth-apps/building-oauth-apps/scopes-for-oauth-apps
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate", "EnumEntryName")
enum class Scope(val scope: String) {
    /**
     * 授予对公共信息（包括用户个人资料信息、存储库信息和 Gist）的只读访问权限 repo
     */
    NO_SCOPE(""),
    /**
     * 授予对公共和专用存储库中的提交状态的读/写访问权限。 仅在授予其他用户或服务对专用存储库提交状态的访问权限而不授予对代码的访问权限时，才需要此范围。
     */
    REPO__STATUS("repo:status"),
    /**
     * 授予对 公共和专用存储库的部署状态的访问权限。 仅在授予其他用户或服务对部署状态的访问权限而不授予对代码的访问权限时，才需要此范围。 public_repo
     */
    REPO_DEPLOYMENT("repo_deployment"),
    /**
     * 授予：
     * 对 code scanning API 中安全事件的读取和写入权限
     * 仅在授予其他用户或服务对安全事件的访问权限而不授予对代码的访问权限时，才需要此范围。 admin:repo_hook
     */
    SECURITY_EVENTS("security_events"),
    /**
     * 授予对公共或专用存储库中挂钩的读取、写入和 ping 访问权限。
     */
    WRITE__REPO_HOOK("write:repo_hook"),
    /**
     * 授予对公共或专用存储库中挂钩的读取和 ping 访问权限。
     */
    READ__REPO_HOOK("read:repo_hook"),
    /**
     * 全面管理组织及其团队、项目和成员。
     */
    ADMIN__ORG("admin:org"),
    /**
     * 对组织成员身份、组织项目和团队成员身份的读取和写入权限。
     */
    WRITE__ORG("write:org"),
    /**
     * 对组织成员身份、组织项目和团队成员身份的只读权限。
     */
    READ__ORG("read:org"),
    /**
     * 全面管理公钥。
     */
    ADMIN__PUBLIC_KEY("admin:public_key"),
    /**
     * 创建、列出和查看公钥的详细信息。
     */
    WRITE__PUBLIC_KEY("write:public_key"),
    /**
     * 列出和查看公钥的详细信息。
     */
    READ__PUBLIC_KEY("read:public_key"),
    /**
     * 授予对组织挂钩的读取、写入、ping 和删除权限。 注意：OAuth 令牌只能对由 OAuth app 创建的组织挂钩执行这些操作。 Personal access token 只能对用户创建的组织挂钩执行这些操作。
     */
    ADMIN__ORG_HOOK("admin:org_hook"),
    /**
     * 授予对 Gist 的写入权限。
     */
    GIST("gist"),
    /**
     * 授予：
     * 对用户的通知的读取访问权限
     * 对会话的“标记为读取”访问权限
     * 对存储库的监视和取消监视访问权限，以及
     * 对会话订阅的读取、写入和删除访问权限。
     */
    NOTIFICATIONS("notifications"),
    /**
     * 仅授予对个人资料的读取/写入权限。 请注意，此范围包括 user:email 和 user:follow。
     */
    USER("user"),
    /**
     * 授予读取用户个人资料数据的权限。
     */
    READ__USER("read:user"),
    /**
     * 授予对用户电子邮件地址的读取权限。
     */
    USER__EMAIL("user:email"),
    /**
     * 授予关注或取消关注其他用户的权限。
     */
    USER__FOLLOW("user:follow"),
    /**
     * 授予对用户和组织 projects 的读/写访问权限。
     */
    PROJECT("project"),
    /**
     * 授予对用户和组织 projects 的只读访问权限。delete_repo
     */
    READ__PROJECT("read:project"),
    /**
     * 授予从 GitHub Packages 下载或安装包的权限。 有关详细信息，请参阅“安装包”。
     */
    READ__PACKAGES("read:packages"),
    /**
     * 授予从 GitHub Packages 删除包的权限。 有关详细信息，请参阅“删除和恢复包”。
     */
    DELETE__PACKAGES("delete:packages"),
    /**
     * 全面管理 GPG 密钥。
     */
    ADMIN__GPG_KEY("admin:gpg_key"),
    /**
     * 创建、列出和查看 GPG 密钥的详细信息。
     */
    WRITE__GPG_KEY("write:gpg_key"),
    /**
     * 列出和查看 GPG 密钥的详细信息。
     */
    READ__GPG_KEY("read:gpg_key"),
    /**
     * 授予创建和管理 codespace 的权限。 Codespaces 可以暴露可能有不同范围集的 GITHUB_TOKEN。 有关详细信息，请参阅“GitHub Codespaces 中的安全性”。 workflow
     */
    codespace("codespace"),
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
