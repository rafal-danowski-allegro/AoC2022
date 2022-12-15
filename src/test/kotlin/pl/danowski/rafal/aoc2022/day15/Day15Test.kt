package pl.danowski.rafal.aoc2022.day15

import java.math.BigInteger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day15Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example() {
            // given
            val result = Part1.solve(filename = "/day15/testData.txt", row = 10)

            // then
            assertEquals(26, result)
            println("In 10th row there are $result positions, where the beacon cannot be present")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day15/liveData.txt", row = 2_000_000)

            // then
            println("In 2_000_000th row there are $result positions, where the beacon cannot be present")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example() {
            // given
            val result = Part2.solve(filename = "/day15/testData.txt", maxCoordinate = 20)

            // then
            assertEquals(56_000_011, result.toInt())
            println("Tuning frequency is $result")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day15/liveData.txt", maxCoordinate = 4_000_000)

            // then
            println("Tuning frequency is $result")
        }
    }
}
