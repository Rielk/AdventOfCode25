package com.rielk.advent.of.code25.day03

import androidx.lifecycle.viewModelScope
import com.rielk.advent.of.code25.shared.DayXPartXViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import java.io.StringReader
import kotlin.math.pow

abstract class Day03PartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 3
    override val fileName: String
        get() = "input"

    protected abstract val takeNumber : Int

    override suspend fun processPartImpl(input: String): Any {
        val banks = readInput(input)
        setMaxProgress(banks.size)

        return banks.map { bank ->
            viewModelScope.async(Dispatchers.Default) {
                val selected = mutableListOf<Int>()
                var lastTaken = -1
                (1..takeNumber).reversed().forEach { remaining ->
                    selected.add(
                        bank.take(bank.size - remaining + 1).drop(lastTaken + 1).withIndex().maxBy { it.value }.also {
                            lastTaken += it.index + 1
                        }.value
                    )
                }
                selected.reversed().withIndex().fold(0L){ acc, (i, value) ->
                    acc + (10.0.pow(i).toLong() * value)
                }.also {
                    addToLog(bank.joinToString(""), "=>$it".prependIndent())
                    incrementProgress()
                }
            }
        }.awaitAll().sum()
    }

    protected fun readInput(input: String) : List<List<Int>> {
        return StringReader(input).use {
            it.readLines().map { line ->
                line.map {char ->
                    char.toString().toInt()
                }
            }
        }
    }
}