package com.rielk.advent.of.code25.day07

import com.rielk.advent.of.code25.day07.utils.Grid
import com.rielk.advent.of.code25.day07.utils.Location
import com.rielk.advent.of.code25.day07.utils.UpdateGrid
import com.rielk.advent.of.code25.day07.utils.createUpdateGrid
import com.rielk.advent.of.code25.day07.utils.get
import com.rielk.advent.of.code25.day07.utils.set
import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.io.StringReader
import kotlin.collections.map


abstract class Day07PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 7
    override val fileName: String
        get() = "input"

    private fun parseInput(input: String): Pair<Location, Grid<Splitter?>> {
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
        return start!! to grid
    }

    internal fun populateGridsFromInput(input: String): Pair<Grid<Splitter?>, UpdateGrid<Long>> {
        val (start, splitterGrid) = parseInput(input)
        val tachyonGrid = splitterGrid.createUpdateGrid(0L)

        setMaxProgress(tachyonGrid.size)

        tachyonGrid[start] = 1
        tachyonGrid.take(tachyonGrid.size - 1).withIndex().forEach { (i, row) ->
            row.withIndex().forEach { (j, value) ->
                if (value > 0) {
                    val location = Location(i, j)
                    val splitter = splitterGrid[location]
                    if (splitter != null) {
                        splitter.hit = true
                        listOf(
                            Location(location.i + 1, location.j + 1),
                            Location(location.i + 1, location.j - 1)
                        ).forEach {
                            tachyonGrid[it] += value
                        }
                    } else tachyonGrid[Location(location.i + 1, location.j)] += value
                }
            }

            incrementProgress()
        }

        return splitterGrid to tachyonGrid
    }

    internal class Splitter(var hit: Boolean = false)
}