package com.rielk.advent.of.code25.day1

import com.rielk.advent.of.code25.shared.DayXViewModel
import com.rielk.advent.of.code25.shared.Part
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class Day1Test {
    @OptIn(DelicateCoroutinesApi::class)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    val viewModel = Day1ViewModel()

    private suspend fun Day1ViewModel.assertResult(expected: String, part: Part) {
        val state = when (part) {
            Part.Part1 -> state.drop(1).first().part1
            Part.Part2 -> state.drop(1).first().part2
        }
        if (state is DayXViewModel.PartState.Error)
            throw state.exception

        Assert.assertTrue("ViewModel process has not completed.", state is DayXViewModel.PartState.Result)

        val result = (state as DayXViewModel.PartState.Result).result
        Assert.assertEquals("Expected: $expected. Got: $result", expected, result)
    }

    @Test
    fun test1() = runBlocking {
        val input = "L68\nL30\nR48\nL5\nR60\nL55\nL1\nL99\nR14\nL82"
        viewModel.processPart1(input)
        viewModel.assertResult(3.toString(), Part.Part1)

    }
}