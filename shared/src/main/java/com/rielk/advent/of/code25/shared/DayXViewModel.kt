package com.rielk.advent.of.code25.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

abstract class DayXViewModel: ViewModel() {
    private val part1Result = MutableStateFlow<String?>(null)
    private val part1Progress = MutableStateFlow(0)
    private val part1ProgressMax = MutableStateFlow(100)

    private val part2Result = MutableStateFlow<String?>(null)
    private val part2Progress = MutableStateFlow(0)
    private val part2ProgressMax = MutableStateFlow(100)

    val state = combine(
        combine(part1Result, part1Progress, part1ProgressMax, ::Triple),
        combine(part2Result, part2Progress, part2ProgressMax, ::Triple)
    ) { (result1, progress1, max1), (result2, progress2, max2) ->
        UiState(result1, progress1, max1, result2, progress2, max2)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), UiState())

    data class UiState(
        val result1: String? = null,
        val progress1: Int = 0,
        val max1: Int = 100,
        val result2: String? = null,
        val progress2: Int = 0,
        val max2: Int = 100
    )
}