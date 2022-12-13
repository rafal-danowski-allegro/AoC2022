package pl.danowski.rafal.aoc2022.day13

import pl.danowski.rafal.aoc2022.day13.ComparisonResult.RIGHT
import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)

        var iterationCount = 1
        var properOrderSum = 0

        val iter = lines.iterator()
        while (iter.hasNext()) {
            val leftArray = parseStringToJson(iter.next())
            val rightArray = parseStringToJson(iter.next())

            println()
            println("Parsed left: $leftArray")
            println("Parsed right: $rightArray")

            if (compare(leftArray, rightArray) == RIGHT) {
                println("$leftArray < $rightArray")
                properOrderSum += iterationCount
            } else {
                println("$leftArray > $rightArray")
            }

            iterationCount++
            if (iter.hasNext())
                iter.next() // empty line
        }

        return properOrderSum
    }
}
