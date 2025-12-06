package com.rielk.advent.of.code25.day03

import org.junit.Test

class Day03Part1Test : Day03PartXTest() {
    override val viewModel = Day03Part1ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 357)
}