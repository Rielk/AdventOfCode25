package com.rielk.advent.of.code25.day03

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll

class Day03Part1ViewModel : Day03PartXViewModel() {

    override suspend fun processPartImpl(input: String): Any {
        val banks = readInput(input)
        setMaxProgress(banks.size)

        return banks.map { bank ->
            viewModelScope.async(Dispatchers.Default) {
                val first = bank.withIndex().take(bank.size - 1).maxBy { it.value }
                val second = bank.drop(first.index + 1).max()
                ((10 * first.value) + second).also {
                    addToLog(buildString {
                        append(bank.joinToString(""))
                        append("=>")
                        append(it)
                    })
                    incrementProgress()
                }
            }
        }.awaitAll().sum().toString()
    }
}