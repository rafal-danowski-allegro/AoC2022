package pl.danowski.rafal.aoc2022.day12

import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val area = populateArea(lines)

        val startNode = area.flatten().find { it.isStart }!!
        return dijkstra(startNode, area)
    }
}
