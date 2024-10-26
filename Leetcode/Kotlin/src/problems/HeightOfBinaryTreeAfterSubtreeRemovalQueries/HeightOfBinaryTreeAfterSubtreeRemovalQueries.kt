package problems.HeightOfBinaryTreeAfterSubtreeRemovalQueries

import utils.printArray

// https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class Solution {

    private val heights = mutableMapOf<TreeNode?, Int>(null to 0)
    private val excludedHeights = mutableMapOf<Int, Int>()

    private fun computeHeights(root: TreeNode?): Int {
        if (root == null) return 0

        val leftHeight = computeHeights(root.left)
        val rightHeight = computeHeights(root.right)

        heights[root] = maxOf(leftHeight, rightHeight) + 1

        return heights[root]!!
    }

    private fun dfs(root: TreeNode?, depth: Int, height: Int) {
        if (root == null) return

        excludedHeights[root.`val`] = height

        dfs(root.left, depth + 1, maxOf(height, heights[root.right]!! + depth + 1))
        dfs(root.right, depth + 1, maxOf(height, heights[root.left]!! + depth + 1))
    }

    fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
        computeHeights(root)
        dfs(root, -1, 0)

        return queries.map { excludedHeights[it]!! }.toIntArray()
    }
}


fun main() {
    val sol = Solution()

    val root1 = TreeNode(1).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2)
        }

        right = TreeNode(4).apply {
            left = TreeNode(6)

            right = TreeNode(5).apply {
                right = TreeNode(7)
            }
        }
    }
    printArray(sol.treeQueries(root1, intArrayOf(4)))

    val root2 = TreeNode(5).apply {
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
    printArray(sol.treeQueries(root2, intArrayOf(3, 2, 4, 8)))
}