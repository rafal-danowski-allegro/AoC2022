package pl.danowski.rafal.aoc2022.day15

import kotlin.math.abs
import pl.danowski.rafal.aoc2022.readFromFile

typealias Point = Pair<Int, Int>

fun Point.x() = this.first
fun Point.y() = this.second

fun parseInput(filename: String): Pair<List<Point>, List<Point>> {
    val lines = readFromFile(filename)
    val sensors = mutableListOf<Point>()
    val beacons = mutableListOf<Point>()

    for (line in lines) {
        val (sensorString, beaconString) = line.split(": ")

        val (sensorXString, sensorYString) = sensorString.split(", ")
        val sensorX = sensorXString.replace("Sensor at x=", "").toInt()
        val sensorY = sensorYString.replace("y=", "").toInt()
        sensors.add(sensorX to sensorY)

        val (beaconXString, beaconYString) = beaconString.split(", ")
        val beaconX = beaconXString.replace("closest beacon is at x=", "").toInt()
        val beaconY = beaconYString.replace("y=", "").toInt()
        beacons.add(beaconX to beaconY)
    }

    return sensors to beacons
}

fun Point.taxicabDistance(other: Point) =
    abs(x() - other.x()) + abs(y() - other.y())

class Sensor(
    private val point: Point,
    closestBeaconPoint: Point
) {
    private val distanceToBeacon = point.taxicabDistance(closestBeaconPoint)

    fun calculateRangeWithoutBeaconForRow(row: Int): IntRange {
        val sensorRow = point.y()
        val rowDifference = abs(row - sensorRow)
        if (rowDifference > distanceToBeacon) {
            throw RowTooFarException()
        }

        val sensorColumn = point.x()
        val leftEdge = sensorColumn - distanceToBeacon + rowDifference
        val rightEdge = sensorColumn + distanceToBeacon - rowDifference
        return leftEdge..rightEdge
    }
}

class RowTooFarException : RuntimeException()
