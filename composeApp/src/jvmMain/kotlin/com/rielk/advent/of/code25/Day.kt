package com.rielk.advent.of.code25

import com.rielk.advent.of.code25.day01.Day01Part1ViewModel
import com.rielk.advent.of.code25.day01.Day01Part2ViewModel
import com.rielk.advent.of.code25.day02.Day02Part1ViewModel
import com.rielk.advent.of.code25.day02.Day02Part2ViewModel
import com.rielk.advent.of.code25.day03.Day03Part1ViewModel
import com.rielk.advent.of.code25.day03.Day03Part2ViewModel
import com.rielk.advent.of.code25.day04.Day04Part1ViewModel
import com.rielk.advent.of.code25.day04.Day04Part2ViewModel
import com.rielk.advent.of.code25.day05.Day05Part1ViewModel
import com.rielk.advent.of.code25.day05.Day05Part2ViewModel
import com.rielk.advent.of.code25.day06.Day06Part1ViewModel
import com.rielk.advent.of.code25.day06.Day06Part2ViewModel
import com.rielk.advent.of.code25.day07.Day07Part1ViewModel
import com.rielk.advent.of.code25.day07.Day07Part2ViewModel
import com.rielk.advent.of.code25.day08.Day08Part1ViewModel
import com.rielk.advent.of.code25.day08.Day08Part2ViewModel
import com.rielk.advent.of.code25.day09.Day09Part1ViewModel
import com.rielk.advent.of.code25.day09.Day09Part2ViewModel
import com.rielk.advent.of.code25.day10.Day10Part1ViewModel
import com.rielk.advent.of.code25.day10.Day10Part2ViewModel
import com.rielk.advent.of.code25.day11.Day11Part1ViewModel
import com.rielk.advent.of.code25.day11.Day11Part2ViewModel
import com.rielk.advent.of.code25.day12.Day12Part1ViewModel
import com.rielk.advent.of.code25.day12.Day12Part2ViewModel
import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import kotlin.reflect.KClass

enum class Day {
    Day01,
    Day02,
    Day03,
    Day04,
    Day05,
    Day06,
    Day07,
    Day08,
    Day09,
    Day10,
    Day11,
    Day12;

    fun toDisplayString() : String {
        return StringBuilder().append(name.take(3)).append(" ").append(name.substring(3)).toString()
    }

    fun getViewModelClasses() : Map<Part, KClass<out DayXPartXViewModel>?> = when(this) {
        Day01 -> mapOf(Part.Part1 to Day01Part1ViewModel::class, Part.Part2 to Day01Part2ViewModel::class)
        Day02 -> mapOf(Part.Part1 to Day02Part1ViewModel::class, Part.Part2 to Day02Part2ViewModel::class)
        Day03 -> mapOf(Part.Part1 to Day03Part1ViewModel::class, Part.Part2 to Day03Part2ViewModel::class)
        Day04 -> mapOf(Part.Part1 to Day04Part1ViewModel::class, Part.Part2 to Day04Part2ViewModel::class)
        Day05 -> mapOf(Part.Part1 to Day05Part1ViewModel::class, Part.Part2 to Day05Part2ViewModel::class)
        Day06 -> mapOf(Part.Part1 to Day06Part1ViewModel::class, Part.Part2 to Day06Part2ViewModel::class)
        Day07 -> mapOf(Part.Part1 to Day07Part1ViewModel::class, Part.Part2 to Day07Part2ViewModel::class)
        Day08 -> mapOf(Part.Part1 to Day08Part1ViewModel::class, Part.Part2 to Day08Part2ViewModel::class)
        Day09 -> mapOf(Part.Part1 to Day09Part1ViewModel::class, Part.Part2 to Day09Part2ViewModel::class)
        Day10 -> mapOf(Part.Part1 to Day10Part1ViewModel::class, Part.Part2 to Day10Part2ViewModel::class)
        Day11 -> mapOf(Part.Part1 to Day11Part1ViewModel::class, Part.Part2 to Day11Part2ViewModel::class)
        Day12 -> mapOf(Part.Part1 to Day12Part1ViewModel::class, Part.Part2 to Day12Part2ViewModel::class)
    }
}