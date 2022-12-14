package pl.danowski.rafal.aoc2022.day14

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day14Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day14/testData.txt")

            // then
            assertEquals(24, result)
            println("$result units of sand has rested until another would fall into abyss")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day14/liveData.txt")

            // then
            println("$result units of sand has rested until another would fall into abyss")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day14/testData.txt")

            // then
            assertEquals(93, result)
            println("$result units of sand has rested until any other is blocked")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day14/liveData.txt")

            // then
            println("$result units of sand has rested until any other is blocked")
        }
    }
}
