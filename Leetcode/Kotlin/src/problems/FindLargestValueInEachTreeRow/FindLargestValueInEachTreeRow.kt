package problems.FindLargestValueInEachTreeRow

import utils.printArray
import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class Solution {
    // Time: O(n), because we only loop over the nodes.
    // Space: (n), which is used to store the elements in the queue.
    fun largestValues(root: TreeNode?): List<Int> {
        // There is no tree to traverse.
        if (root == null) return emptyList()

        // Store the maximum of each level.
        val res = mutableListOf<Int>()
        // Used to traverse using BFS.
        val queue: Queue<TreeNode> = LinkedList(listOf(root))

        while (queue.isNotEmpty()) {
            // The number of nodes in the current level.
            val size = queue.size
            var curMax = Int.MIN_VALUE

            // Pop all the nodes in the level and add their children
            // if they exist. Then, update the max value of the level.
            repeat(size) {
                val node = queue.poll()
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
                curMax = maxOf(curMax, node.`val`)
            }

            // Add the max of the level to the result.
            res.add(curMax)
        }

        return res
    }
}

fun main() {
    val sol = Solution()

    val root1 = TreeNode(1).apply {
        left = TreeNode(3).apply {
            left = TreeNode(5)
            right = TreeNode(3)
        }

        right = TreeNode(2).apply {
            right = TreeNode(9)
        }
    }
    printArray(sol.largestValues(root1))

    val root2 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }
    printArray(sol.largestValues(root2))
}