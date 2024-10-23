package problems.CousinsInBinaryTreeII

import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/cousins-in-binary-tree-ii/

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class Solution {
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        root?.`val` = 0

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var nextLevelSum = 0
            val children = LinkedList(queue)

            repeat(levelSize) {
                val node = queue.remove()
                val childrenSum = (node.left?.`val` ?: 0) + (node.right?.`val` ?: 0)
                nextLevelSum += childrenSum

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }

            children.forEach { node ->
                var sum = nextLevelSum

                node.left?.let { sum -= it.`val` }
                node.right?.let { sum -= it.`val` }

                node.left?.`val` = sum
                node.right?.`val` = sum
            }
        }

        return root
    }

    /*fun replaceValueInTree(root: TreeNode?): TreeNode? {
        val levelSum = mutableListOf<Long>()
        val sQueue: Queue<TreeNode> = LinkedList()
        sQueue.add(root)

        while (sQueue.isNotEmpty()) {
            var currentSum = 0L
            for (i in 1..sQueue.size) {
                val node = sQueue.remove()
                currentSum += node.`val`

                if (node.left != null) sQueue.add(node.left)
                if (node.right != null) sQueue.add(node.right)
            }

            levelSum.add(currentSum)
        }

        val newQueue: Queue<Pair<TreeNode, Long>> = LinkedList()
        newQueue.add(Pair(root!!, root.`val`.toLong()))

        var level = 0
        while (newQueue.isNotEmpty()) {
            for (i in 1..newQueue.size) {
                val (node, value) = newQueue.remove()
                node.`val` = (levelSum[level] - value).toInt()

                var childSum = 0L
                if (node.left != null) childSum += node.left!!.`val`
                if (node.right != null) childSum += node.right!!.`val`

                if (node.left != null) newQueue.add(Pair(node.left!!, childSum))
                if (node.right != null) newQueue.add(Pair(node.right!!, childSum))
            }

            level++
        }

        return root
    }*/
}

fun main() {
    val sol = Solution()

    val root = TreeNode(5).apply {
        left = TreeNode(4).apply {
            left = TreeNode(1)
            right = TreeNode(10)
        }

        right = TreeNode(9).apply {
            right = TreeNode(7)
        }
    }
    print("[")
    printInorder(sol.replaceValueInTree(root))
    println("]")

    val root2 = TreeNode(3).apply {
        left = TreeNode(1)
        right = TreeNode(2)
    }

    print("[")
    printInorder(sol.replaceValueInTree(root2))
    println("]")
}

private fun printInorder(root: TreeNode?) {
    if (root == null) return

    printInorder(root.left)
    print("${root.`val`}, ")
    printInorder(root.right)
}