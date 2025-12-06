package com.rielk.advent.of.code25.day01

import com.rielk.advent.of.code25.shared.DayXPartXViewModel

abstract class Day01PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 1
    override val fileName: String
        get() = "input"

    @ConsistentCopyVisibility
    protected data class Command private constructor(val direction: Direction, val amount: Int) {
        fun doForStart(start: Int) : Return {
            val multiplier = direction.multiplier
            val change = multiplier * amount
            val newValue = (start + change).mod(100)

            val passesThrough100 = (amount + (multiplier * start).mod(100)) / 100

            return Return(newValue, passesThrough100)
        }

        data class Return(
            val newValue: Int,
            val passesThrough100: Int
        )

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

            enum class Direction(val multiplier: Int) {
                Left(-1), Right(1)
            }
        }
    }
}