package pl.danowski.rafal.aoc2022.day2

import pl.danowski.rafal.aoc2022.day2.ExpectedDuelOutcome.DRAW
import pl.danowski.rafal.aoc2022.day2.ExpectedDuelOutcome.LOSE
import pl.danowski.rafal.aoc2022.day2.Shape2.PAPER
import pl.danowski.rafal.aoc2022.day2.Shape2.ROCK
import pl.danowski.rafal.aoc2022.day2.Shape2.SCISSORS
import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val duels = lines.map(this::createDuelFromLine)

        return duels.sumOf(Duel2::totalScore)
    }

    private fun createDuelFromLine(line: String): Duel2 {
        val (opponentShape, exceptedOutcome) = line.split(" ")
        return Duel2(
            Shape2.fromCode(opponentShape),
            ExpectedDuelOutcome.fromCode(exceptedOutcome),
        )
    }
}

class Duel2(
    opponentShape: Shape2,
    private val exceptedOutcome: ExpectedDuelOutcome,
) {
    private val playerShape: Shape2 = when (exceptedOutcome) {
        DRAW -> {
            opponentShape
        }
        LOSE -> {
            when(opponentShape) {
                ROCK -> SCISSORS
                PAPER -> ROCK
                SCISSORS -> PAPER
            }
        }
        else -> {
            when(opponentShape) {
                ROCK -> PAPER
                PAPER -> SCISSORS
                SCISSORS -> ROCK
            }
        }
    }

    fun totalScore() =
        playerShape.score + exceptedOutcome.score
}

enum class Shape2(private val code: String, val score: Int) {
    ROCK("A", 1),
    PAPER("B", 2),
    SCISSORS("C", 3);

    companion object {
        fun fromCode(code: String) =
            values().find { it.code == code }
                ?: throw IllegalArgumentException()
    }
}

enum class ExpectedDuelOutcome(val score: Int, private val code: String) {
    LOSE(0, "X"),
    DRAW(3, "Y"),
    WIN(6, "Z");

    companion object {
        fun fromCode(code: String) =
            values().find { it.code == code }
                ?: throw IllegalArgumentException()
    }
}

// X lose, Y draw, and Z win