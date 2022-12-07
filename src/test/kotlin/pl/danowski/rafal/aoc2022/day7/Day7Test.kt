package pl.danowski.rafal.aoc2022.day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day7Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day7/testData1.txt")

            // then
            assertEquals(95_437L, result)
            println("Total size of small directories is: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day7/testData2.txt")

            // then
            println("Total size of small directories is: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day7/testData1.txt")

            // then
            assertEquals(24933642, result)
            println("Size of smallest directory to delete is: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day7/testData2.txt")

            // then
            println("Size of smallest directory to delete is: $result")
        }
    }
}