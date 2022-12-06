package pl.danowski.rafal.aoc2022.day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day6Test {
    @Nested
    inner class Part1Tests {
        @Test
        fun testPart1Example1() {
            // given
            val result = Part1.solve("/day6/testData1.txt")

            // then
            assertEquals(7, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart1Example2() {
            // given
            val result = Part1.solve("/day6/testData2.txt")

            // then
            assertEquals(5, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart1Example3() {
            // given
            val result = Part1.solve("/day6/testData3.txt")

            // then
            assertEquals(6, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart1Example4() {
            // given
            val result = Part1.solve("/day6/testData4.txt")

            // then
            assertEquals(10, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart1Example5() {
            // given
            val result = Part1.solve("/day6/testData5.txt")

            // then
            assertEquals(11, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart1Live() {
            // given
            val result = Part1.solve("/day6/liveData.txt")

            // then
            println("Marker appeared after $result characters")
        }
    }

    @Nested
    inner class Part2Tests {
        @Test
        fun testPart2Example1() {
            // given
            val result = Part2.solve("/day6/testData1.txt")

            // then
            assertEquals(19, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart2Example2() {
            // given
            val result = Part2.solve("/day6/testData2.txt")

            // then
            assertEquals(23, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart2Example3() {
            // given
            val result = Part2.solve("/day6/testData3.txt")

            // then
            assertEquals(23, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart2Example4() {
            // given
            val result = Part2.solve("/day6/testData4.txt")

            // then
            assertEquals(29, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart2Example5() {
            // given
            val result = Part2.solve("/day6/testData5.txt")

            // then
            assertEquals(26, result)
            println("Marker appeared after $result characters")
        }

        @Test
        fun testPart2Live() {
            // given
            val result = Part2.solve("/day6/liveData.txt")

            // then
            println("Marker appeared after $result characters")
        }
    }
}