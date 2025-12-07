package com.rielk.advent.of.code25.day04

import org.junit.Test

class Day04Part2Test: Day04PartXTest() {
    override val viewModel = Day04Part2ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT ,43)
}