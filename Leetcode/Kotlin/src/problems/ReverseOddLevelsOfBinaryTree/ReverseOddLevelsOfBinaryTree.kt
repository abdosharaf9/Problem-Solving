package problems.ReverseOddLevelsOfBinaryTree

import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class Solution {
    // Time: O(n)
    // Space: O(1), because no space is needed other than the input and call stack.
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        fun swap(a: TreeNode?, b: TreeNode?, level: Int) {
            // Stop the recursion if there is only one child.
            if (a == null || b == null) return

            // Swap two nodes by swapping their values if the current level is odd.
            if (level % 2 == 1) {
                a.`val` = b.`val`.also { b.`val` = a.`val` }
            }

            // Do the same thing for the children of the two nodes.
            // We swap the leftmost node with the rightmost node, and
            // the middle ones are swapped with each other.
            swap(a.left, b.right, level + 1)
            swap(a.right, b.left, level + 1)
        }

        // Start recurring if there is a tree root.
        root?.let { swap(it.left, it.right, 1) }
        return root
    }

    // Time: O(n)
    // Space: O(n), because the maximum number of items in the queue will be
    // the tree width.
    /*fun reverseOddLevels(root: TreeNode?): TreeNode? {
        // Used to traverse the tree in a level by level order - BFS.
        val queue: Queue<TreeNode> = LinkedList(listOf(root))

        // Track the current level number.
        var level = 0

        while (queue.isNotEmpty()) {
            // Used to store the current level nodes.
            val size = queue.size
            val currentLevelNodes = mutableListOf<TreeNode>()

            // Add the next level nodes to the queue, and the current
            // node to the current level nodes list.
            for (i in 0..<size) {
                val cur = queue.poll()
                cur.left?.let { queue.add(it) }
                cur.right?.let { queue.add(it) }
                currentLevelNodes.add(cur)
            }

            // Swap the values of the current level nodes if it is
            // an odd level number.
            if (level % 2 == 1) {
                for (i in 0..<size / 2) {
                    val temp = currentLevelNodes[i].`val`
                    currentLevelNodes[i].`val` = currentLevelNodes[size - i - 1].`val`
                    currentLevelNodes[size - i - 1].`val` = temp
                }
            }

            // Update the level number.
            level++
        }

        return root
    }*/
}

fun main() {
    val sol = Solution()

    val root1 = createTree(listOf(2, 3, 5, 8, 13, 21, 34))
    print("[")
    printTree(sol.reverseOddLevels(root1))
    println("]")

    val root2 = createTree(listOf(7, 13, 11))
    print("[")
    printTree(sol.reverseOddLevels(root2))
    println("]")

    val root3 = createTree(listOf(0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2))
    print("[")
    printTree(sol.reverseOddLevels(root3))
    println("]")
}

private fun createTree(list: List<Int>): TreeNode? {
    if (list.isEmpty()) return null

    val root = TreeNode(list[0])
    val queue: Queue<TreeNode> = LinkedList(listOf(root))
    var index = 1

    while (index < list.size) {
        val cur = queue.poll()

        cur.left = TreeNode(list[index])
        queue.add(cur.left)
        index++

        if (index < list.size) {
            cur.right = TreeNode(list[index])
            queue.add(cur.right)
            index++
        }
    }

    return root
}

private fun printTree(root: TreeNode?) {
    val queue: Queue<TreeNode> = LinkedList(listOf(root))
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        cur.left?.let { queue.add(it) }
        cur.right?.let { queue.add(it) }
        if (queue.isEmpty()) print(cur.`val`)
        else print("${cur.`val`}, ")
    }
}