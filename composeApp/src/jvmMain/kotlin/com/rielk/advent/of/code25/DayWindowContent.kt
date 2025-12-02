package com.rielk.advent.of.code25

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DayWindowContent(day: Day, modifier: Modifier = Modifier) {
    val impl = remember(day) {
        try {
            day.getImplementation()
        } catch (_: NotImplementedError) {
            null
        }
    }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            day.toDisplayString(),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(8.dp)
        )
        HorizontalDivider(modifier = Modifier.padding(16.dp))
        if (impl == null) {
            Text("Not implemented")
        } else {
            SelectionContainer {
                Text("Result: ${impl.result}")
            }
            Button(onClick = {}) {
                Text("Result: ${impl.result}")
            }
        }
    }
}