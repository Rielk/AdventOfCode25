package com.rielk.advent.of.code25

import com.rielk.advent.of.code25.day1.Day1Part1ViewModel
import com.rielk.advent.of.code25.day1.Day1Part2ViewModel
import com.rielk.advent.of.code25.day2.Day2Part1ViewModel
import com.rielk.advent.of.code25.day2.Day2Part2ViewModel
import com.rielk.advent.of.code25.shared.DayXPartXViewModel
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

    fun getViewModelClasses() : Map<Part, KClass<out DayXPartXViewModel>?> = when(this) {
        Day1 -> mapOf(Part.Part1 to Day1Part1ViewModel::class, Part.Part2 to Day1Part2ViewModel::class)
        Day2 -> mapOf(Part.Part1 to Day2Part1ViewModel::class, Part.Part2 to null)
        else -> TODO()
    }
}