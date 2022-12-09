package pl.danowski.rafal.aoc2022.day9

import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String) = solve(readFromFile(filename), LongRope())
}

class LongRope: Rope {
    private var currentHeadPosition: Position = Position()
    private var middlePartsOfRope: List<Position> = List(8) { Position() }
    private var currentTailPosition: Position = Position()
    private val visitedLocations: MutableSet<String> = mutableSetOf(Position().toString())

    override fun visitedLocationsByTailCount() = visitedLocations.size

    override fun moveHead(direction: Direction) {
        currentHeadPosition.move(direction)
        adjustPosition(currentHeadPosition, middlePartsOfRope.first())

        for (i in 0 until middlePartsOfRope.lastIndex) {
            adjustPosition(middlePartsOfRope[i], middlePartsOfRope[i + 1])
        }

        adjustPosition(middlePartsOfRope.last(), currentTailPosition)

        visitedLocations.add(currentTailPosition.toString())

        println("Head: $currentHeadPosition, Tail: $currentTailPosition")
    }
}
