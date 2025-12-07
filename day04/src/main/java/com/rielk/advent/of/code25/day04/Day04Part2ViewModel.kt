package com.rielk.advent.of.code25.day04

class Day04Part2ViewModel : Day04PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val layout = processInput(input)

        val checks = mutableSetOf<PairIndex>()
        layout.forEveryIndex { pairIndex, value ->
            if (value)
                checks.add(pairIndex)
        }
        setMaxProgress(checks.size)

        var count = 0
        while (checks.any()) {
            val copy = checks.toList()
            checks.clear()
            copy.forEach { pairIndex ->
                if (layout[pairIndex] == true && layout.canAccess(pairIndex)) {
                    count++
                    layout[pairIndex] = false
                    incrementProgress()
                    layout.forEachNeighbour(pairIndex) { neighbourIndex ->
                        if (layout[neighbourIndex] == true)
                            checks.add(neighbourIndex)
                    }
                }
            }
        }
        return count
    }
}