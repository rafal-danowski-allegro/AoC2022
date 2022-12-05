package pl.danowski.rafal.aoc2022.day1

import pl.danowski.rafal.aoc2022.readFromFile

fun fileLinesToElvesCaloriesMap(filename: String): MutableMap<Int, Int> {
    val lines = readFromFile(filename)
    var elvesIndex = 0
    var currElfCalories = 0
    val elvesCalories = mutableMapOf<Int, Int>()

    lines.forEach { line ->
        try {
            val calories = Integer.parseInt(line)
            currElfCalories += calories
        } catch (e: NumberFormatException) {
            elvesCalories[elvesIndex] = currElfCalories
            elvesIndex++
            currElfCalories = 0
        }
    }

    if (currElfCalories > 0) {
        elvesCalories[elvesIndex] = currElfCalories
    }

    return elvesCalories
}
