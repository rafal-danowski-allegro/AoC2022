package pl.danowski.rafal.aoc2022.day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day5Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solveTest("/day5/testData1.txt")

            // then
            assertEquals("CMZ", result)
            println("Last elements in stacks: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solveLive("/day5/testData2.txt")

            // then
            println("Last elements in stacks: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solveTest("/day5/testData1.txt")

            // then
            assertEquals("MCD", result)
            println("Last elements in stacks: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solveLive("/day5/testData2.txt")

            // then
            println("Last elements in stacks: $result")
        }
    }
}