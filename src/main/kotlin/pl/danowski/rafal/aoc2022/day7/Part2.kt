package pl.danowski.rafal.aoc2022.day7

import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String): Long {
        val lines = readFromFile(filename).drop(1) // remove "$ cd /"

        val (root, directories) = parseFilesystem(lines)

        val totalUsedSpace = root.calculateSize()
        val totalFreeSpace = TOTAL_SPACE - totalUsedSpace
        val neededSpace = UPDATE_SPACE - totalFreeSpace

        return directories
            .map(Dir::calculateSize)
            .filter { it >= neededSpace }
            .minOf { it }
    }

    private const val TOTAL_SPACE = 70_000_000L
    private const val UPDATE_SPACE = 30_000_000L
}