package com.rielk.advent.of.code25.day1

import com.rielk.advent.of.code25.shared.test.DayXPartXTest
import org.junit.Test

abstract class Day1PartXTest: DayXPartXTest() {
    companion object {
        protected const val WEBSITE_INPUT: String = "L68\nL30\nR48\nL5\nR60\nL55\nL1\nL99\nR14\nL82"
    }

    @Test
    fun badInput() = testForFail<IllegalArgumentException>("X68\nL30")
}