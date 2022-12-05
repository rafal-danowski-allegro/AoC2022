package pl.danowski.rafal.aoc2022.day4

import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String): Int {
        return readFromFile(filename)
            .map { it.split(",") }
            .map {
                it.map { element ->
                    val splitted = element.split("-")
                    splitted[0].toInt() to splitted[1].toInt()
                }
            }
            .map {
                val left = it.first()
                val right = it.last()

                if (left.second < right.first || right.second < left.first) 0
                else 1
            }
            .sum()
    }
}