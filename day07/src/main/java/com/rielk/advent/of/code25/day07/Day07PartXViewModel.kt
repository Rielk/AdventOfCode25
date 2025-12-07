package com.rielk.advent.of.code25.day07

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.io.StringReader
import kotlin.collections.map

internal typealias Grid<T> = List<List<T>>
internal typealias UpdateGrid<T> = List<Array<T>>

abstract class Day07PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 7
    override val fileName: String
        get() = "input"

    protected fun parseInput(input: String): SplitterGridAndStart {
        var start: Location? = null
        val grid = StringReader(input).use { stringReader ->
            stringReader.readLines().withIndex().map { (i, line) ->
                line.withIndex().map { (j, char) ->
                    if (char == '^')
                        Splitter()
                    else {
                        if (char == 'S')
                            start = Location(i, j)
                        null
                    }
                }
            }
        }
        return SplitterGridAndStart(grid, start!!)
    }

    protected fun Grid<Splitter?>.createTachyonGrid(): UpdateGrid<Boolean> {
        return map { it.map { false }.toTypedArray() }
    }

    protected operator fun <T> Grid<T>.get(location: Location): T {
        return this[location.i][location.j]
    }

    protected operator fun <T> UpdateGrid<T>.set(location: Location, value: T) {
        this[location.i][location.j] = value
    }

    protected class Splitter(var hit: Boolean = false)
    protected data class Location(val i: Int, val j: Int)
    protected data class SplitterGridAndStart(val splitterGrid: Grid<Splitter?>, val start: Location)
}