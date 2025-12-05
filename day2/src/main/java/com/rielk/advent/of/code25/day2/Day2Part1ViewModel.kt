package com.rielk.advent.of.code25.day2

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll

class Day2Part1ViewModel : Day2PartXViewModel() {
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
}