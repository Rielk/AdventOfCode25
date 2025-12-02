package com.rielk.advent.of.code25.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rielk.advent.of.code25.shared.DayXViewModel

@Composable
fun PartDisplay(
    partState: DayXViewModel.PartState,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp, 8.dp)) {
        SelectionContainer {
            Text("Result: ${partState.result}")
        }
    }
}