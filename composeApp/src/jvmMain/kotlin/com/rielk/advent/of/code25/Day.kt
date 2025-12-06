package com.rielk.advent.of.code25

import com.rielk.advent.of.code25.day1.Day1Part1ViewModel
import com.rielk.advent.of.code25.day1.Day1Part2ViewModel
import com.rielk.advent.of.code25.day2.Day2Part1ViewModel
import com.rielk.advent.of.code25.day2.Day2Part2ViewModel
import com.rielk.advent.of.code25.day3.Day3Part1ViewModel
import com.rielk.advent.of.code25.day3.Day3Part2ViewModel
import com.rielk.advent.of.code25.day4.Day4Part1ViewModel
import com.rielk.advent.of.code25.day4.Day4Part2ViewModel
import com.rielk.advent.of.code25.day5.Day5Part1ViewModel
import com.rielk.advent.of.code25.day5.Day5Part2ViewModel
import com.rielk.advent.of.code25.day6.Day6Part1ViewModel
import com.rielk.advent.of.code25.day6.Day6Part2ViewModel
import com.rielk.advent.of.code25.day7.Day7Part1ViewModel
import com.rielk.advent.of.code25.day7.Day7Part2ViewModel
import com.rielk.advent.of.code25.day8.Day8Part1ViewModel
import com.rielk.advent.of.code25.day8.Day8Part2ViewModel
import com.rielk.advent.of.code25.day9.Day9Part1ViewModel
import com.rielk.advent.of.code25.day9.Day9Part2ViewModel
import com.rielk.advent.of.code25.day10.Day10Part1ViewModel
import com.rielk.advent.of.code25.day10.Day10Part2ViewModel
import com.rielk.advent.of.code25.day11.Day11Part1ViewModel
import com.rielk.advent.of.code25.day11.Day11Part2ViewModel
import com.rielk.advent.of.code25.day12.Day12Part1ViewModel
import com.rielk.advent.of.code25.day12.Day12Part2ViewModel
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
    Day12;

    fun toDisplayString() : String {
        return StringBuilder().append(name.take(3)).append(" ").append(name.substring(3)).toString()
    }

    fun getViewModelClasses() : Map<Part, KClass<out DayXPartXViewModel>?> = when(this) {
        Day1 -> mapOf(Part.Part1 to Day1Part1ViewModel::class, Part.Part2 to Day1Part2ViewModel::class)
        Day2 -> mapOf(Part.Part1 to Day2Part1ViewModel::class, Part.Part2 to Day2Part2ViewModel::class)
        Day3 -> mapOf(Part.Part1 to Day3Part1ViewModel::class, Part.Part2 to Day3Part2ViewModel::class)
        Day4 -> mapOf(Part.Part1 to Day4Part1ViewModel::class, Part.Part2 to Day4Part2ViewModel::class)
        Day5 -> mapOf(Part.Part1 to Day5Part1ViewModel::class, Part.Part2 to Day5Part2ViewModel::class)
        Day6 -> mapOf(Part.Part1 to Day6Part1ViewModel::class, Part.Part2 to Day6Part2ViewModel::class)
        Day7 -> mapOf(Part.Part1 to Day7Part1ViewModel::class, Part.Part2 to Day7Part2ViewModel::class)
        Day8 -> mapOf(Part.Part1 to Day8Part1ViewModel::class, Part.Part2 to Day8Part2ViewModel::class)
        Day9 -> mapOf(Part.Part1 to Day9Part1ViewModel::class, Part.Part2 to Day9Part2ViewModel::class)
        Day10 -> mapOf(Part.Part1 to Day10Part1ViewModel::class, Part.Part2 to Day10Part2ViewModel::class)
        Day11 -> mapOf(Part.Part1 to Day11Part1ViewModel::class, Part.Part2 to Day11Part2ViewModel::class)
        Day12 -> mapOf(Part.Part1 to Day12Part1ViewModel::class, Part.Part2 to Day12Part2ViewModel::class)
    }
}