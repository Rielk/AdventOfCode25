package com.rielk.advent.of.code25.day1

import com.rielk.advent.of.code25.shared.DayXViewModel
import com.rielk.advent.of.code25.shared.Part
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import kotlin.test.Test

class Day1Test {
    companion object {
        const val WEBSITE_INPUT = "L68\nL30\nR48\nL5\nR60\nL55\nL1\nL99\nR14\nL82"
    }

    val viewModel = Day1ViewModel()

    private suspend fun DayXViewModel.assertResult(expected: String, part: Part) {
        val state = when (part) {
            Part.Part1 -> state.drop(1).first().part1
            Part.Part2 -> state.drop(1).first().part2
        }
        if (state is DayXViewModel.PartState.Error)
            throw state.exception

        Assert.assertTrue(
            "ViewModel process has not completed.",
            state is DayXViewModel.PartState.Result
        )

        val result = (state as DayXViewModel.PartState.Result).result
        Assert.assertEquals(
            StringBuilder().appendLine("Expected: $expected. Got: $result").append(state.log).toString(),
            expected,
            result
        )
    }

    private suspend fun DayXViewModel.assertFail(part: Part) {
        val state = when (part) {
            Part.Part1 -> state.drop(1).first().part1
            Part.Part2 -> state.drop(1).first().part2
        }
        if (state !is DayXViewModel.PartState.Error)
            Assert.fail("Should have thrown an exception")
    }

    @Test
    fun part1_test1() = runBlocking {
        val input = WEBSITE_INPUT
        viewModel.processPart1(input)
        viewModel.assertResult(3.toString(), Part.Part1)
    }

    @Test
    fun part1_test2() = runBlocking {
        val input = "L50\nL30\nR30"
        viewModel.processPart1(input)
        viewModel.assertResult(2.toString(), Part.Part1)
    }

    @Test
    fun part1_badInput1() = runBlocking {
        val input = "X68\nL30"
        viewModel.processPart1(input)
        viewModel.assertFail(Part.Part1)
    }

    @Test
    fun part2_test1() = runBlocking {
        val input = WEBSITE_INPUT
        viewModel.processPart2(input)
        viewModel.assertResult(6.toString(), Part.Part2)
    }
}