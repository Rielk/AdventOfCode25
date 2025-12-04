package com.rielk.advent.of.code25.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
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
import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import com.rielk.advent.of.code25.utils.Input
import kotlin.reflect.KClass

@Composable
fun PartDisplay(
    viewModelClass: KClass<out DayXPartXViewModel>?,
    modifier: Modifier = Modifier,
    viewModel: DayXPartXViewModel? = viewModelClass?.run { viewModel(viewModelClass) }
) {
    if (viewModel == null) {
        Text("Not implemented", modifier = modifier)
    } else {
        LaunchedEffect(viewModel) {
            val input = Input.loadForDay(viewModel.inputRequest)
            viewModel.processInput(input)
        }
        val state by viewModel.state.collectAsState()


        val logTextScrollState = rememberLazyListState()
        val logNumberScrollState = rememberLazyListState()
        LaunchedEffect(
            logTextScrollState.firstVisibleItemIndex,
            logTextScrollState.firstVisibleItemScrollOffset
        ) {
            logNumberScrollState.scrollToItem(
                logTextScrollState.firstVisibleItemIndex,
                logTextScrollState.firstVisibleItemScrollOffset
            )
        }
        LaunchedEffect(
            logNumberScrollState.firstVisibleItemIndex,
            logNumberScrollState.firstVisibleItemScrollOffset
        ) {
            logTextScrollState.scrollToItem(
                logNumberScrollState.firstVisibleItemIndex,
                logNumberScrollState.firstVisibleItemScrollOffset
            )
        }

        Column(modifier = modifier.padding(top = 16.dp).padding(vertical = 8.dp)) {
            when (val state = state) {
                is DayXPartXViewModel.PartState.Error -> {
                    Text(
                        "Error: ${state.exception.message}",
                        color = MaterialTheme.colorScheme.error
                    )
                }

                is DayXPartXViewModel.PartState.Loading -> {
                    Spacer(modifier = Modifier.height(12.dp))
                    LinearProgressIndicator(
                        progress = { state.progress.toFloat() / state.progressMax.toFloat() },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                is DayXPartXViewModel.PartState.Result -> {
                    SelectionContainer {
                        Text("Result: ${state.result}")
                    }
                }
            }

            HorizontalDivider()
            Row {
                LazyColumn(
                    horizontalAlignment = Alignment.End,
                    state = logNumberScrollState,
                    modifier = Modifier.fillMaxHeight().padding(top = 8.dp, start = 4.dp)
                        .widthIn(min = 16.dp)
                ) {
                    items(state.log.size) {
                        Text(it.toString())
                    }
                }
                VerticalDivider(modifier = Modifier.fillMaxHeight().padding(horizontal = 4.dp))
                LazyColumn(
                    state = logTextScrollState,
                    modifier = Modifier.fillMaxSize().padding(top = 8.dp, start = 4.dp)
                ) {
                    items(state.log) {
                        Text(it)
                    }
                }
            }
        }
    }
}