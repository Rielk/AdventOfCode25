package com.rielk.advent.of.code25.day02

import org.junit.Test

class Day02Part2Test: Day02PartXTest() {
    override val viewModel = Day02Part2ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 4174379265)
}