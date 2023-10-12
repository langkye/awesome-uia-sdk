package cn.lnkdoc.sdk.uia.instance.google

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * 下面仅列出了已启用的 API 的范围。如需在该屏幕中添加缺少的范围，请在 Google API 库中查找并启用所需的 API，或使用下面的“粘贴的范围”文本框。刷新页面即可查看您从库中启用的任何新 API。
 * @document https://developers.google.com/identity/protocols/oauth2/scopes?hl=zh-cn
 * @document https://console.cloud.google.com/apis/library/browse?filter=visibility:public&authuser=1&cloudshell=false&hl=zh-cn&project=lnkdoc&supportedpurview=project
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate", "EnumEntryName")
enum class Scope(val scope: String) {
    /**
     * See your primary Google Account email address
     */
    auth___userinfo__email("https://www.googleapis.com/auth/userinfo.email"),
    /**
     * See your personal info, including any personal info you've made publicly available
     */
    auth___userinfo__profile("https://www.googleapis.com/auth/userinfo.profile"),
    /**
     * Associate you with your personal info on Google
     */
    openid("openid"),
    /**
     * View and manage your data in Google BigQuery and see the email address for your Google Account
     */
    auth___bigquery("https://www.googleapis.com/auth/bigquery"),
    /**
     * 查看、修改、配置和删除您的 Google Cloud 数据，和查看您 Google 账号的电子邮件地址。
     */
    auth___cloud_platform("https://www.googleapis.com/auth/cloud-platform"),
    /**
     * 在 Google BigQuery 中查看您的数据
     */
    auth___bigquery_readonly("https://www.googleapis.com/auth/bigquery.readonly"),
    /**
     * 查看您在各项 Google Cloud 服务中的数据以及您 Google 账号的电子邮件地址
     */
    auth___cloud_platform__read_only("https://www.googleapis.com/auth/cloud-platform.read-only"),
    /**
     * Manage your data and permissions in Cloud Storage and see the email address for your Google Account
     */
    auth___devstorage__full_control("https://www.googleapis.com/auth/devstorage.full_control"),
    /**
     * 查看您在 Google Cloud Storage 中的数据
     */
    auth___devstorage__read_only("https://www.googleapis.com/auth/devstorage.read_only"),
    /**
     * 管理您在 Cloud Storage 中的数据，和查看您 Google 账号的电子邮件地址
     */
    auth___devstorage__read_read_write("https://www.googleapis.com/auth/devstorage.read_write"),
    /**
     * 在Google BigQuery中插入数据
     */
    auth___bigquery__insertdata("https://www.googleapis.com/auth/bigquery.insertdata"),
    /**
     * 查看和管理您的 Google Cloud Datastore 数据
     */
    auth___datastore("https://www.googleapis.com/auth/datastore"),
    /**
     * 查看您项目的日志数据
     */
    auth___logging__read("https://www.googleapis.com/auth/logging.read"),
    /**
     * 管理您项目的日志数据
     */
    auth___logging__admin("https://www.googleapis.com/auth/logging.admin"),
    /**
     * 提交您项目的日志数据
     */
    auth___logging__write("https://www.googleapis.com/auth/logging.write"),
    /**
     * 查看和写入您的所有Google及第三方云与API项目对应的监测数据
     */
    auth___monitoring("https://www.googleapis.com/auth/monitoring"),
    /**
     * 查看您的所有 Google 云和第三方项目的监测数据
     */
    auth___monitoring__read("https://www.googleapis.com/auth/monitoring.read"),
    /**
     * 将指标数据发布到您的 Google 云项目
     */
    auth___monitoring__write("https://www.googleapis.com/auth/monitoring.write"),
    /**
     * 管理您在 Google Cloud Storage 中的数据
     */
    auth___devstorage__write_only("https://www.googleapis.com/auth/devstorage.write_only"),
    /**
     * 读取项目或应用的跟踪数据
     */
    auth___trace__readonly("https://www.googleapis.com/auth/trace.readonly"),
    /**
     * 写入项目或应用的跟踪数据
     */
    auth___trace__append("https://www.googleapis.com/auth/trace.append"),
    /**
     * 管理您的 Google API 服务配置
     */
    auth___service__management("https://www.googleapis.com/auth/service.management"),
    /**
     * 查看您的 Google API 服务配置
     */
    auth___service__management__readonly("https://www.googleapis.com/auth/service.management.readonly"),
    /**
     * 测试身份和访问权限管理 (IAM) 权限
     */
    auth___iam__test("https://www.googleapis.com/auth/iam.test"),
    ;

    companion object {
        @JvmStatic
        fun join(vararg scope: Scope): String {
            val joinToString = scope.joinToString(separator = ",") {
                URLEncoder.encode(it.scope, StandardCharsets.UTF_8.name())
            }
            return joinToString
        }
    }
}