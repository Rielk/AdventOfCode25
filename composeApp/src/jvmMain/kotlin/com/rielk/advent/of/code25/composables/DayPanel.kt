package com.rielk.advent.of.code25.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rielk.advent.of.code25.Day
import com.rielk.advent.of.code25.Part
import com.rielk.advent.of.code25.shared.DayXViewModel
import com.rielk.advent.of.code25.utils.Input
import kotlin.reflect.KClass

@Composable
fun DayPanel(
    day: Day,
    viewModelClass: KClass<out DayXViewModel>?,
    modifier: Modifier = Modifier,
    viewModel: DayXViewModel? = viewModelClass?.run { viewModel(viewModelClass) }
) {
    LaunchedEffect(viewModel) {
        val input1 = Input.loadForDay(day, Part.Part1)
        viewModel?.processPart1(input1)
    }
    LaunchedEffect(viewModel) {
        val input2 = Input.loadForDay(day, Part.Part2)
        viewModel?.processPart2(input2)
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
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider()
        if (viewModel == null) {
            Text("Not implemented")
        } else {
            val state by viewModel.state.collectAsState()
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                PartDisplay(state.part1, Modifier.weight(1f))
                VerticalDivider()
                PartDisplay(state.part2, Modifier.weight(1f))
            }
        }
    }
}