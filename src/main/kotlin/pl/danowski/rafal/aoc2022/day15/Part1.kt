package pl.danowski.rafal.aoc2022.day15

object Part1 {
    fun solve(filename: String, row: Int): Int {
        val (sensorPoints, beaconPoints) = parseInput(filename)
        val sensors = mutableListOf<Sensor>()

        repeat(sensorPoints.size) {
            val sensorPoint = sensorPoints[it]
            val beaconPoint = beaconPoints[it]
            val sensor = Sensor(sensorPoint, beaconPoint)
            sensors.add(sensor)
        }

        val rangesWithoutBeaconForRow = mutableListOf<IntRange>()
        for (sensor in sensors) {
            try {
                rangesWithoutBeaconForRow.add(sensor.calculateRangeWithoutBeaconForRow(row))
            } catch (ignored: RowTooFarException) {
            }
        }

        val leftMost = rangesWithoutBeaconForRow.minOf { it.first }
        val offset = if (leftMost < 0) 0 - leftMost else 0
        val rightMost = rangesWithoutBeaconForRow.maxOf { it.last }
        val rowVisualisation = MutableList(rightMost - leftMost + offset) { 0 }
        for (range in rangesWithoutBeaconForRow) {
            for (i in range) {
                rowVisualisation[i + offset] = 1
            }
        }

        beaconPoints.filter { it.second == row }
            .forEach {
                rowVisualisation[it.x() + offset] = 0
            }

        return rowVisualisation.filter { it == 1 }.sum()
    }
}
