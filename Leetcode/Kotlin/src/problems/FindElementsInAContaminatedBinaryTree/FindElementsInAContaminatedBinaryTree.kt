package problems.FindElementsInAContaminatedBinaryTree

import java.util.Queue
import java.util.LinkedList

// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// Time: O(n)
// Space: O(n)
private class FindElements(root: TreeNode?) {

    // Store all the seen numbers to access them easily in O(1).
    val seen = HashSet<Int>()

    // Recover the tree when the class is initialized.
    init {
        dfs(root, 0) // O(n)
    }

    // Traversing the tree using DFS, and adding the value of each node to the set.
    fun dfs(node: TreeNode?, value: Int) {
        if (node == null) return
        seen.add(value)

        // Applying the rules
        node.left?.let { dfs(it, 2 * value + 1) }
        node.right?.let { dfs(it, 2 * value + 2) }
    }

    // Check if the target is in the seen numbers.
    fun find(target: Int): Boolean { // O(1)
        return seen.contains(target)
    }

}

// Time: O(n)
// Space: O(n)
/*private class FindElements(root: TreeNode?) {

    val seen = HashSet<Int>()

    // Recover the tree when the class is initialized. Traversing the tree
    // using BFS, and adding the value of each node to the set.
    init {
        // Changing the root's value to 0, and adding it to the seen set.
        root!!.`val` = 0
        seen.add(0)

        // Start with the root node.
        val queue: Queue<TreeNode> = LinkedList(listOf(root))

        while (queue.isNotEmpty()) {
            // Get the current node.
            val node = queue.poll()

            // Change the left child value, and add it to the seen set only
            // if it is not null.
            node.left?.let {
                val new = 2 * node.`val` + 1
                it.`val` = new
                seen.add(new)
                queue.add(it)
            }

            // Change the right child value, and add it to the seen set only
            // if it is not null.
            node.right?.let {
                val new = 2 * node.`val` + 2
                it.`val` = new
                seen.add(new)
                queue.add(it)
            }
        }
    }

    // Check if the target is in the seen numbers.
    fun find(target: Int): Boolean { // O(1)
        return seen.contains(target)
    }

}*/

fun main() {
    println("Example #1:")
    var root = TreeNode(-1).apply {
        right = TreeNode(-1)
    }
    var findElements = FindElements(root)
    println(findElements.find(1))
    println(findElements.find(2))

    println("Example #2:")
    root = TreeNode(-1).apply {
        left = TreeNode(-1).apply {
            left = TreeNode(-1)
            right = TreeNode(-1)
        }
        right = TreeNode(-1)
    }
    findElements = FindElements(root)
    println(findElements.find(1))
    println(findElements.find(3))
    println(findElements.find(5))

    println("Example #3:")
    root = TreeNode(-1).apply {
        right = TreeNode(-1).apply {
            left = TreeNode(-1).apply {
                left = TreeNode(-1)
            }
        }
    }
    findElements = FindElements(root)
    println(findElements.find(2))
    println(findElements.find(3))
    println(findElements.find(4))
    println(findElements.find(5))
}