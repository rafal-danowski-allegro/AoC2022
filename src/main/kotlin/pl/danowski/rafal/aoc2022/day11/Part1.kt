package pl.danowski.rafal.aoc2022.day11

import java.math.BigInteger
import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String): BigInteger {
        val lines = readFromFile(filename)
        val monkeys = monkeysFromInputLines(lines, areMonkeysBored = true)

        repeat(20) { // 20 rounds
            for (monkey in monkeys) {
                val items = monkey.throwItems()
                for (item in items) {
                    monkeys[item.second].receiveItem(item.first)
                }
            }
        }

        val inspected = monkeys.map { it.inspectedItemsCount }.sortedDescending()
        return inspected[0] * inspected[1]
    }
}
