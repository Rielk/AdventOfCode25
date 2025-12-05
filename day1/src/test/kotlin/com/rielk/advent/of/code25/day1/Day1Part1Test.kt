package com.rielk.advent.of.code25.day1

import kotlin.test.Test

class Day1Part1Test : Day1PartXTest() {
    override val viewModel = Day1Part1ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 3)

    @Test
    fun test2() = testForResult("L50\nL30\nR30", 2)
}