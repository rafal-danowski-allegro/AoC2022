package pl.danowski.rafal.aoc2022.day15

import java.math.BigInteger

object Part2 {
    fun solve(filename: String, maxCoordinate: Int): BigInteger {
        val (sensorPoints, beaconPoints) = parseInput(filename)
        val sensors = List(sensorPoints.size) { Sensor(sensorPoints[it], beaconPoints[it]) }

        return (0..maxCoordinate).toList()
            .parallelStream()
            .map { row ->
                val possibleBeaconLocations = mutableListOf<Pair<IntRange, IntRange>>()
                for (sensor in sensors) {
                    try {
                        possibleBeaconLocations.add(sensor.possibleBeaconRangesForRow(row, maxCoordinate))
                    } catch (ignored: RowTooFarException) {
                    }
                }

                return@map findTuningFrequency(possibleBeaconLocations.map { it.first.last }, row, possibleBeaconLocations)
                    ?: findTuningFrequency(possibleBeaconLocations.map { it.second.first }, row, possibleBeaconLocations)
                    ?: BigInteger("-1")
            }.filter { it != BigInteger("-1") }
            .findFirst()
            .orElse(BigInteger("-1"))
    }

    private fun findTuningFrequency(columns: List<Int>, row: Int, possibleBeaconLocations: List<Pair<IntRange, IntRange>>): BigInteger? {
        for (x in columns) {
            if (isInAllRanges(x, possibleBeaconLocations)) {
                println("Found beacon position! [$x, $row]")
                return calculateTuningFrequency(x, row)
            }
        }
        return null
    }

    private fun calculateTuningFrequency(column: Int, row: Int) =
        BigInteger.valueOf(column.toLong()) * BigInteger.valueOf(4_000_000) + BigInteger.valueOf(row.toLong())

    private fun isInAllRanges(value: Int, ranges: List<Pair<IntRange, IntRange>>): Boolean {
        for ((leftRange, rightRange) in ranges) {
            if (value !in leftRange && value !in rightRange) {
                return false
            }
        }
        return true
    }

    private fun Sensor.possibleBeaconRangesForRow(row: Int, maxCoordinate: Int): Pair<IntRange, IntRange> {
        val rangeWithoutBeacons = calculateRangeWithoutBeaconForRow(row)
        val leftEdge = rangeWithoutBeacons.first
        val rightEdge = rangeWithoutBeacons.last

        val leftRange = if (leftEdge <= 0) {
            -1..-1
        } else {
            0 until leftEdge
        }

        val rightRange = if (rightEdge >= maxCoordinate) {
            maxCoordinate + 1..maxCoordinate + 1
        } else {
            rightEdge + 1..maxCoordinate
        }

        return leftRange to rightRange
    }
}
