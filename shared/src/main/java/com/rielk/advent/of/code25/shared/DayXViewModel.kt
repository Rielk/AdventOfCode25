package com.rielk.advent.of.code25.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

abstract class DayXViewModel : ViewModel() {
    private val part1Result = MutableStateFlow<String?>(null)
    private val part1Progress = MutableStateFlow(0)
    private val part1ProgressMax = MutableStateFlow(100)

    private val part2Result = MutableStateFlow<String?>(null)
    private val part2Progress = MutableStateFlow(0)
    private val part2ProgressMax = MutableStateFlow(100)

    val state = combine(
        combine(part1Result, part1Progress, part1ProgressMax, ::PartState),
        combine(part2Result, part2Progress, part2ProgressMax, ::PartState)
    ) { part1, part2 ->
        UiState(part1, part2)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), UiState())

    data class UiState(
        val part1: PartState = PartState(),
        val part2: PartState = PartState()
    )

    data class PartState(
        val result: String? = null,
        val progress: Int = 0,
        val progressMax: Int = 1
    ) {
        val loading: Boolean get() = result == null
    }
}