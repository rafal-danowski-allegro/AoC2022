package pl.danowski.rafal.aoc2022.day8

import pl.danowski.rafal.aoc2022.readFromFile

object Part1 {
    fun solve(filename: String): Int {
        val lines = readFromFile(filename)
        val treeArray = readTableFromInput(lines)

        var visibleTreesCount = treeArray.size * 2 + treeArray[0].size * 2 - 4
        for (row in 1 until treeArray.lastIndex) {
            for (column in 1 until treeArray[0].lastIndex) {
                if (isTreeVisible(row, column, treeArray)) {
                    visibleTreesCount++
                }
            }
        }

        return visibleTreesCount
    }

    private fun isTreeVisible(row: Int, column: Int, treeArray: TreeArray): Boolean {
        val treeHeight = treeArray[row][column]

        // left
        var isVisibleLeft = true
        for (i in 0 until column) {
            val currTreeHeight = treeArray[row][i]
            if (currTreeHeight >= treeHeight) {
                isVisibleLeft = false
            }
        }

        // right
        var isVisibleRight = true
        for (i in column + 1 until treeArray.size) {
            val currTreeHeight = treeArray[row][i]
            if (currTreeHeight >= treeHeight) {
                isVisibleRight = false
            }
        }

        // top
        var isVisibleTop = true
        for (i in 0 until row) {
            val currTreeHeight = treeArray[i][column]
            if (currTreeHeight >= treeHeight) {
                isVisibleTop = false
            }
        }

        // bottom
        var isVisibleBottom = true
        for (i in row + 1 until treeArray[0].size) {
            val currTreeHeight = treeArray[i][column]
            if (currTreeHeight >= treeHeight) {
                isVisibleBottom = false
            }
        }

        return isVisibleLeft || isVisibleRight || isVisibleTop || isVisibleBottom
    }
}