package pl.danowski.rafal.aoc2022.day13

import kotlinx.serialization.json.JsonElement
import pl.danowski.rafal.aoc2022.day13.ComparisonResult.EQUAL
import pl.danowski.rafal.aoc2022.day13.ComparisonResult.LEFT
import pl.danowski.rafal.aoc2022.day13.ComparisonResult.RIGHT
import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)

        val dividerElement1 = parseStringToJson("[[2]]")
        val dividerElement2 = parseStringToJson("[[6]]")

        val elements = mutableListOf(
            dividerElement1,
            dividerElement2,
        )

        val iter = lines.iterator()
        while (iter.hasNext()) {
            val leftArray = parseStringToJson(iter.next())
            val rightArray = parseStringToJson(iter.next())
            elements.add(leftArray)
            elements.add(rightArray)

            if (iter.hasNext())
                iter.next() // empty line
        }

        val comparator = Comparator<JsonElement> { left, right ->
            when (compare(left, right)) {
                RIGHT -> -1
                LEFT -> 1
                EQUAL -> 0
            }
        }

        elements.sortWith(comparator)

        elements.forEach(::println)

        return (elements.indexOf(dividerElement1) + 1) * (elements.indexOf(dividerElement2) + 1)
    }
}
