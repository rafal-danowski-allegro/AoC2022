package pl.danowski.rafal.aoc2022.day1

object Part1 {
    fun solve(filename: String): Int {
        val elvesCalories = fileLinesToElvesCaloriesMap(filename)

        return elvesCalories.maxBy { it.value }.value
    }
}
