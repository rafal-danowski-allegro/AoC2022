package pl.danowski.rafal.aoc2022.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day3Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day3/testData1.txt")

            // then
            assertEquals(157, result)
            println("Total priority is: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day3/testData2.txt")

            // then
            println("Total priority is: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day3/testData1.txt")

            // then
            assertEquals(70, result)
            println("Total score is: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day3/testData2.txt")

            // then
            println("Total score is: $result")
        }
    }
}