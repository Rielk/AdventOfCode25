package com.rielk.advent.of.code25.day2

import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

class Day2Part2ViewModel : Day2PartXViewModel() {

    override fun Long.isInvalidId() : Boolean {
        if (this == 0L) return false

        val magnitude = floor( log10(abs(toDouble()))).toInt() + 1
        return (2..magnitude).any { i ->
            if (magnitude % i != 0) false
            else {
                val div = 10.0.pow((magnitude + 1) / i).toLong()
                val repeat = this % div
                var remaining = this
                while (remaining > div) {
                    val chopped = remaining % div
                    if (chopped != repeat) return@any false
                    remaining /= div
                }
                remaining == repeat
            }
        }
    }
}