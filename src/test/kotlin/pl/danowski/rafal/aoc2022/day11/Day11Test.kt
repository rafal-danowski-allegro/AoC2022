package pl.danowski.rafal.aoc2022.day11

import java.math.BigInteger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day11Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve("/day11/testData.txt")

            // then
            assertEquals(BigInteger("10605"), result)
            println("Monkey business: $result")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day11/liveData.txt")

            // then
            println("Monkey business: $result")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve("/day11/testData.txt")

            // then
            assertEquals(BigInteger("2713310158"), result)
            println("Monkey business: $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day11/liveData.txt")

            // then
            println("Monkey business: $result")
        }
    }
}
