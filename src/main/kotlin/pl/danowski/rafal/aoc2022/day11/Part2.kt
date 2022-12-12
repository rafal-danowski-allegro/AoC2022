package pl.danowski.rafal.aoc2022.day11

import java.math.BigInteger
import pl.danowski.rafal.aoc2022.readFromFile


object Part2 {
    fun solve(filename: String): BigInteger {
        val lines = readFromFile(filename)
        val monkeys = monkeysFromInputLines(lines, areMonkeysBored = false)

        val leastCommonMultiple = calculateLeastCommonMultipleForMonkeys(monkeys)

        repeat(10_000) { // 10000 rounds
            if (it == 1 || it == 20 || it % 1000 == 0) {
                println("== After round $it ==")
                for (indexedMonkey in monkeys.withIndex()) {
                    println("Monkey ${indexedMonkey.index} inspected items ${indexedMonkey.value.inspectedItemsCount} times")
                }
                println()
            }
            for (monkey in monkeys) {
                val items = monkey.throwItems()
                for (item in items) {
                    monkeys[item.second].receiveItem(item.first % leastCommonMultiple)
                }
            }
        }

        for (indexedMonkey in monkeys.withIndex()) {
            println("Monkey ${indexedMonkey.index} inspected items ${indexedMonkey.value.inspectedItemsCount} times")
        }

        val inspected = monkeys.map { it.inspectedItemsCount }.sortedDescending()
        return inspected[0] * inspected[1]
    }

    private fun calculateLeastCommonMultipleForMonkeys(monkeys: List<Monkey>) =
        lcm(monkeys.map { it.divisibleByTest })

    private fun gcd(x: BigInteger, y: BigInteger): BigInteger {
        return if (y == BigInteger.ZERO) x else gcd(y, x % y)
    }

    private fun lcm(numbers: List<BigInteger>): BigInteger {
        return numbers.stream().reduce(BigInteger.ONE) { x: BigInteger, y: BigInteger -> x * (y / gcd(x, y)) }
    }
}
