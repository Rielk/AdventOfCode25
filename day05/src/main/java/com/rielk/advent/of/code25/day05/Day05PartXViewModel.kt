package com.rielk.advent.of.code25.day05

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.io.StringReader

abstract class Day05PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 5
    override val fileName: String
        get() = "input"

    protected fun parseInput(input: String): RangesAndIds {
        StringReader(input).use { stringReader ->
            val lines = stringReader.readLines()
            val splitIndex = lines.indexOfFirst { it.isEmpty() }
            val ranges = lines.take(splitIndex).map {
                val split = it.split("-")
                split[0].toLong()..split[1].toLong()
            }
            val ids = lines.drop(splitIndex + 1).map {
                it.toLong()
            }
            return RangesAndIds(ranges, ids)
        }
    }

    protected fun List<LongRange>.anyContain(value: Long) : Boolean {
        return any { value in it }
    }

    protected data class RangesAndIds(val ranges: List<LongRange>, val ids: List<Long>)
}