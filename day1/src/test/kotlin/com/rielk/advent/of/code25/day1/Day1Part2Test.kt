package com.rielk.advent.of.code25.day1

import org.junit.Test

class Day1Part2Test: Day1PartXTest() {
    override val viewModel = Day1Part2ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 6)
}