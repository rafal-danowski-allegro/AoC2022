package pl.danowski.rafal.aoc2022.day4

import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
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

                if (left.first >= right.first && left.second <= right.second ||
                    right.first >= left.first && right.second <= left.second
                ) 1
                else 0
            }
            .sum()
    }
}
