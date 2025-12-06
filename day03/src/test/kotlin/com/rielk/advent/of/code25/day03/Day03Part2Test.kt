package com.rielk.advent.of.code25.day03

import org.junit.Test

class Day03Part2Test: Day03PartXTest() {
    override val viewModel = Day03Part2ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 3121910778619)
}