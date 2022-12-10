package pl.danowski.rafal.aoc2022.day10

class Register {
    private var currentValue = 1
    internal val values = mutableListOf(currentValue)

    fun noop() {
        values.add(currentValue)
    }

    fun addx(x: Int) {
        values.add(currentValue)
        currentValue += x
        values.add(currentValue)
    }
}

fun populateRegister(register: Register, lines: List<String>) {
    for (line in lines) {
        val splitted = line.split(" ")
        if (splitted.size == 1) { // noop
            register.noop()
        } else { // addx X
            register.addx(splitted[1].toInt())
        }
    }
}
