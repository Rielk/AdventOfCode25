package com.rielk.advent.of.code25

import com.rielk.advent.of.code25.day1.Day1ViewModel
import com.rielk.advent.of.code25.shared.DayXViewModel
import kotlin.reflect.KClass

enum class Day {
    Day1,
    Day2,
    Day3,
    Day4,
    Day5,
    Day6,
    Day7,
    Day8,
    Day9,
    Day10,
    Day11,
    Day12,
    Day13,
    Day14,
    Day15,
    Day16,
    Day17,
    Day18,
    Day19,
    Day20,
    Day21,
    Day22,
    Day23,
    Day24,
    Day25;

    fun toDisplayString() : String {
        return StringBuilder().append(name.take(3)).append(" ").append(name.substring(3)).toString()
    }

    fun getViewModelClass() : KClass<out DayXViewModel> = when(this) {
        Day1 -> Day1ViewModel::class
        else -> TODO()
    }
}