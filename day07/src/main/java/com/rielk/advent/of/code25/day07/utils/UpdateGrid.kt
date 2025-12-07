package com.rielk.advent.of.code25.day07.utils

internal typealias UpdateGrid<T> = List<Array<T>>

internal operator fun <T> UpdateGrid<T>.get(location: Location): T {
    return this[location.i][location.j]
}

internal operator fun <T> UpdateGrid<T>.set(location: Location, value: T) {
    this[location.i][location.j] = value
}