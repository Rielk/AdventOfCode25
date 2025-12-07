package com.rielk.advent.of.code25.day07

class Day07Part2ViewModel : Day07PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val (_, tachyonGrid) = populateGridsFromInput(input)

        return tachyonGrid.last().sum()
    }
}