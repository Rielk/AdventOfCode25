package com.rielk.advent.of.code25.day2

import org.junit.Test

class Day2Part1Test : Day2PartXTest() {
    override val viewModel = Day2Part1ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 1227775554)

    @Test
    fun test2() = testForResult("4646446463-4646446465", 4646446464)
}