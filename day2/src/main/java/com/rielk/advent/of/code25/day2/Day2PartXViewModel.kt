package com.rielk.advent.of.code25.day2

import androidx.lifecycle.viewModelScope
import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll

abstract class Day2PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 2
    override val fileName: String
        get() = "input"


    override suspend fun processPartImpl(input: String): String {
        val ranges = input.parseInput()
        setMaxProgress(ranges.map { it.last - it.first }.sum().toInt())
        val jobs = ranges.map { range ->
            viewModelScope.async(Dispatchers.Default) {
                range.fold(0L) { acc, i ->
                    (if (i.isInvalidId()) acc + i else acc).also { incrementProgress() }
                }
            }
        }.toList()
        return jobs.awaitAll().sum().toString()
    }

    protected abstract fun Long.isInvalidId() : Boolean

    protected fun String.parseInput(): Sequence<LongRange> = split(",").asSequence().map { segment ->
        val limits = segment.split("-")
        limits[0].toLong()..limits[1].toLong()
    }
}