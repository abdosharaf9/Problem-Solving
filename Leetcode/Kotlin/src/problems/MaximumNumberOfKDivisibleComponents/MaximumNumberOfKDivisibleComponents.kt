package problems.MaximumNumberOfKDivisibleComponents

// https://leetcode.com/problems/maximum-number-of-k-divisible-components/

private class Solution {
    // Time: O(n), because the DFS only visits each node once.
    // Space: O(n), which is needed for the call stack and the adjacency list.
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        // The adjacency list for the graph.
        val adj = mutableMapOf<Int, MutableList<Int>>()
        for ((n1, n2) in edges) {
            // Add node n2 to the adjacency list of n1 and
            // node n1 to the adjacency list of n2.
            adj.computeIfAbsent(n1) { mutableListOf() }.add(n2)
            adj.computeIfAbsent(n2) { mutableListOf() }.add(n1)
        }

        // Count of k-divisible components.
        var res = 0

        // DFS search to explore all the children of a node (subtrees).
        fun dfs(node: Int, parent: Int): Long {
            // Start with the value at the current node.
            var total = values[node].toLong()

            // Explore all adjacent nodes and avoid revisiting the
            // parent node, and get the total of the subtree rooted
            // at this node.
            for (child in adj[node] ?: emptyList()) {
                if (child != parent) {
                    total += dfs(child, node)
                }
            }

            // If the total sum for the subtree rooted at this node
            // is divisible by k, increment the count of components.
            if (total.mod(k) == 0) {
                res++
            }

            // Return the total sum of the subtree to continue the recursion.
            return total
        }

        // Start DFS from the root node (assumed to be 0) with no parent (-1).
        dfs(0, -1)

        return res
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.maxKDivisibleComponents(
            5,
            arrayOf(
                intArrayOf(0, 2),
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 4)
            ),
            intArrayOf(1, 8, 1, 4, 4),
            6
        )
    )

    println(
        sol.maxKDivisibleComponents(
            7,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(1, 3),
                intArrayOf(1, 4),
                intArrayOf(2, 5),
                intArrayOf(2, 6)
            ),
            intArrayOf(3, 0, 6, 1, 5, 2, 1),
            3
        )
    )
}