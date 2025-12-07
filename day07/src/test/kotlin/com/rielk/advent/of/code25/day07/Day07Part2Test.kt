package com.rielk.advent.of.code25.day07

import org.junit.Test

class Day07Part2Test: Day07PartXTest() {
    override val viewModel = Day07Part2ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 40)
}