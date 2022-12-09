package pl.danowski.rafal.aoc2022.day9

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day9Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day9/testData1.txt")

            // then
            assertEquals(13, result)
            println("Tail of the rope visited at least once $result positions")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day9/testData2.txt")

            // then
            println("Tail of the rope visited at least once $result positions")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day9/largeTestData1.txt")

            // then
            assertEquals(36, result)
            println("Tail of the rope visited at least once $result positions")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day9/testData2.txt")

            // then
            println("Tail of the rope visited at least once $result positions")
        }
    }
}
