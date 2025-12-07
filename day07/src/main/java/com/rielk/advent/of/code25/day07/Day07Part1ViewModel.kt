package com.rielk.advent.of.code25.day07

class Day07Part1ViewModel : Day07PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val (splitterGrid, start) = parseInput(input)
        val tachyonGrid = splitterGrid.createTachyonGrid()

        setMaxProgress(tachyonGrid.size)

        tachyonGrid[start] = true
        tachyonGrid.take(tachyonGrid.size - 1).withIndex().forEach { (i, row) ->
            row.withIndex().forEach { (j, value) ->
                if (value) {
                    val location = Location(i, j)
                    val splitter = splitterGrid[location]
                    if (splitter != null) {
                        splitter.hit = true
                        listOf(
                            Location(location.i + 1, location.j + 1),
                            Location(location.i + 1, location.j - 1)
                        ).forEach {
                            tachyonGrid[it] = true
                        }
                    } else
                        tachyonGrid[Location(location.i + 1, location.j)] = true
                }
            }

            incrementProgress()
        }

        return splitterGrid.sumOf { it.count { it?.hit == true } }
    }
}