package com.rielk.advent.of.code25.day04

class Day04Part1ViewModel : Day04PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val layout = processInput(input)
        setMaxProgress(layout.size * layout.first().size)

        var count = 0
        layout.forEveryIndex { pairIndex, value ->
            if (value && layout.canAccess(pairIndex))
                count++
            incrementProgress()
        }
        return count
    }
}