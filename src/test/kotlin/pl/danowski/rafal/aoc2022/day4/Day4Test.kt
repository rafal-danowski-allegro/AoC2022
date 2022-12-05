package pl.danowski.rafal.aoc2022.day4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day4Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day4/testData1.txt")

            // then
            assertEquals(2, result)
            println("Sum of fully overlapping cleaning duties is: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day4/testData2.txt")

            // then
            println("Sum of fully overlapping cleaning duties is: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day4/testData1.txt")

            // then
            assertEquals(4, result)
            println("Sum of overlapping cleaning duties is: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day4/testData2.txt")

            // then
            println("Sum of overlapping cleaning duties is: $result")
        }
    }
}