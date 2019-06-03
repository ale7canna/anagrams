package ale7canna.anagrams

import kotlin.system.measureTimeMillis

class ChildNode<T>(val item: T) : Node<T>() {
    fun traverse(): List<List<T>> =
        if (children.any())
            children.flatMap { it ->
                it.traverse().map { x -> listOf(item) + x }
            }
        else
            listOf(listOf(item))
}

open class Node<T> {
    var children = emptyList<ChildNode<T>>()

    fun addChild(item: T): Node<T> {
        val node = ChildNode(item)
        children += node
        return node
    }

    fun traverseAll(): List<List<T>> {
        var result = emptyList<List<T>>()
        children.forEach { result += it.traverse() }
        return result
    }
}

class Permutations {
    fun compute(s: String): List<String> =
        compute(s.toCharArray().map { it })
            .map { String(it.toCharArray()) }

    fun <T> compute(list: List<T>): List<List<T>> {
        val tree = Node<T>()
        var result = emptyList<List<T>>()
        val fill = measureTimeMillis { fillTree(tree, list) }
        println("fill: $fill")
        val trav = measureTimeMillis { result = tree.traverseAll() }
        println("trav: $trav")
        return result
    }

    private tailrec fun <T> fillTree(node: Node<T>, list: List<T>) {
        for (k in 0 until list.size)
        {
            val child = node.addChild(list[k])
            fillTree(child, list.removeAt(k))
        }
    }

    private fun <T> List<T>.removeAt(index: Int): List<T> =
        this.take(index) + this.drop(index + 1)
}
