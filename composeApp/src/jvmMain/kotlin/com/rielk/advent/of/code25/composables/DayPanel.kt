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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rielk.advent.of.code25.Day
import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import com.rielk.advent.of.code25.Part
import kotlin.reflect.KClass

@Composable
fun DayPanel(
    day: Day,
    modifier: Modifier = Modifier,
    viewModelClasses: Map<Part, KClass<out DayXPartXViewModel>?> = day.getViewModelClasses()
) {
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
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            PartDisplay(viewModelClasses[Part.Part1], Modifier.weight(1f))
            VerticalDivider()
            PartDisplay(viewModelClasses[Part.Part2], Modifier.weight(1f))
        }
    }
}