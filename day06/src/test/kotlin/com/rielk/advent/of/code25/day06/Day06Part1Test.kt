package com.rielk.advent.of.code25.day06

import org.junit.Test

class Day06Part1Test : Day06PartXTest() {
    override val viewModel = Day06Part1ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 4277556)
}