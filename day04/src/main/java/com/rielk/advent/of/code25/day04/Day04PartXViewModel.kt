package com.rielk.advent.of.code25.day04

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.io.StringReader

typealias Layout = List<List<Boolean>>

abstract class Day04PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 4
    override val fileName: String
        get() = "input"

    protected fun processInput(input: String): Layout {
        return StringReader(input).use {
            it.readLines().map { line ->
                line.map { char -> char == '@' }
            }
        }
    }

    protected fun Layout.canAccess(i: Int, j: Int): Boolean {
        var count = 0
        (i - 1..i + 1).forEach { a ->
            (j - 1..j + 1).forEach { b ->
                if (a == i && b == j) return@forEach

                if (this.getOrNull(a)?.getOrNull(b) == true)
                    count++
                if (count >= 4)
                    return false
            }
        }
        return true
    }
}