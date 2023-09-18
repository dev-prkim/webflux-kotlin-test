package com.daengalarm.core.entity.converter

import com.daengalarm.core.entity.enums.LoginType
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class LoginTypeConverter : AttributeConverter<LoginType, String> {
    override fun convertToDatabaseColumn(attribute: LoginType?): String? = attribute?.code

    override fun convertToEntityAttribute(dbData: String?): LoginType =
        LoginType.values().first { it.code == dbData }
}
