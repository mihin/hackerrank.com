package test.kotlin.hackerrank

import java.util.*
import kotlin.collections.ArrayList

class UniqueColors : IHackerrankInput {

    override fun main(args: String) {
        val scan = Scanner(args)

        val n = scan.nextLine().trim().toInt()

        val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        val mTree = Tree(c.mapIndexed { ind, color -> TreeNode(ind + 1, color) })

//        val tree = Array<Array<Int>>(n - 1, { Array<Int>(2, { 0 }) })

        for (treeRowItr in 0 until n - 1) {
//            tree[treeRowItr] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
            val edge = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
            mTree.addEdge(edge[0], edge[1])
        }

        mTree.print()
    }
}

class Tree(val nodes: List<TreeNode>) {

    fun addEdge(node1: Int, node2: Int) {
        nodes.find {it.id == node1}!!.addLink(nodes.find {it.id == node2}!!)
        nodes.find {it.id == node2}!!.addLink(nodes.find {it.id == node1}!!)
    }

    fun print() {
        println("Tree with edges")
        for (node in nodes)
            println(node.print())
    }
}

class TreeNode(val id: Int, val color: Int) {
    var links: MutableList<TreeNode> = ArrayList()

    fun addLink(node: TreeNode) {
        links.add(node)
    }

    fun print(): String {
        return if (links.size == 1) "${id} - ${links[0].id}" else "${links[0].id} - ${id} - ${links[1].id}"
    }
}