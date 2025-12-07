package com.rielk.advent.of.code25.day07

class Day07Part1ViewModel : Day07PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val (splitterGrid, _) = populateGridsFromInput(input)

        return splitterGrid.sumOf { row -> row.count { splitter -> splitter?.hit == true } }
    }
}