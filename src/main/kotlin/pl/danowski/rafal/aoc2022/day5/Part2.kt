package pl.danowski.rafal.aoc2022.day5

import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solveTest(filename: String): String {
        val lines = readFromFile(filename).drop(5)
        return solve(lines, testStacks)
    }

    fun solveLive(filename: String): String {
        val lines = readFromFile(filename).drop(10)
        return solve(lines, liveStacks)
    }

    private fun solve(lines: List<String>, stacks: Stacks): String {
        lines.map { parseMove(it) }
            .forEach {
                makeMove(it, stacks)
            }

        return stacks.map { it.value.last() }.joinToString("")
    }

    private fun makeMove(move: Move, stacks: Stacks) {
        val elements = mutableListOf<Char>()
        repeat(move.times) {
            val element = stacks[move.from]!!.removeLast()
            elements.add(element)
        }
        elements.reverse()

        for (el in elements) {
            stacks[move.to]!!.addLast(el)
        }
    }
}