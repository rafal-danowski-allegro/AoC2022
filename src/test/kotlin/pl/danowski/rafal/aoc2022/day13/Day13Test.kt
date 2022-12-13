package pl.danowski.rafal.aoc2022.day13

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day13Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day13/testData.txt")

            // then
            assertEquals(13, result)
            println("Sum of indices in right order: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day13/liveData.txt")

            // then
            println("Sum of indices in right order: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day13/testData.txt")

            // then
            assertEquals(140, result)
            println("Decoder key is: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day13/liveData.txt")

            // then
            println("Decoder key is: $result")
        }
    }
}
