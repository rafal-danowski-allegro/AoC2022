package pl.danowski.rafal.aoc2022.day9

class Position(
    // not [0, 0], to avoid negative numbers, that would make things more complex
    var horizontal: Int = 100,
    var vertical: Int = 100,
) {
    fun move(direction: Direction) {
        when (direction) {
            Direction.UP -> vertical--
            Direction.DOWN -> vertical++
            Direction.LEFT -> horizontal--
            Direction.RIGHT -> horizontal++
        }
    }

    override fun toString() = "[$horizontal, $vertical]"
}

fun processMove(move: String, rope: Rope) {
    val (first, second) = move.split(" ")
    val direction = Direction.fromStringRepresentation(first)
    val numberOfMoves = second.toInt()

    println()
    println("Moving $numberOfMoves times in $direction")

    repeat(numberOfMoves) {
        rope.moveHead(direction)
    }
}

fun solve(lines: List<String>, rope: Rope): Int {
    for (line in lines) {
        processMove(line, rope)
    }

    return rope.visitedLocationsByTailCount()
}

enum class Direction(private val representation: String) {
    UP("U"),
    DOWN("D"),
    RIGHT("R"),
    LEFT("L");

    companion object {
        fun fromStringRepresentation(rep: String) =
            values().find { it.representation == rep }!!
    }
}

interface Rope {
    fun visitedLocationsByTailCount(): Int
    fun moveHead(direction: Direction)

    fun adjustPosition(moved: Position, nextToMove: Position) {
        val headHorizontalPosition = moved.horizontal
        val headVerticalPosition = moved.vertical
        val tailHorizontalPosition = nextToMove.horizontal
        val tailVerticalPosition = nextToMove.vertical

        val isHeadTooFarToRight = headHorizontalPosition - tailHorizontalPosition > 1
        val isHeadTooFarToLeft = headHorizontalPosition - tailHorizontalPosition < -1
        val isHeadTooFarHorizontal = isHeadTooFarToRight || isHeadTooFarToLeft
        val isHeadTooFarToDown = headVerticalPosition - tailVerticalPosition > 1
        val isHeadTooFarToUp = headVerticalPosition - tailVerticalPosition < -1
        val isHeadTooFarVertical = isHeadTooFarToDown || isHeadTooFarToUp

        when {
            isHeadTooFarHorizontal -> {
                if (headVerticalPosition > tailVerticalPosition) {
                    nextToMove.move(Direction.DOWN)
                } else if (headVerticalPosition < tailVerticalPosition) {
                    nextToMove.move(Direction.UP)
                }

                nextToMove.move(if (isHeadTooFarToRight) Direction.RIGHT else Direction.LEFT)
            }
            isHeadTooFarVertical -> {
                if (headHorizontalPosition > tailHorizontalPosition) {
                    nextToMove.move(Direction.RIGHT)
                } else if (headHorizontalPosition < tailHorizontalPosition) {
                    nextToMove.move(Direction.LEFT)
                }

                nextToMove.move(if (isHeadTooFarToDown) Direction.DOWN else Direction.UP)
            }
        }
    }
}
