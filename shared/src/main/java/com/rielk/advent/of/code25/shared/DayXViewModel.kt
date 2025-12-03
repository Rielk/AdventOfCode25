package com.rielk.advent.of.code25.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

abstract class DayXViewModel : ViewModel() {
    private val part1Result = MutableStateFlow<String?>(null)
    private val part1Progress = MutableStateFlow(0)
    private val part1ProgressMax = MutableStateFlow(100)
    private val part1Exception = MutableStateFlow<Exception?>(null)
    private val part1Log = MutableStateFlow<List<String>>(emptyList())

    private val part2Result = MutableStateFlow<String?>(null)
    private val part2Progress = MutableStateFlow(0)
    private val part2ProgressMax = MutableStateFlow(100)
    private val part2Exception = MutableStateFlow<Exception?>(null)
    private val part2Log = MutableStateFlow<List<String>>(emptyList())

    val state = combine(
        combine(
            part1Result,
            part1Progress,
            part1ProgressMax,
            part1Exception,
            part1Log,
            ::toPartState
        ),
        combine(
            part2Result,
            part2Progress,
            part2ProgressMax,
            part2Exception,
            part2Log,
            ::toPartState
        )
    ) { part1, part2 ->
        UiState(part1, part2)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), UiState())

    private fun toPartState(
        result: String?,
        progress: Int,
        progressMax: Int,
        exception: Exception?,
        log: List<String>
    ): PartState {
        return if (exception != null) PartState.Error(exception, log)
        else if (result == null) PartState.Loading(progress, progressMax, log)
        else PartState.Result(result, log)
    }

    suspend fun processPart1(input: String?) = withContext(Dispatchers.Default) {
        if (input == null) return@withContext part1Exception.update { Exception("No input") }

        val result = processPart(
            input = input,
            setProgress = { value -> part1Progress.update { value } },
            setMaxProgress = { value -> part1ProgressMax.update { value } },
            setException = { value -> part1Exception.update { value } },
            addToLog = {value -> part1Log.update { it + value } }
        )
        part1Result.update { result }
    }

    suspend fun processPart2(input: String?) = withContext(Dispatchers.Default) {
        if (input == null) return@withContext part2Exception.update { Exception("No input") }

        val result = processPart(
            input = input,
            setProgress = { value -> part2Progress.update { value } },
            setMaxProgress = { value -> part2ProgressMax.update { value } },
            setException = { value -> part2Exception.update { value } },
            addToLog = {value -> part2Log.update { it + value } }
        )
        part2Result.update { result }
    }

    protected abstract suspend fun processPart(
        input: String,
        setProgress: (Int) -> Unit,
        setMaxProgress: (Int) -> Unit,
        setException: (Exception) -> Unit,
        addToLog: (String) -> Unit
    ): String

    data class UiState(
        val part1: PartState = PartState.Loading(),
        val part2: PartState = PartState.Loading()
    )

    interface PartState {
        val log: List<String>

        data class Loading(
            val progress: Int = 0,
            val progressMax: Int = 1,
            override val log: List<String> = emptyList()
        ) : PartState

        data class Result(val result: String, override val log: List<String>) : PartState
        data class Error(val exception: Exception, override val log: List<String>) : PartState
    }
}