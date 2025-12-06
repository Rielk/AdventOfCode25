package com.rielk.advent.of.code25.day02

import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

class Day02Part1ViewModel : Day02PartXViewModel() {

    override fun Long.isInvalidId() : Boolean {
        if (this == 0L) return false

        val magnitude = floor( log10(abs(toDouble()))).toInt() + 1
        if (magnitude % 2 != 0) return false
        val div = 10.0.pow((magnitude) / 2).toLong()

        return this / div == this % div
    }
}