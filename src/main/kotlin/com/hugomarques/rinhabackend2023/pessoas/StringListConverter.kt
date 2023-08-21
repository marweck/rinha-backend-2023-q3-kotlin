package com.hugomarques.rinhabackend2023.pessoas

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.lang.String.join

@Converter
class StringListConverter : AttributeConverter<List<String>, String> {
    override fun convertToDatabaseColumn(stringList: List<String>?): String? =
        if (stringList != null) join(SPLIT_CHAR, stringList) else null

    override fun convertToEntityAttribute(value: String?): List<String> =
        value?.split(SPLIT_CHAR) ?: emptyList()

    companion object {
        private const val SPLIT_CHAR = ";"
    }
}
