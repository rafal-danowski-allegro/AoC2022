package pl.danowski.rafal.aoc2022.day8

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day8Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day8/testData1.txt")

            // then
            assertEquals(21, result)
            println("Total visible trees: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day8/testData2.txt")

            // then
            println("Total visible trees: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day8/testData1.txt")

            // then
            assertEquals(8, result)
            println("Max scenic score: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day8/testData2.txt")

            // then
            println("Max scenic score: $result")
        }
    }
}
