package com.rielk.advent.of.code25.day05

import org.junit.Test

class Day05Part1Test : Day05PartXTest() {
    override val viewModel = Day05Part1ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 3)
}