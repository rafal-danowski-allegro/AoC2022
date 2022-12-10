package pl.danowski.rafal.aoc2022.day10

import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val register = Register()

        populateRegister(register, lines)

        return register.calculateTotalSignalStrength()
    }
}

private fun Register.calculateTotalSignalStrength() =
    20 * this.values[19] +
            60 * values[59] +
            100 * values[99] +
            140 * values[139] +
            180 * values[179] +
            220 * values[219]
