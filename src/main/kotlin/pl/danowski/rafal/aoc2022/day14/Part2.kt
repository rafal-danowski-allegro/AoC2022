package pl.danowski.rafal.aoc2022.day14

import pl.danowski.rafal.aoc2022.day14.SandDroppingResult.BLOCKED
import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val rockLines = readRockLines(lines)

        val caveWidth = findNormalizedCaveWidth(rockLines)
        val abyssEdge = findAbyssEdge(rockLines) + 2
        val cave = MutableList(abyssEdge) { MutableList(caveWidth) { EMPTY_CHAR } }

        rockLines.map { normalizedRockLine(it, findLeftEdge(rockLines)) }
            .forEach { placeRockLine(cave, it) }

        cave[cave.lastIndex] = MutableList(caveWidth) { ROCK_CHAR }

        cave.printCave()

        val normalizedSandStartingPoint = findNormalizedSandStartingColumn(rockLines)
        var droppedSandCount = 0
        while (dropSand(cave, normalizedSandStartingPoint to 0) != BLOCKED) {
            droppedSandCount++
        }

        println("=== Final cave ===")
        cave.printCave()

        return droppedSandCount + 1 // +1 for top of the pyramid, that is not included in cave visualisation
    }
}