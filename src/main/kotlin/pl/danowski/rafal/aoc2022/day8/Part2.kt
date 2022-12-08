package pl.danowski.rafal.aoc2022.day8

import pl.danowski.rafal.aoc2022.readFromFile

object Part2 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val treeArray = readTableFromInput(lines)

        val scenicScores = mutableListOf<Int>()

        for (row in treeArray.indices) {
            for (column in treeArray[0].indices) {
                scenicScores.add(calculateScenicScore(row, column, treeArray))
            }
        }

        return scenicScores.max()
    }

    private fun calculateScenicScore(row: Int, column: Int, treeArray: TreeArray): Int {
        val treeHeight = treeArray[row][column]

        // left
        var leftSideVisibleTreesCount = 0
        for (i in column - 1 downTo  0) {
            val currTreeHeight = treeArray[row][i]
            leftSideVisibleTreesCount++
            if (currTreeHeight >= treeHeight) {
                break
            }
        }

        // right
        var rightSideVisibleTreesCount = 0
        for (i in column + 1 until treeArray.size) {
            val currTreeHeight = treeArray[row][i]
            rightSideVisibleTreesCount++
            if (currTreeHeight >= treeHeight) {
                break
            }
        }

        // top
        var topSideVisibleTreesCount = 0
        for (i in row - 1 downTo  0) {
            val currTreeHeight = treeArray[i][column]
            topSideVisibleTreesCount++
            if (currTreeHeight >= treeHeight) {
                break
            }
        }

        // bottom
        var bottomSideVisibleTreesCount = 0
        for (i in row + 1 until  treeArray[0].size) {
            val currTreeHeight = treeArray[i][column]
            bottomSideVisibleTreesCount++
            if (currTreeHeight >= treeHeight) {
                break
            }
        }

        return leftSideVisibleTreesCount * rightSideVisibleTreesCount * topSideVisibleTreesCount * bottomSideVisibleTreesCount
    }
}
