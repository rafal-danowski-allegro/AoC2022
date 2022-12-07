package pl.danowski.rafal.aoc2022.day7

import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String): Long {
        val lines = readFromFile(filename).drop(1) // remove "$ cd /"

        val (_, directories) = parseFilesystem(lines)

        return directories.map(Dir::calculateSize).filter { it <= MAX_DIRECTORY_SIZE }.sum()
    }

    private const val MAX_DIRECTORY_SIZE = 100_000L
}
