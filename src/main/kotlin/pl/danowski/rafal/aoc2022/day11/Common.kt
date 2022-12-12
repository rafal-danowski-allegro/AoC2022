package pl.danowski.rafal.aoc2022.day11

import java.math.BigInteger

fun monkeysFromInputLines(lines: List<String>, areMonkeysBored: Boolean): List<Monkey> {
    val monkeys = mutableListOf<Monkey>()

    val iter = lines.iterator()
    while (iter.hasNext()) {
        iter.next() // "Monkey X"
        val startingItemsLine = iter.next()
        val operationLine = iter.next()
        val divisibleByLine = iter.next()
        val testTrueMonkeyLine = iter.next()
        val testFalseLine = iter.next()

        val monkey = Monkey(
            startingItems = startingItemsFromLine(startingItemsLine),
            isMonkeyBored = areMonkeysBored,
            operation = operationFromLine(operationLine),
            divisibleByTest = divisibleByFromLine(divisibleByLine),
            testTrueMonkey = trueTestMonkeyNumberFromLine(testTrueMonkeyLine),
            testFalseMonkey = falseTestMonkeyNumberFromLine(testFalseLine),
        )
        monkeys.add(monkey)

        if (iter.hasNext()) iter.next() // empty line
    }

    return monkeys
}

fun startingItemsFromLine(line: String) =
    line.replace("  Starting items: ", "")
        .split(", ")
        .map { BigInteger(it) }

fun operationFromLine(line: String): (BigInteger) -> BigInteger {
    val splitted = line.replace("  Operation: new = old ", "")
        .split(" ")
    val op = splitted[0]
    try {
        val value = BigInteger(splitted[1])
        if (op == "+") {
            return { x: BigInteger -> x + value }
        } else { // "*"
            return { x: BigInteger -> x * value }
        }
    } catch (e: NumberFormatException) {
        if (op == "+") {
            return { x: BigInteger -> x + x }
        } else { // "*"
            return { x: BigInteger -> x * x }
        }
    }
}

fun divisibleByFromLine(line: String) =
    BigInteger(line.replace("  Test: divisible by ", ""))

fun trueTestMonkeyNumberFromLine(line: String) =
    line.replace("    If true: throw to monkey ", "").toInt()

fun falseTestMonkeyNumberFromLine(line: String) =
    line.replace("    If false: throw to monkey ", "").toInt()

class Monkey(
    startingItems: List<BigInteger>,
    private val isMonkeyBored: Boolean,
    private val operation: (BigInteger) -> BigInteger,
    val divisibleByTest: BigInteger,
    private val testTrueMonkey: Int,
    private val testFalseMonkey: Int,
) {
    private val items = startingItems.toMutableList()
    var inspectedItemsCount: BigInteger = BigInteger.ZERO

    fun receiveItem(item: BigInteger) {
        items.add(item)
    }

    fun throwItems(): List<Pair<BigInteger, Int>> {
        val itemsToThrow = mutableListOf<Pair<BigInteger, Int>>()
        for (item in items) {
            val newWorryLevel = operation(item) // inspection
            inspectedItemsCount = inspectedItemsCount.inc()
            val afterInspectionWorryLevel = if (isMonkeyBored) {
                newWorryLevel.divide(BigInteger("3"))
            } else {
                newWorryLevel
            }
            if (afterInspectionWorryLevel.remainder(divisibleByTest) == BigInteger.ZERO) {
                itemsToThrow.add(afterInspectionWorryLevel to testTrueMonkey)
            } else {
                itemsToThrow.add(afterInspectionWorryLevel to testFalseMonkey)
            }
        }
        items.clear()
        return itemsToThrow
    }
}
