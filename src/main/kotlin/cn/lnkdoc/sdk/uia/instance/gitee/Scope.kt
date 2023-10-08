package cn.lnkdoc.sdk.uia.instance.gitee

/**
 * @document https://gitee.com/oauth/applications
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate", "EnumEntryName")
enum class Scope(val scope: String) {
    /**
     * 访问用户的个人信息、最新动态等
     */
    user_info("user_info"),
    /**
     * 查看、创建、更新用户的项目
     */
    projects("projects"),
    /**
     * 查看、发布、更新用户的 Pull Request
     */
    pull_requests("pull_requests"),
    /**
     * 查看、发布、更新用户的 Issue
     */
    issues("issues"),
    /**
     * 查看、发布、管理用户在项目、代码片段中的评论
     */
    notes("issues"),
    /**
     * 查看、部署、删除用户的公钥
     */
    keys("keys"),
    /**
     * 查看、部署、更新用户的 Webhook
     */
    hook("hook"),
    /**
     * 查看、管理用户的组织以及成员
     */
    hogroupsok("groups"),
    /**
     * 查看、删除、更新用户的代码片段
     */
    gists("gists"),
    /**
     * 查看、管理用户的企业以及成员
     */
    enterprises("enterprises"),
    /**
     * 查看用户的个人邮箱信息
     */
    emails("emails"),
    ;
}