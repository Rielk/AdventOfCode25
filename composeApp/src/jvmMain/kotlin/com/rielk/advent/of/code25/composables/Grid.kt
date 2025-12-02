package com.rielk.advent.of.code25.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> Grid(
    items: List<T>,
    columns: Int,
    modifier: Modifier = Modifier,
    content: @Composable (item: T) -> Unit
) {
    val batches = items.chunked(columns)
    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceEvenly) {
        batches.forEach { rowItems ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth().weight(1f)
            ) {
                rowItems.forEach { item ->
                    content(item)
                }
            }
        }
    }
}