package problems.MinimumNumberOfOperationsToSortABinaryTreeByLevel

import java.util.*

// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class Solution {
    // Time: O(n * log n)
    // Space: O(n)
    fun minimumOperations(root: TreeNode?): Int {
        // Count minimum swaps we need to sort the level.
        fun countSwaps(level: MutableList<Int>): Int {
            var count = 0

            // Store the index of each number which is used to swap
            // the items in a linear scan.
            val idxMap = mutableMapOf<Int, Int>()
            for ((i, num) in level.withIndex()) {
                idxMap[num] = i
            }

            // We use a sorted version of the list to know the differences
            // between the current version and the desired version.
            val sorted = level.sorted()

            for (i in level.indices) {
                // If we found a number not in the correct place, we must do a swap.
                if (level[i] != sorted[i]) {
                    count++

                    // Get the correct number index and swap them.
                    val j = idxMap[sorted[i]]!!
                    level[i] = level[j].also { level[j] = level[i] }

                    // Update the indices.
                    idxMap[level[i]] = i // This doesn't matter because we won't need it anymore.
                    idxMap[level[j]] = j
                }
            }

            return count
        }

        var res = 0

        // Used to perform a BFS scan to the tree.
        val queue: Queue<TreeNode> = LinkedList(listOf(root))

        while (queue.isNotEmpty()) {
            // Store the current level in an array to sort it easily.
            val currentLevel = mutableListOf<Int>()

            // Take a snapshot of the size, because it's the current level size.
            val size = queue.size
            repeat(size) {
                // Get the next node in the level and add it to the list.
                val cur = queue.poll()
                currentLevel.add(cur.`val`)

                // Add its children if they exist.
                cur.left?.let { queue.add(it) }
                cur.right?.let { queue.add(it) }
            }

            // Increase the result with the minimum swaps of the current level.
            res += countSwaps(currentLevel)
        }

        return res
    }
}

fun main() {
    val sol = Solution()

    val root1 = TreeNode(1).apply {
        left = TreeNode(4).apply {
            left = TreeNode(7)
            right = TreeNode(6)
        }

        right = TreeNode(3).apply {
            left = TreeNode(8).apply {
                left = TreeNode(9)
            }

            right = TreeNode(5).apply {
                left = TreeNode(10)
            }
        }
    }
    println(sol.minimumOperations(root1))

    val root2 = TreeNode(1).apply {
        left = TreeNode(3).apply {
            left = TreeNode(7)
            right = TreeNode(6)
        }

        right = TreeNode(2).apply {
            left = TreeNode(5)
            right = TreeNode(4)
        }
    }
    println(sol.minimumOperations(root2))

    val root3 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }

        right = TreeNode(3).apply {
            left = TreeNode(6)
        }
    }
    println(sol.minimumOperations(root3))
}