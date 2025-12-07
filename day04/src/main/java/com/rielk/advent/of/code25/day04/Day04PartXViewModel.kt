package com.rielk.advent.of.code25.day04

import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import java.io.StringReader
import kotlin.collections.getOrNull

internal typealias Layout = MutableList<MutableList<Boolean>>

abstract class Day04PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 4
    override val fileName: String
        get() = "input"

    protected fun processInput(input: String): Layout {
        return StringReader(input).use {
            it.readLines().map { line ->
                line.map { char -> char == '@' }.toMutableList()
            }.toMutableList()
        }
    }

    protected fun Layout.canAccess(pairIndex: PairIndex): Boolean {
        var count = 0
        forEachNeighbour(pairIndex) { (a, b) ->
            if (this.getOrNull(a)?.getOrNull(b) == true)
                count++
            if (count >= 4)
                return false
        }
        return true
    }

    protected inline fun Layout.forEachNeighbour(pairIndex: PairIndex, block: (PairIndex) -> Unit) {
        pairIndex.apply {
            ((i - 1).coerceAtLeast(0)..(i + 1).coerceAtMost(size - 1)).forEach { a ->
                ((j - 1).coerceAtLeast(0)..(j + 1).coerceAtMost(get(a).size - 1)).forEach { b ->
                    if (a != pairIndex.i || b != pairIndex.j)
                        block(PairIndex(a, b))
                }
            }
        }
    }

    protected operator fun Layout.get(pairIndex: PairIndex): Boolean? {
        return this.getOrNull(pairIndex.i)?.getOrNull(pairIndex.j)
    }

    protected operator fun Layout.set(pairIndex: PairIndex, value: Boolean): Boolean {
        return this.getOrNull(pairIndex.i)?.set(pairIndex.j, value) ?: throw IndexOutOfBoundsException()
    }

    protected fun Layout.forEveryIndex(block: (PairIndex, Boolean) -> Unit) {
        withIndex().forEach { (i, row) ->
            row.withIndex().forEach { (j, value) ->
                block(PairIndex(i, j), value)
            }
        }
    }

    protected data class PairIndex(val i: Int, val j: Int)
}