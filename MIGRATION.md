# Awesome Uia SDK 重构与迁移指南

本项目已从单模块架构重构为**多模块（插件化）**架构。此次重构旨在实现按需引入平台依赖，减少包体积，并提高系统的可扩展性。

## 1. 模块划分清单

| 模块名                      | 说明 | 对应旧包路径 |
|:-------------------------| :--- | :--- |
| `awesome-uia-sdk-core`   | 核心能力（接口、模型、异常、通用工具） | `common`, `instance` (部分) |
| `awesome-uia-alipay-sdk` | 支付宝平台实现 | `instance.alipay` |
| `awesome-uia-bjtoon-sdk` | Bjtoon 平台实现 | `instance.bjtoon` |
| `awesome-uia-wx-sdk`     | 微信平台实现 | `instance.wx` |
| `...`                    | 其他平台模块 | `instance.<platform>` |
| `awesome-uia-all-sdk`    | 聚合模块（包含所有平台，用于向后兼容） | N/A |
| `awesome-uia-sdk-bom`    | 版本管理 BOM | N/A |

## 2. 关键变更：插件化装配机制

重构后，`Instance` 类不再静态持有所有平台的实现。我们引入了基于 `ServiceLoader` 的插件化机制。

### 核心接口设计
- `SdkInstanceProvider`: 平台实现提供者接口。
- `Instance.of(name)`: 通过名称（如 "ALIPAY"）动态获取实例工厂。
- `Instance.of(propertyClazz)`: 通过配置类类型动态获取实例工厂。

**重要提示**：如果你只引入了 `core` 模块而没有引入具体平台模块，调用 `Instance.of()` 将抛出 `IllegalArgumentException`。

## 3. 迁移步骤

### 3.1 依赖迁移

#### 方案 A：平滑升级（全家桶）
如果你希望保留原有行为，只需将依赖更改为 `awesome-uia-all-sdk`：

**Gradle (Kotlin):**
```kotlin
implementation("cn.lnkdoc.sdk:awesome-uia-all-sdk:1.0.0.RELEASE")
```

#### 方案 B：按需引入（推荐）
只引入你需要的平台，可以有效减少依赖库数量：

**Gradle (Kotlin):**
```kotlin
// 引入 BOM 确保版本一致
implementation(platform("cn.lnkdoc.sdk:awesome-uia-sdk-bom:1.0.0.RELEASE"))

// 需要的平台
implementation("cn.lnkdoc.sdk:awesome-uia-alipay-sdk")
```

### 3.2 代码迁移

大多数 API 保持了向后兼容。唯一的破坏性变更是 `Instance` 内部实现从 `Enum` 变为了普通类，但保留了 `of()` 等静态工厂方法。

**旧代码：**
```kotlin
val instance = UiaSdkInstance.getInstance(alipayProperty, Instance.ALIPAY)
```

**新代码（推荐）：**
```kotlin
// 方式 1：通过名称
val instance = UiaSdkInstance.getInstance(alipayProperty, Instance.of("ALIPAY"))

// 方式 2：自动识别（如果配置类唯一）
val instance = UiaSdkInstance.getInstance(alipayProperty) 
```

## 4. 自定义扩展
现在你可以通过实现 `SdkInstanceProvider` 接口并在 `META-INF/services` 中注册，轻松添加对新平台的支持，而无需修改 SDK 源码。
