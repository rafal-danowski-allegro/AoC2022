package pl.danowski.rafal.aoc2022.day10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day10Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day10/testData.txt")

            // then
            assertEquals(13140, result)
            println("Total signal strength is: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day10/liveData.txt")

            // then
            println("Total signal strength is: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            Part2.solve("/day10/testData.txt")
        }

        @Test
        fun testPart2Live() {
            Part2.solve("/day10/liveData.txt")
        }
    }
}
