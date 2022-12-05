package pl.danowski.rafal.aoc2022.day5

import pl.danowski.rafal.aoc2022.readFromFile

typealias Stacks = Map<Int, ArrayDeque<Char>>

object Part1 {
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
        repeat(move.times) {
            val element = stacks[move.from]!!.removeLast()
            stacks[move.to]!!.addLast(element)
        }
    }
}
