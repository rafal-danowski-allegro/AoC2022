package pl.danowski.rafal.aoc2022.day14

import pl.danowski.rafal.aoc2022.readFromFile


object Part1 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val rockLines = readRockLines(lines)

        val caveWidth = findNormalizedCaveWidth(rockLines)
        val abyssEdge = findAbyssEdge(rockLines)
        val cave = MutableList(abyssEdge) { MutableList(caveWidth) { EMPTY_CHAR } }

        rockLines.map { normalizedRockLine(it, findLeftEdge(rockLines)) }
            .forEach { placeRockLine(cave, it) }

        cave.printCave()

        val normalizedSandStartingPoint = findNormalizedSandStartingColumn(rockLines)
        var droppedSandCount = 0
        while (dropSand(cave, normalizedSandStartingPoint to 0) != SandDroppingResult.ABYSS) {
            droppedSandCount++
        }

        println("=== Final cave ===")
        cave.printCave()

        return droppedSandCount
    }
}
