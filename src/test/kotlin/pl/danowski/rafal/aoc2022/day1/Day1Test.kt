package pl.danowski.rafal.aoc2022.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day1Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day1/testData1.txt")

            // then
            assertEquals(24000, result)
            println("Max calories elf is carrying: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day1/testData2.txt")

            // then
            println("Max calories elf is carrying: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day1/testData1.txt")

            // then
            assertEquals(45000, result)
            println("Max calories top 3 elves are carrying: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day1/testData2.txt")

            // then
            println("Max calories top 3 elves are carrying: $result")
        }
    }
}