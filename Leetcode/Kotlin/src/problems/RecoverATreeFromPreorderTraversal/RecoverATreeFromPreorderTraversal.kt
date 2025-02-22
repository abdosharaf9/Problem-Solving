package problems.RecoverATreeFromPreorderTraversal

import java.util.Stack

// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun recoverFromPreorder(traversal: String): TreeNode? {
        // Count the number of dashes we faced until we reached the current node's value.
        var dashes = 0

        // Store the nodes in a stack to simulate the DFS traversal.
        val stack = Stack<TreeNode>()

        // Loop over each character of the input string.
        var i = 0
        while (i < traversal.length) {
            // When we face a dash, increase the dashes count and i pointer.
            if (traversal[i] == '-') {
                dashes++
                i++
            } else {
                // We faced a digit, and we need to get the whole number, so we use a
                // second pointer and loop until we face the next dash.
                var j = i
                while (j < traversal.length && traversal[j] != '-') {
                    j++
                }

                // Get the integer value of that number between both the pointers, and
                // create a new node with that value.
                val value = traversal.substring(i, j).toInt()
                val node = TreeNode(value)

                // If the dashes are less than the nodes in the stack, this means we are done
                // traversing the current branch of the tree, and we need to pop until we
                // reach the right parent of the current node.
                while (stack.size > dashes) {
                    stack.pop()
                }

                // If the stack is not empty, this means there is at least one node in the stack
                // that can be the parent. First, we try to add the node as the left child, and if
                // we can't, we add it as the right child.
                if (stack.isNotEmpty() && stack.peek()!!.left == null) {
                    stack.peek()!!.left = node
                } else if (stack.isNotEmpty()) {
                    stack.peek()!!.right = node
                }

                // If the stack is empty, just add the node.
                stack.add(node)

                // Move the i pointer to the new position and update the number of dashes.
                i = j
                dashes = 0
            }
        }

        // Return the root node.
        return stack.first()
    }
}

fun main() {
    val sol = Solution()
    printTree(sol.recoverFromPreorder("1-2--3--4-5--6--7"))
    printTree(sol.recoverFromPreorder("1-2--3---4-5--6---7"))
    printTree(sol.recoverFromPreorder("1-401--349---90--88"))
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