package com.rielk.advent.of.code25

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

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
    Window(
        state = rememberWindowState(size = DpSize(600.dp, 300.dp)),
        onCloseRequest = ::exitApplication,
        title = "AdventOfCode25",
    ) {
        DayLauncher(windowStateManager::openNewWindow)
    }
    windowStateManager.AllWindows()
}