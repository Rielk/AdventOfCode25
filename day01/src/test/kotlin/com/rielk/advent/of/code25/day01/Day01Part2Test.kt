package com.rielk.advent.of.code25.day01

import org.junit.Test

class Day01Part2Test: Day01PartXTest() {
    override val viewModel = Day01Part2ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 6)
}