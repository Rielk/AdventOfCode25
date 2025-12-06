package com.rielk.advent.of.code25.day01

import java.io.StringReader

class Day01Part1ViewModel : Day01PartXViewModel() {

    override suspend fun processPartImpl(input: String): String {
        val commandStrings = StringReader(input).use {
            it.readLines()
        }
        setMaxProgress(commandStrings.size)
        val commands = commandStrings.asSequence().map { Command.parse(it) }
        var position = 50
        var count = 0
        commands.forEachIndexed { index, command ->
            position = command.doForStart(position).newValue
            if (position == 0)
                count ++
            setProgress(index)
        }
        return count.toString()
    }
}