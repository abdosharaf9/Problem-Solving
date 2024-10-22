package problems.KthLargestSumInABinaryTree

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class Solution {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        val queue: Queue<TreeNode> = LinkedList()
        val heap = PriorityQueue<Long>()

        if (root != null) queue.add(root)

        while (queue.isNotEmpty()) {
            var levelSum = 0L
            repeat(queue.size) {
                val node = queue.remove()
                levelSum += node.`val`

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }

            heap.add(levelSum)
            if (heap.size > k) heap.poll()
        }

        return if (heap.size < k) -1 else heap.peek()
    }
}

fun main() {
    val sol = Solution()

    val root = TreeNode(5).apply {
        left = TreeNode(8).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(6)
            }

            right = TreeNode(1)
        }

        right = TreeNode(9).apply {
            left = TreeNode(3)
            right = TreeNode(7)
        }
    }
    println(sol.kthLargestLevelSum(root, 2))

    val root2 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }
    println(sol.kthLargestLevelSum(root2, 1))
}