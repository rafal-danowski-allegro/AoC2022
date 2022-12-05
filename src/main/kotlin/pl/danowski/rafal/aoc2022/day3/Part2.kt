package pl.danowski.rafal.aoc2022.day3

import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val elfGroups = mutableListOf<ElfGroup>()
        for (i in lines.indices step 3) {
            elfGroups.add(ElfGroup(listOf(
                lines[i],
                lines[i + 1],
                lines[i + 2],
            )))
        }

        return elfGroups
            .map { it.findSharedItem() }
            .sumOf { calculatePriority(it) }
    }
}

class ElfGroup(
    private val rucksacks: List<String>
) {
    fun findSharedItem(): Char {
        if (rucksacks.size != 3) throw RuntimeException("Invalid rucksacks size: ${rucksacks.size}")

        val (first, second, third) = rucksacks.map { it.toSet() }
        val common = first.intersect(second).intersect(third)
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