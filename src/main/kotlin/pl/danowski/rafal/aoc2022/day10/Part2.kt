package pl.danowski.rafal.aoc2022.day10

import kotlin.math.abs
import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String) {
        val lines = readFromFile(filename)
        val register = Register()
        populateRegister(register, lines)

        val crt = CRT()
        var cycle = 0
        for (registerValue in register.values()) {
            crt.setPixel(cycle, registerValue)
            cycle = nextCycle(cycle, crt)
        }
    }

    private fun nextCycle(cycle: Int, crt: CRT) =
        if (cycle >= 39) {
            crt.printHorizontalLine()
            (cycle + 1) % 40
        } else {
            cycle + 1
        }
}

private fun Register.values() =
    values.toList()

class CRT {
    private var horizontalLine = MutableList(40) { "" }

    fun setPixel(cycle: Int, registerValue: Int) {
        if (abs(cycle - registerValue) <= 1) {
            horizontalLine[cycle] = LIT_PIXEL
        } else {
            horizontalLine[cycle] = DARK_PIXEL
        }
    }

    fun printHorizontalLine() {
        println(horizontalLine.joinToString(""))
    }

    companion object {
        const val DARK_PIXEL = "."
        const val LIT_PIXEL = "#"
    }
}
