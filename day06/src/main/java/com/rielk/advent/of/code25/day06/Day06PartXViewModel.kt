package com.rielk.advent.of.code25.day06

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.io.StringReader

abstract class Day06PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 6
    override val fileName: String
        get() = "input"

    protected fun parseInput(input: String): List<Problem> {
        StringReader(input).use { stringReader ->
            val lines = stringReader.readLines()
            val problems = lines.last().splitLine().map {
                when(it) {
                    "+" -> ProblemImpl.Sum()
                    "*" -> ProblemImpl.Multiply()
                    else -> throw IllegalArgumentException()
                }
            }
            lines.asSequence().take(lines.size -1).forEach { line ->
                line.splitLine().withIndex().forEach { (i, numString) ->
                    problems[i].addNumber(numString.toLong())
                }
            }
            return problems
        }
    }

    protected fun String.splitLine() = trim().split(Regex("\\s+"))

    protected interface Problem {
        fun solve(): Long
    }
    private abstract class ProblemImpl() : Problem {
        protected abstract fun operate(a: Long, b: Long): Long

        private val numbers = mutableListOf<Long>()

        fun addNumber(number: Long) {
            numbers.add(number)
        }

        override fun solve() = numbers.reduce(::operate)

        class Sum : ProblemImpl() {
            override fun operate(a: Long, b: Long): Long {
                return a + b
            }
        }

        class Multiply : ProblemImpl() {
            override fun operate(a: Long, b: Long): Long {
                return a * b
            }
        }
    }
}