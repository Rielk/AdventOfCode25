package com.rielk.advent.of.code25.day1

import com.rielk.advent.of.code25.shared.test.DayXPartXTestBase
import kotlin.test.Test

class Day1Part1Test : DayXPartXTestBase() {
    companion object {
        const val WEBSITE_INPUT = "L68\nL30\nR48\nL5\nR60\nL55\nL1\nL99\nR14\nL82"
    }

    override val viewModel = Day1Part1ViewModel()

    @Test
    fun part1_test1() = testForResult(WEBSITE_INPUT, 3)

    @Test
    fun part1_test2() = testForResult("L50\nL30\nR30", 2)

    @Test
    fun part1_badInput1() = testForFail<IllegalArgumentException>("X68\nL30")
}