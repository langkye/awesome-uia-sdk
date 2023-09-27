package cn.lnkdoc.sdk.uia.common.util.fastjson2

import com.alibaba.fastjson2.PropertyNamingStrategy
import com.alibaba.fastjson2.filter.NameFilter
import com.alibaba.fastjson2.util.BeanUtils


/**
 * 将对象的驼峰字段转换为下划线Json字符串
 */
@Suppress("unused")
class SnakeCaseNameFilter : NameFilter {
    override fun process(source: Any, name: String, value: Any): String {
        return BeanUtils.fieldName(name, PropertyNamingStrategy.SnakeCase.name)
    }
}

