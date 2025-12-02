package com.rielk.advent.of.code25

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rielk.advent.of.code25.composables.Grid
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun DayLauncher(openWindow: (Day) -> Unit) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Grid(
            items = Day.entries,
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            columns = 5
        ) { day ->
            Button(onClick = { openWindow(day) }) {
                Text(day.toDisplayString())
            }
        }
    }
}