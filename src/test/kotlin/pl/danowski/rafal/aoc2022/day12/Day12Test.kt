package pl.danowski.rafal.aoc2022.day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day12Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day12/testData.txt")

            // then
            assertEquals(31, result)
            println("Fewest steps from S to E: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day12/liveData.txt")

            // then
            println("Fewest steps from S to E: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day12/testData.txt")

            // then
            assertEquals(29, result)
            println("Fewest steps from lowest point to E: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day12/liveData.txt")

            // then
            println("Fewest steps from lowest point to E: $result")
        }
    }
}
