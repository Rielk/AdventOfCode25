package com.rielk.advent.of.code25.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rielk.advent.of.code25.shared.exception.NoInputException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

abstract class DayXPartXViewModel : ViewModel() {
    protected abstract suspend fun processPartImpl(input: String): String

    protected abstract val day: Int
    protected abstract val fileName: String
    val inputRequest: String
        get() = "day$day/$fileName.txt"

    private val result = MutableStateFlow<String?>(null)
    private val progress = MutableStateFlow(0)
    private val progressMax = MutableStateFlow(100)
    private val exception = MutableStateFlow<Exception?>(null)
    private val log = MutableStateFlow<List<String>>(emptyList())

    val state = combine(
        result,
        progress,
        progressMax,
        exception,
        log,
        ::toPartState
    ).stateIn(viewModelScope, SharingStarted.WhileSubscribed(), PartState.default)

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

    suspend fun processInput(input: String?) = withContext(Dispatchers.Default) {
        if (input == null) return@withContext exception.update { NoInputException(inputRequest) }

        try {
            addToLog("Starting...")
            val resultValue = processPartImpl(input = input)
            addToLog("Done!")
            result.update { resultValue }
        } catch (e: Exception) {
            exception.update { e }
        }
    }

    protected fun incrementProgress() {
        this.progress.update { it + 1 }
    }

    protected fun setProgress(progress: Int) {
        this.progress.update { progress }
    }

    protected fun setMaxProgress(maxProgress: Int) {
        this.progressMax.update { maxProgress }
    }

    protected fun addToLog(value: String) {
        this.log.update { it + value }
    }

    interface PartState {
        val log: List<String>

        data class Loading(
            val progress: Int = 0,
            val progressMax: Int = 1,
            override val log: List<String> = emptyList()
        ) : PartState

        data class Result(val result: String, override val log: List<String>) : PartState
        data class Error(val exception: Exception, override val log: List<String>) : PartState

        companion object {
            val default : PartState = Loading()
        }
    }
}