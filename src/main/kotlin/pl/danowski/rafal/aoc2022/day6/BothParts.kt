package pl.danowski.rafal.aoc2022.day6

import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String) = solve(filename, 4)
}

object Part2 {
    fun solve(filename: String) = solve(filename, 14)
}

fun solve(filename: String, windowSize: Int): Int =
    readFromFile(filename)
        .first()
        .toList()
        .asSequence()
        .windowed(size = windowSize, step = 1)
        .withIndex()
        .map { it.index to it.value.toSet() }
        .find { it.second.size == windowSize }
        ?.first
        ?.let { it + windowSize }
        ?: -1
