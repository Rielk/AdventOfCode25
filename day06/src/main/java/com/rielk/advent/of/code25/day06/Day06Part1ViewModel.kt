package com.rielk.advent.of.code25.day06

import kotlin.sequences.forEach

class Day06Part1ViewModel : Day06PartXViewModel() {
    override fun addNumbersToProblems(problems: List<Problem>, remainingLines: Sequence<String>) {
        remainingLines.forEach { line ->
            line.splitLine().withIndex().forEach { (i, numString) ->
                problems[i].addNumber(numString.toLong())
            }
        }
    }
}