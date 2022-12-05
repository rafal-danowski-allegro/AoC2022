package pl.danowski.rafal.aoc2022.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day2Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day2/testData1.txt")

            // then
            assertEquals(15, result)
            println("Total score is: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day2/testData2.txt")

            // then
            println("Total score is: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day2/testData1.txt")

            // then
            assertEquals(12, result)
            println("Total score is: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day2/testData2.txt")

            // then
            println("Total score is: $result")
        }
    }
}