package com.rielk.advent.of.code25.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.rielk.advent.of.code25.Day

@Composable
fun DayWindowContent(
    day: Day,
    modifier: Modifier = Modifier
) {
    val viewModelClasses = remember(day) {
        try {
            day.getViewModelClasses()
        } catch (_: NotImplementedError) {
            null
        }
    }
    DayPanel(day, viewModelClasses, modifier)
}