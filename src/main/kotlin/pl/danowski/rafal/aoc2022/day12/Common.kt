package pl.danowski.rafal.aoc2022.day12

import java.util.PriorityQueue
import java.util.Queue
import kotlin.math.abs

typealias Area = List<List<Node>>

fun populateArea(lines: List<String>): Area {
    val area = mutableListOf<List<Node>>()
    for (line in lines.withIndex()) {
        val splitted = line.value
            .split("")
            .filter { it.length == 1 }
            .map { it.first() }
        val row = mutableListOf<Node>()
        for (char in splitted.withIndex()) {
            val node = Node(
                char = char.value,
                row = line.index,
                column = char.index,
            )
            row.add(node)
        }
        area.add(row)
    }
    return area
}

fun dijkstra(starNode: Node, area: Area): Int {
    val queue = PriorityQueue<Node>(area.size * area.first().size) { node1, node2 ->
        node1.totalCost - node2.totalCost
    }
    starNode.totalCost = 0
    queue.add(starNode)

    while (queue.isNotEmpty()) {
        val node = queue.remove()
        if (node.isEnd) return node.totalCost

        val rowUp = node.row - 1
        if (areValidCoordinates(rowUp, node.column, area)) {
            val nodeUp = area[rowUp][node.column]
            addNodeToQueue(nodeUp, queue, node)
        }

        val rowDown = node.row + 1
        if (areValidCoordinates(rowDown, node.column, area)) {
            val nodeDown = area[rowDown][node.column]
            addNodeToQueue(nodeDown, queue, node)
        }

        val colLeft = node.column - 1
        if (areValidCoordinates(node.row, colLeft, area)) {
            val nodeLeft = area[node.row][colLeft]
            addNodeToQueue(nodeLeft, queue, node)
        }

        val colRight = node.column + 1
        if (areValidCoordinates(node.row, colRight, area)) {
            val nodeRight = area[node.row][colRight]
            addNodeToQueue(nodeRight, queue, node)
        }
    }

    return -1
}

fun addNodeToQueue(node: Node, queue: Queue<Node>, prevNode: Node) {
    if (node.height - prevNode.height > 1) {
        // too big step up or step down
        return
    }

    if (node.totalCost > prevNode.totalCost + node.cost) {
        node.totalCost = prevNode.totalCost + node.cost
        queue.add(node)
    }
}

fun areValidCoordinates(row: Int, column: Int, area: Area): Boolean {
    val rows = area.size
    val columns = area.first().size
    return row in 0 until rows && column in 0 until columns
}

data class Node(
    internal val char: Char,
    val row: Int,
    val column: Int
) {
    val cost = 1
    val height: Int = calculateHeight(char)
    var totalCost: Int = Integer.MAX_VALUE
    val isStart: Boolean = char == 'S'
    val isEnd: Boolean = char == 'E'

    private fun calculateHeight(char: Char) =
        when (char) {
            'S' -> 0
            'E' -> 25
            else -> abs('a' - char)
        }


}
