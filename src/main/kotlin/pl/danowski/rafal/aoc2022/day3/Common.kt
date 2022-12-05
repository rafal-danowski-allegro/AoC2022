package pl.danowski.rafal.aoc2022.day3

fun calculatePriority(item: Char) =
    when (item) {
        in 'a'..'z' -> item - 'a' + 1
        in 'A'..'Z' -> item - 'A' + 27
        else -> 0
    }

fun String.splitAtIndex(index: Int) = take(index) to substring(index)
