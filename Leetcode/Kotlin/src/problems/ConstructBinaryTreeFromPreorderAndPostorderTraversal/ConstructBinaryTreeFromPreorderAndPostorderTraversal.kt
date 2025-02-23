package problems.ConstructBinaryTreeFromPreorderAndPostorderTraversal

import java.util.Stack

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        // Get the size of the list.
        val n = preorder.size

        // Map the items in the postorder list to its index.
        val postIdx = mutableMapOf<Int, Int>()
        for (i in 0..<n) {
            postIdx[postorder[i]] = i
        }

        // Build a tree using the item in the i1 index in the preorder list as the root
        // and the next item as the left child. We find where is that next child in the
        // postorder list and the portion between its index in the preorder and postorder
        // lists will be the left subtree of the root. The rest of the list will be the
        // right subtree. We will perform the same function recursively on each subtree
        // to build the whole tree.
        fun build(i1: Int, i2: Int, j1: Int): TreeNode? {
            // If the start and end indices cross each other, we can't go any further.
            if (i1 > i2) {
                return null
            }

            // The root will be the first item in the preorder list.
            val root = TreeNode(preorder[i1])
            if (i1 != i2) {
                // The left child is the next item in the preorder list.
                val leftValue = preorder[i1 + 1]

                // Get the index of that left child in the postorder list, which will be
                // the ending of the whole left subtree.
                val leftEnd = postIdx[leftValue]!!

                // Get the size of the left subtree.
                val leftSize = leftEnd - j1 + 1

                // Build the left subtree using its portion we selected.
                root.left = build(i1 + 1, i1 + leftSize, j1)

                // Build the right subtree using the rest of the items.
                root.right = build(i1 + leftSize + 1, i2, leftEnd + 1)
            }

            // Return the root after adding its children.
            return root
        }

        // Return the built tree using the whole list.
        return build(0, n - 1, 0)
    }
}

fun main() {
    val sol = Solution()
    printTree(sol.constructFromPrePost(intArrayOf(1, 2, 4, 5, 3, 6, 7), intArrayOf(4, 5, 2, 6, 7, 3, 1)))
    printTree(sol.constructFromPrePost(intArrayOf(1), intArrayOf(1)))
}

private fun printTree(root: TreeNode?) {
    val stack = Stack<TreeNode>()
    root?.let { stack.add(it) }

    print("[")
    while (stack.isNotEmpty()) {
        val node = stack.pop()
        node.right?.let { stack.add(it) }
        node.left?.let { stack.add(it) }

        if (stack.isEmpty()) {
            print(node.`val`)
        } else {
            print("${node.`val`}, ")
        }
    }
    println("]")
}