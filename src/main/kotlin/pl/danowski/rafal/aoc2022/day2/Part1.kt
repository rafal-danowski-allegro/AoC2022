package pl.danowski.rafal.aoc2022.day2

import pl.danowski.rafal.aoc2022.day2.Shape1.ROCK
import pl.danowski.rafal.aoc2022.day2.Shape1.PAPER
import pl.danowski.rafal.aoc2022.day2.Shape1.SCISSORS
import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val duels = lines.map(this::createDuelFromLine)

        return duels.sumOf(Duel::calculateResult)
    }

    private fun createDuelFromLine(line: String): Duel {
        val (opponentShape, playerShape) = line.split(" ")
        return Duel(
            Shape1.fromCode(opponentShape),
            Shape1.fromCode(playerShape),
        )
    }
}

class Duel(
    private val opponentShape: Shape1,
    private val playerShape: Shape1,
) {
    fun calculateResult() =
        playerShape.score + duelOutcome()

    private fun duelOutcome(): Int =
        if (opponentShape == ROCK && playerShape == ROCK ||
            opponentShape == PAPER && playerShape == PAPER ||
            opponentShape == SCISSORS && playerShape == SCISSORS) {
            // draw
            3
        } else if (opponentShape == ROCK && playerShape == SCISSORS ||
            opponentShape == PAPER && playerShape == ROCK ||
            opponentShape == SCISSORS && playerShape == PAPER) {
            // lose
            0
        } else {
            // win
            6
        }
}

enum class Shape1(val score: Int, private val codes: List<String>) {
    ROCK(1, listOf("A", "X")),
    PAPER(2, listOf("B", "Y")),
    SCISSORS(3, listOf("C", "Z"));

    companion object {
        fun fromCode(code: String) =
            values().find { code in it.codes }
                ?: throw IllegalArgumentException()
    }
}

/*
A for Rock, B for Paper, and C for Scissors.

X for Rock, Y for Paper, and Z for Scissors

(0 if you lost, 3 if the round was a draw, and 6 if you won)

(1 for Rock, 2 for Paper, and 3 for Scissors)
 */