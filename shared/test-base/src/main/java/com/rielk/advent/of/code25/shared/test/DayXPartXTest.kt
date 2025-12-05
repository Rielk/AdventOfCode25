package com.rielk.advent.of.code25.shared.test

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import com.rielk.advent.of.code25.shared.exception.NoInputException
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.reflect.KClass

abstract class DayXPartXTest {
    abstract val viewModel: DayXPartXViewModel

    private suspend fun DayXPartXViewModel.assertResult(expected: String) {
        val state = state.drop(1).first()
        if (state is DayXPartXViewModel.PartState.Error)
            throw state.exception

        Assert.assertTrue(
            "ViewModel process has not completed.",
            state is DayXPartXViewModel.PartState.Result
        )

        val result = (state as DayXPartXViewModel.PartState.Result).result
        Assert.assertEquals(
            StringBuilder().apply {
                appendLine("Expected: $expected. Got: $result")
                state.log.forEach {
                    appendLine(it)
                }
            }.toString(),
            expected,
            result
        )
    }

    private suspend fun DayXPartXViewModel.assertFail(exceptionType: KClass<out Exception>?) {
        val state = state.drop(1).first()
        if (state is DayXPartXViewModel.PartState.Error) {
            if (exceptionType != null)
                Assert.assertTrue(exceptionType.java.isAssignableFrom(state.exception::class.java))
        } else
            Assert.fail("Should have thrown an exception")
    }

    protected inline fun <reified T : Exception> testForFail(input: String?) = testForFail(input, T::class)

    protected fun testForFail(input: String?, exceptionType: KClass<out Exception>?) = runBlocking {
        viewModel.processInput(input)
        viewModel.assertFail(exceptionType)
    }

    protected fun testForResult(input: String?, expected: Long)= testForResult(input, expected.toString())
    protected fun testForResult(input: String?, expected: Int)= testForResult(input, expected.toString())

    protected fun testForResult(input: String?, expected: String) = runBlocking {
        viewModel.processInput(input)
        viewModel.assertResult(expected)
        viewModel.state.first().log.forEach {
            println(it)
        }
    }

    @Test
    fun noInput() = testForFail<NoInputException>(null)
}