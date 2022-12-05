package pl.danowski.rafal.aoc2022.day1

object Part2 {
    fun solve(filename: String): Int {
        val elvesCalories = fileLinesToElvesCaloriesMap(filename)

        var top3Calories = 0

        repeat(3) {
            val max = findMaxFromMap(elvesCalories)
            top3Calories += max.value
            elvesCalories.remove(max.key)
        }

        return top3Calories
    }

    private fun findMaxFromMap(map: Map<Int, Int>) =
        map.maxBy { it.value }
}
