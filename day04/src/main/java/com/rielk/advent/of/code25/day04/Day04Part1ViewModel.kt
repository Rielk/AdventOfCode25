package com.rielk.advent.of.code25.day04

class Day04Part1ViewModel : Day04PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val layout = processInput(input)
        setMaxProgress(layout.size * layout.first().size)

        return layout.withIndex().sumOf { (i, row) ->
            row.withIndex().sumOf { (j, value) ->
                (if (value && layout.canAccess(i, j)) 1 else 0).also {
                    incrementProgress()
                }
            }
        }
    }
}