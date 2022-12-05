package pl.danowski.rafal.aoc2022.day5

val testStacks = mapOf(
    1 to ArrayDeque(mutableListOf('Z', 'N')),
    2 to ArrayDeque(mutableListOf('M', 'C', 'D')),
    3 to ArrayDeque(mutableListOf('P')),
)

val liveStacks = mapOf(
    1 to ArrayDeque(mutableListOf('S', 'C', 'V', 'N')),
    2 to ArrayDeque(mutableListOf('Z', 'M', 'J', 'H', 'N', 'S')),
    3 to ArrayDeque(mutableListOf('M', 'C', 'T', 'G', 'J', 'N', 'D')),
    4 to ArrayDeque(mutableListOf('T', 'D', 'F', 'J', 'W', 'R', 'M')),
    5 to ArrayDeque(mutableListOf('P', 'F', 'H')),
    6 to ArrayDeque(mutableListOf('C', 'T', 'Z', 'H', 'J')),
    7 to ArrayDeque(mutableListOf('D', 'P', 'R', 'Q', 'F', 'S', 'L', 'Z')),
    8 to ArrayDeque(mutableListOf('C', 'S', 'L', 'H', 'D', 'F', 'P', 'W')),
    9 to ArrayDeque(mutableListOf('D', 'S', 'M', 'P', 'F', 'N', 'G', 'Z')),
)

data class Move(
    val times: Int,
    val from: Int,
    val to: Int,
)



fun parseMove(line: String): Move {
    val splitted = line.split(" ")
    return Move(
        times = splitted[1].toInt(),
        from = splitted[3].toInt(),
        to = splitted[5].toInt(),
    )
}
