package problems.FindEventualSafeStates

import utils.printArray

// https://leetcode.com/problems/find-eventual-safe-states/

private class Solution {
    // O(V + E), because we will traverse all the paths.
    // O(V)
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        // Get the number of nodes.
        val n = graph.size

        // Used as memoization, 0 represent unvisited, 1 is unsafe, and 2 is safe.
        val isSafe = IntArray(n)

        // Traverse the graph using DFS to follow all the path.
        fun dfs(i: Int): Boolean {
            // If we calculated the value before, return it.
            if (isSafe[i] == 1) {
                return false
            }
            if (isSafe[i] == 2) {
                return true
            }

            // Initially consider it as an unsafe node before exploring its neighbors.
            isSafe[i] = 1
            for (nei in graph[i]) {
                // If a neighbor is unsafe, the current node is unsafe.
                if (!dfs(nei)) {
                    return false
                }
            }

            // If all the neighbors are safe, thus the current node is safe.
            isSafe[i] = 2
            return true
        }

        // Explore all the neighbors of each node to check if it is
        // safe and add it to the result.
        val res = mutableListOf<Int>()
        for (i in 0..<n) {
            if (dfs(i)) {
                res.add(i)
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()

    printArray(
        sol.eventualSafeNodes(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(5),
                intArrayOf(0),
                intArrayOf(5),
                intArrayOf(),
                intArrayOf()
            )
        )
    )

    printArray(
        sol.eventualSafeNodes(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(1, 2),
                intArrayOf(3, 4),
                intArrayOf(0, 4),
                intArrayOf()
            )
        )
    )
}