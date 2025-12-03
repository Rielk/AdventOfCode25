package com.rielk.advent.of.code25

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.rielk.advent.of.code25.composables.DayLauncher

fun main(vararg args: String) = application {
    val windowStateManager = remember { WindowStateManager() }
    LaunchedEffect(args, windowStateManager) {
        args.forEach {
            val dayArg = try {
                Day.valueOf(it)
            } catch (_: IllegalArgumentException) {
                null
            }
            if (dayArg != null)
                windowStateManager.openNewWindow(dayArg)
        }
    }
    MaterialTheme {
        Window(
            state = rememberWindowState(
                size = DpSize(600.dp, 300.dp),
                position = WindowPosition.Aligned(alignment = Alignment.Center)
            ),
            onCloseRequest = ::exitApplication,
            title = "AdventOfCode25",
            resizable = false
        ) {
            DayLauncher(windowStateManager::openNewWindow)
        }
        windowStateManager.AllWindows()
    }
}