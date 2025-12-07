package com.rielk.advent.of.code25.day06

class Day06Part2ViewModel : Day06PartXViewModel() {
    override fun addNumbersToProblems(problems: List<Problem>, remainingLines: Sequence<String>) {
        val columns = remainingLines.first().map { mutableListOf(it.digitToIntOrNull()) }
        remainingLines.drop(1).forEach { line ->
            line.withIndex().forEach { (i, char) -> columns[i].add(char.digitToIntOrNull()) }
        }
        var i = 0
        columns.forEach { column ->
            if (column.all { it == null }) i++
            else problems[i].addNumber(column.filterNotNull().joinToString("").toLong())
        }
    }
}