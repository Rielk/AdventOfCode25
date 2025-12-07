package com.rielk.advent.of.code25.day07.utils

internal typealias Grid<T> = List<List<T>>

internal inline fun <reified T> Grid<*>.createUpdateGrid(default: T): UpdateGrid<T> {
    return map { it.map { default }.toTypedArray() }
}

internal operator fun <T> Grid<T>.get(location: Location): T {
    return this[location.i][location.j]
}