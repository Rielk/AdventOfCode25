package com.rielk.advent.of.code25

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.window.Window
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.plusAssign

class WindowStateManager {
    private val stateMap = mutableStateMapOf<Day, DayWindowState>()

    fun openNewWindow(day: Day) {
        synchronized(stateMap) {
            val existingState = stateMap[day]
            if (existingState == null)
                stateMap += day to createWindow(day)
            else
                existingState.bringToTop()
        }
    }

    private fun createWindow(
        day: Day,
    ) = DayWindowState(day, stateMap::remove)

    @Composable
    fun AllWindows() {
        for (day in stateMap.keys) {
            key(day) {
                DayWindow(day)
            }
        }
    }

    @Composable
    fun DayWindow(
        day: Day
    ) {
        val state = stateMap[day] ?: return
        val requireOnTop by state.requireBringToTop.collectAsState()
        LaunchedEffect(requireOnTop) {
            state.clearBringToTop()
        }
        Window(
            onCloseRequest = state::close,
            title = state.day.toDisplayString(),
            alwaysOnTop = requireOnTop
        ) {
            MaterialTheme {
                DayWindowContent(day)
            }
        }
    }

    private class DayWindowState(
        val day: Day,
        private val close: (Day) -> Unit
    ) {
        private val _requireBringToTop = MutableStateFlow(false)
        val requireBringToTop = _requireBringToTop.asStateFlow()

        fun bringToTop() = _requireBringToTop.update { true }
        fun clearBringToTop() = _requireBringToTop.update { false }

        fun close() = close(day)
    }
}