package pl.danowski.rafal.aoc2022.day7

abstract class Node(val name: String, val parent: Node?, val depth: Int) {
    open fun addChild(child: Node) {
        throw IllegalStateException()
    }

    open fun findChild(name: String): Node? {
        throw IllegalStateException()
    }

    abstract fun calculateSize(): Long
}

class File(private val size: Long, name: String, parent: Node, depth: Int) : Node(name, parent, depth) {
    override fun calculateSize() = size

    override fun toString(): String = "${"\t".repeat(depth)}- $name (file,  size = $size)"
}

class Dir(
    name: String,
    parent: Node? = null,
    depth: Int,
    private val children: MutableList<Node> = mutableListOf(),
) : Node(name, parent, depth) {

    override fun addChild(child: Node) {
        children.add(child)
    }

    override fun calculateSize(): Long = children.sumOf { it.calculateSize() }

    override fun findChild(name: String): Node? =
        children.find { it.name == name }

    override fun toString(): String =
        "${"\t".repeat(depth)}- $name (dir)\n${children.joinToString("\n", transform = Node::toString)}"
}

fun parseFilesystem(lines: List<String>): Pair<Dir, List<Dir>> {
    val root = Dir(name = "/", depth = 0)
    val directories = mutableListOf<Dir>()
    directories.add(root)

    var currentNode: Node = root
    var depth = 1

    for (line in lines) {
        val splitted = line.split(" ")

        when (splitted.first()) {
            "$" -> { // operation
                val second = splitted[1]
                if (second == "cd") {
                    val third = splitted[2]
                    currentNode = if (third == "..") {
                        depth -= 1
                        currentNode.parent ?: root
                    } else {
                        depth += 1
                        currentNode.findChild(third) ?: currentNode
                    }
                } else if (second == "ls") {
                    continue
                }
            }
            "dir" -> { // listed dir
                val name = splitted[1]
                val dir = Dir(name = name, parent = currentNode, depth)
                currentNode.addChild(dir)
                directories.add(dir)
            }
            else -> { // listed file
                val size = splitted.first().toLong()
                val name = splitted[1]
                val file = File(name = name, parent = currentNode, size = size, depth = depth)
                currentNode.addChild(file)
            }
        }
    }

    println(root)

    return root to directories
}