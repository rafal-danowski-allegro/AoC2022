package pl.danowski.rafal.aoc2022.day14

import pl.danowski.rafal.aoc2022.day14.SandDroppingResult.BLOCKED

typealias Point = Pair<Int, Int>
typealias RockLine = List<Point>
typealias RockLines = List<RockLine>
typealias Cave = List<MutableList<Char>>

const val ROCK_CHAR = '#'
const val SAND_CHAR = '0'
const val EMPTY_CHAR = '.'

private val sandStartingPoint = 500 to 0

fun readRockLines(lines: List<String>): RockLines {
    val rockLines = mutableListOf<RockLine>()
    for (line in lines) {
        val rockLine = line.split(" -> ")
            .map {
                val (first, second) = it.split(",")
                first.toInt() to second.toInt()
            }
        rockLines.add(rockLine)
    }
    return rockLines
}

fun Point.x() = this.first
fun Point.y() = this.second

fun findNormalizedSandStartingColumn(rockLines: RockLines): Int {
    val leftEdge = findLeftEdge(rockLines)
    return sandStartingPoint.x() - leftEdge
}

fun findNormalizedCaveWidth(rockLines: RockLines): Int {
    val rightEdge = findRightEdge(rockLines)
    val leftEdge = findLeftEdge(rockLines)
    return rightEdge - leftEdge
}

fun findLeftEdge(rockLines: RockLines) =
    rockLines.flatten().minOf { it.x() } - 10000

fun findRightEdge(rockLines: RockLines) =
    rockLines.flatten().maxOf { it.x() } + 10000

fun findAbyssEdge(rockLines: RockLines) =
    rockLines.flatten().maxOf { it.y() } + 1

fun normalizedRockLine(rockLine: RockLine, leftEdge: Int) =
    rockLine.map {
        val normalizedX = it.x() - leftEdge
        normalizedX to it.y()
    }

fun placeRockLine(cave: Cave, rockLine: RockLine) {
    rockLine.windowed(2)
        .map { (start, end) ->
            if (start.x() == end.x()) {
                if (start.y() < end.y()) {
                    for (i in start.y()..end.y()) {
                        cave[i][start.x()] = ROCK_CHAR
                    }
                } else {
                    for (i in start.y() downTo end.y()) {
                        cave[i][start.x()] = ROCK_CHAR
                    }
                }
            } else {
                if (start.x() < end.x()) {
                    for (i in start.x()..end.x()) {
                        cave[start.y()][i] = ROCK_CHAR
                    }
                } else {
                    for (i in start.x() downTo end.x()) {
                        cave[start.y()][i] = ROCK_CHAR
                    }
                }
            }
        }
}

fun Cave.printCave() {
    println()
    for (caveLine in this) {
        println(caveLine.joinToString(""))
    }
    println()
}

fun Cave.isPointObstacle(point: Point) =
    isPointRock(point) || isPointSand(point)

fun Cave.isPointRock(point: Point) =
    this[point.y()][point.x()] == ROCK_CHAR

fun Cave.isPointSand(point: Point) =
    this[point.y()][point.x()] == SAND_CHAR

fun Cave.willFallIntoAbyss(point: Point): Boolean {
    for (row in point.y() until this.size) {
        if (isPointObstacle(point.x() to row)) {
            return false
        }
    }
    return true
}

fun Cave.firstObstacleDownFromPoint(point: Point): Point {
    for (row in point.y() until this.size) {
        if (isPointObstacle(point.x() to row)) {
            return point.x() to row
        }
    }
    throw RuntimeException("Should not happen - no obstacle in column ${point.x()} under row ${point.y()}")
}

enum class SandDroppingResult {
    ABYSS, REST, BLOCKED
}

fun dropSand(cave: Cave, sandStartingPoint: Point): SandDroppingResult {
    if (cave.willFallIntoAbyss(sandStartingPoint)) {
        return SandDroppingResult.ABYSS
    }

    val obstacle = cave.firstObstacleDownFromPoint(sandStartingPoint)

    if (cave.isPointObstacle(obstacle.x() - 1 to obstacle.y())) {
        // cannot move to left
        if (cave.isPointObstacle(obstacle.x() + 1 to obstacle.y())) {
            // cannot move to right
            if (obstacle.y() - 1 == 0) {
                // top of cave, cannot rest
                return BLOCKED
            }

            if (cave.isPointObstacle(obstacle.x() to obstacle.y() - 1)) {
                // something is blocking on top of obstacle, cannot rest
                return BLOCKED
            }

            cave[obstacle.y() - 1][obstacle.x()] = SAND_CHAR
            return SandDroppingResult.REST
        } else {
            // it is possible to move to right
            return dropSand(cave, obstacle.x() + 1 to obstacle.y())
        }
    } else {
        // it is possible to move to left
        return dropSand(cave, obstacle.x() - 1 to obstacle.y())
    }
}
