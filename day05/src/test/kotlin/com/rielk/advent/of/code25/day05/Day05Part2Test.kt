package com.rielk.advent.of.code25.day05

import org.junit.Test

class Day05Part2Test: Day05PartXTest() {
    override val viewModel = Day05Part2ViewModel()

    @Test
    fun test1() = testForResult(WEBSITE_INPUT, 14)

    @Test
    fun test2() = testForResult("200-300\n100-101\n1-1\n2-2\n3-3\n1-3\n1-3\n2-2\n50-70\n10-10\n98-99\n99-99\n99-99\n99-100\n1-1\n2-1\n100-100\n100-100\n100-101\n200-300\n201-300\n202-300\n250-251\n98-99\n100-100\n100-101\n1-101\n\n", 202)
}