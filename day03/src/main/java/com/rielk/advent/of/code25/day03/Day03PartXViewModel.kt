package com.rielk.advent.of.code25.day03

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.io.StringReader

abstract class Day03PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 3
    override val fileName: String
        get() = "input"

    protected fun readInput(input: String) : List<List<Int>> {
        return StringReader(input).use {
            it.readLines().map { line ->
                line.map {char ->
                    char.toString().toInt()
                }
            }
        }
    }
}