package com.rielk.advent.of.code25.day05

import kotlin.collections.forEach

class Day05Part2ViewModel : Day05PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val (ranges, _) = parseInput(input)

        val mergedRanges = mutableListOf<LongRange>()

        setMaxProgress(ranges.size)

        ranges.forEach { addRange ->
            val collisions = mergedRanges.filter { it.collidesWith(addRange) }
            if (collisions.isEmpty())
                mergedRanges.add(addRange)
            else {
                mergedRanges.removeAll(collisions)
                mergedRanges.add(combineRanges(addRange, collisions))
            }

            incrementProgress()
        }
        return mergedRanges.sumOf { it.last - it.first + 1 }
    }

    private fun combineRanges(master: LongRange, ranges: List<LongRange>): LongRange {
        return ranges.fold(master) { a, b -> combineRanges(a, b) }
    }

    private fun combineRanges(a: LongRange, b: LongRange): LongRange {
        val start = minOf(a.first, b.first)
        val end = maxOf(a.last, b.last)
        return start..end
    }

    private fun LongRange.collidesWith(other: LongRange): Boolean {
        return other.contains(first) || other.contains(last) || contains(other.first) || contains(other.last)
    }
}