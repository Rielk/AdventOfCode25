package com.rielk.advent.of.code25.day06

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.io.StringReader

abstract class Day06PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 6
    override val fileName: String
        get() = "input"

    override suspend fun processPartImpl(input: String): Any {
        val problems = parseInput(input)
        return problems.sumOf { it.solve() }
    }

    private fun parseInput(input: String): List<Problem> {
        StringReader(input).use { stringReader ->
            val lines = stringReader.readLines()
            val problems = lines.last().splitLine().map {
                when (it) {
                    "+" -> Problem.Sum()
                    "*" -> Problem.Multiply()
                    else -> throw IllegalArgumentException()
                }
            }

            setMaxProgress(problems.size)
            setProgress(-1)
            addNumbersToProblems(problems, lines.asSequence().onEach { incrementProgress() }.take(lines.size - 1))
            incrementProgress()

            return problems
        }
    }

    protected abstract fun addNumbersToProblems(
        problems: List<Problem>,
        remainingLines: Sequence<String>
    )

    protected fun String.splitLine() = trim().split(Regex("\\s+"))

    protected abstract class Problem() {
        protected abstract fun operate(a: Long, b: Long): Long

        private val numbers = mutableListOf<Long>()

        fun addNumber(number: Long) {
            numbers.add(number)
        }

        fun solve() = numbers.reduce(::operate)

        class Sum : Problem() {
            override fun operate(a: Long, b: Long): Long {
                return a + b
            }
        }

        class Multiply : Problem() {
            override fun operate(a: Long, b: Long): Long {
                return a * b
            }
        }
    }
}