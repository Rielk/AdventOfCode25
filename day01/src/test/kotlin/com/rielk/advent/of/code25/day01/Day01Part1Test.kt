package com.rielk.advent.of.code25.day01

import kotlin.test.Test

class Day01Part1Test : Day01PartXTest() {
    override val viewModel = Day01Part1ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 3)

    @Test
    fun test2() = testForResult("L50\nL30\nR30", 2)
}