package pl.danowski.rafal.aoc2022.day8

typealias TreeArray = List<List<Int>>

fun readTableFromInput(lines: List<String>): TreeArray =
    lines
        .map { it.toList() }
        .map { it.map(Char::digitToInt) }
