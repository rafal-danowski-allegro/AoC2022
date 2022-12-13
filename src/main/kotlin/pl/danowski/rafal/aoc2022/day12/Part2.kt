package pl.danowski.rafal.aoc2022.day12

import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val area = populateArea(lines)

        return area.asSequence().flatten()
            .filter { it.isStart() }
            .map { it to dijkstra(it, area) }
            .filter { it.second != -1 }
            .onEach { pair ->
                println("For starting node ${pair.first} distance to 'E' is: ${pair.second}")
            }
            .map { it.second }
            .minOf { it }
    }

    private fun Node.isStart() = this.char == 'S' || this.char == 'a'
}
