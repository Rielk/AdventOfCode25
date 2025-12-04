package com.rielk.advent.of.code25.utils

import adventofcode25.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.MissingResourceException
import java.io.File

object Input {
    suspend fun loadForDay(inputRequest: String) : String? {
        try {
            val file = File("files", inputRequest)
            val bytes = Res.readBytes(file.path)
            return String(bytes)
        } catch (_: MissingResourceException) {
            return null
        }
    }
}