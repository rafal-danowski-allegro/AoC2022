package pl.danowski.rafal.aoc2022.day9

import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String) = solve(readFromFile(filename), ShortRope())
}

class ShortRope : Rope {
    private var currentHeadPosition: Position = Position()
    private var currentTailPosition: Position = Position()
    private val visitedLocations: MutableSet<String> = mutableSetOf(Position().toString())

    override fun visitedLocationsByTailCount() = visitedLocations.size

    override fun moveHead(direction: Direction) {
        currentHeadPosition.move(direction)
        adjustPosition(currentHeadPosition, currentTailPosition)
        visitedLocations.add(currentTailPosition.toString())

        println("Head: $currentHeadPosition, Tail: $currentTailPosition")
    }
}
