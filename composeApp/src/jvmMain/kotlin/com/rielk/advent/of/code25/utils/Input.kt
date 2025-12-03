package com.rielk.advent.of.code25.utils

import adventofcode25.composeapp.generated.resources.Res
import com.rielk.advent.of.code25.Day
import com.rielk.advent.of.code25.shared.Part
import org.jetbrains.compose.resources.MissingResourceException

object Input {
    suspend fun loadForDay(day: Day, part: Part) : String? {
        try {
            val name = "files/${day.name.lowercase()}/${part.fileName}"
            val bytes = Res.readBytes(name)
            return String(bytes)
        } catch (_: MissingResourceException) {
            return null
        }
    }
}