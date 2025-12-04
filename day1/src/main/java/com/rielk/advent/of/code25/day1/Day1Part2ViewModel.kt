package com.rielk.advent.of.code25.day1

import java.io.StringReader

class Day1Part2ViewModel : Day1PartXViewModel() {

    override suspend fun processPartImpl(input: String): String {
        val commandStrings = StringReader(input).use {
            it.readLines()
        }
        setMaxProgress(commandStrings.size)
        val commands = commandStrings.asSequence().map { Command.parse(it) }
        var position = 50
        var count = 0
        commands.forEachIndexed { index, command ->
            val result = command.doForStart(position)
            position = result.newValue
            count += result.passesThrough100
            setProgress(index)
        }
        return count.toString()
    }
}