package com.rielk.advent.of.code25

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "AdventOfCode25",
    ) {
        App()
    }
}