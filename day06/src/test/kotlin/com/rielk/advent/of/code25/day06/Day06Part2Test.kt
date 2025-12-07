package com.rielk.advent.of.code25.day06

import org.junit.Test

class Day06Part2Test: Day06PartXTest() {
    override val viewModel = Day06Part2ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 3263827)
}