package com.rielk.advent.of.code25.day06

class Day06Part1ViewModel : Day06PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val problems = parseInput(input)
        return problems.sumOf { it.solve() }
    }
}