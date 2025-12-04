package com.rielk.advent.of.code25.day1

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.io.StringReader

class Day1Part1ViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 1
    override val fileName: String
        get() = "input"

    override suspend fun processPartImpl(input: String): String {
        val commandStrings = StringReader(input).use {
            it.readLines()
        }
        setMaxProgress(commandStrings.size)
        val commands = commandStrings.asSequence().map { Command.parse(it) }
        var position = 50
        var count = 0
        commands.forEachIndexed { index, command ->
            position = command.doForStart(position)
            if (position == 0)
                count ++
            setProgress(index)
        }
        return count.toString()
    }

    @ConsistentCopyVisibility
    private data class Command private constructor(val direction: Direction, val amount: Int) {
        fun doForStart(start: Int) : Int {
            return when (direction) {
                Direction.Left -> start - amount
                Direction.Right -> start + amount
            } % 100
        }

        companion object {
            fun parse(string: String): Command {
                val direction = when (string[0]) {
                    'L' -> Direction.Left
                    'R' -> Direction.Right
                    else -> throw IllegalArgumentException("Invalid direction: ${string[0]}")
                }
                val amount = string.substring(1).toInt()
                return Command(direction, amount)
            }

            private enum class Direction {
                Left, Right
            }
        }
    }
}