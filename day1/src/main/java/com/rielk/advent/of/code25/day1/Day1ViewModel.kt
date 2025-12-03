package com.rielk.advent.of.code25.day1

import com.rielk.advent.of.code25.shared.DayXViewModel
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class Day1ViewModel : DayXViewModel() {
    override suspend fun processPart(
        input: String,
        setProgress: (Int) -> Unit,
        setMaxProgress: (Int) -> Unit,
        setException: (Exception) -> Unit,
        addToLog: (String) -> Unit
    ): String {
        setMaxProgress(input.length)
        var progress = 0
        val group = mutableListOf<Char>()
        input.forEach {
            group += it
            if (group.size >= 10) {
                addToLog(group.joinToString())
                group.clear()
            }
            delay(10.milliseconds)
            setProgress(++progress)
        }
        addToLog(group.joinToString())
        return input
    }
}