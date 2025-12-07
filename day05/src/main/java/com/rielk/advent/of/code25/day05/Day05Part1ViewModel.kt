package com.rielk.advent.of.code25.day05

class Day05Part1ViewModel : Day05PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val (ranges, ids) = parseInput(input)
        setMaxProgress(ids.size)
        return ids.count {
            ranges.anyContain(it).also { incrementProgress() }
        }
    }
}