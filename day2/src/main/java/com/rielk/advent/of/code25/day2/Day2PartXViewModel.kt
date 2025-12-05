package com.rielk.advent.of.code25.day2

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

abstract class Day2PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 2
    override val fileName: String
        get() = "input"

    protected fun String.parseInput(): Sequence<LongRange> = split(",").asSequence().map { segment ->
        val limits = segment.split("-")
        limits[0].toLong()..limits[1].toLong()
    }

    protected fun Long.isInvalidId() : Boolean {
        if (this == 0L) return false

        val magnitude = floor( log10(abs(toDouble()))).toInt()
        if (magnitude % 2 == 0) return false
        val div = 10.0.pow((magnitude + 1) / 2).toLong()

        return this / div == this % div

    }
}