package com.rielk.advent.of.code25.shared.exception

class NoInputException(inputRequest: String): Exception("No input: \"$inputRequest\"")