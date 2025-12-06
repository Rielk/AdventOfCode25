package com.rielk.advent.of.code25.day02

import org.junit.Test

class Day02Part1Test : Day02PartXTest() {
    override val viewModel = Day02Part1ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 1227775554)

    @Test
    fun test2() = testForResult("4646446463-4646446465", 4646446464)
}