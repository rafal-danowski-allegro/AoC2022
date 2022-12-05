package pl.danowski.rafal.aoc2022.day3

import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String) =
        readFromFile(filename)
            .map { Rucksack(it) }
            .map { it.findSharedItem() }
            .sumOf { calculatePriority(it) }
}

class Rucksack(
    private val items: String
) {
    fun findSharedItem(): Char {
        val (left, right) = items.splitAtIndex(items.length / 2)
        val common = left.toSet().intersect(right.toSet())
        return when (common.size) {
            1 -> common.first()
            0 -> throw RuntimeException("No common elements")
            else -> {
                println("Too many common elements")
                common.first()
            }
        }
    }
}
