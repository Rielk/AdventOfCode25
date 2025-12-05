package com.rielk.advent.of.code25.day2

import org.junit.Test

class Day2Part2Test: Day2PartXTest() {
    override val viewModel = Day2Part2ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 4174379265)
}