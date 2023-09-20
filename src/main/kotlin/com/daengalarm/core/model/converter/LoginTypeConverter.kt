package com.daengalarm.core.model.converter

import com.daengalarm.core.model.enums.LoginType
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class LoginTypeConverter : AttributeConverter<LoginType, String> {
    override fun convertToDatabaseColumn(attribute: LoginType?): String? = attribute?.code

    override fun convertToEntityAttribute(dbData: String?): LoginType =
        LoginType.values().first { it.code == dbData }
}
