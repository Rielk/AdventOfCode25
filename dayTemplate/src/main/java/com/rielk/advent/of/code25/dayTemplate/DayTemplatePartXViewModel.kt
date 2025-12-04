package com.rielk.advent.of.code25.dayTemplate

import com.rielk.advent.of.code25.shared.DayXPartXViewModel

abstract class DayTemplatePartXViewModel : DayXPartXViewModel() {
    override val day: Int
        get() = 2
    override val fileName: String
        get() = "input"
}