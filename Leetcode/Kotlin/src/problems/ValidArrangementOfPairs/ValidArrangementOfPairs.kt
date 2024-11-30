package problems.ValidArrangementOfPairs

import utils.printMatrixLikeArray

// https://leetcode.com/problems/valid-arrangement-of-pairs/

private class Solution {
    // Hierholzer’s algorithm - Eulerian path
    fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
        // First, build the adjacency list and count the ingoing and outgoing
        // edges for each node.
        val adj = mutableMapOf<Int, MutableList<Int>>()
        val inCount = mutableMapOf<Int, Int>()
        val outCount = mutableMapOf<Int, Int>()

        for ((from, to) in pairs) {
            if (!adj.containsKey(from)) {
                adj[from] = mutableListOf()
            }
            adj[from]!!.add(to)
            inCount[to] = inCount.getOrDefault(to, 0) + 1
            outCount[from] = outCount.getOrDefault(from, 0) + 1
        }

        // Find the perfect node to be the starting point of the path.
        // The best node will have outgoing edges bigger than the ingoing by 1.
        // If there is no node with this condition, we will use any node.
        var start = 0
        for (node in adj.keys) {
            val nodeIn = inCount.getOrDefault(node, 0)
            val nodeOut = outCount.getOrDefault(node, 0)

            if (nodeOut - nodeIn == 1) {
                start = node
                break
            }

            if (nodeOut > 0) {
                start = node
            }
        }

        // Build the path using DFS to explore all the nodes.
        val path = mutableListOf<Int>()
        fun dfs(node: Int) {
            // Note that we will go in depth until we can't go further.
            // After we get stuck, we will add the node to the path start
            // and backtrack to the previous unexplored nodes.
            while (outCount.getOrDefault(node, 0) != 0) {
                // We update the outgoing count to use it as an indicator
                // to explore the neighbors.
                outCount[node] = outCount[node]!! - 1
                val next = adj[node]!![outCount[node]!!]
                dfs(next)
            }

            // Add the node to the path start.
            path.add(0, node)
        }

        dfs(start)

        // Building the result array as pairs.
        val result = Array(pairs.size) { IntArray(2) }
        for (i in 0..<path.lastIndex) {
            result[i] = intArrayOf(path[i], path[i + 1])
        }

        return result
    }
}

fun main() {
    val sol = Solution()

    printMatrixLikeArray(
        sol.validArrangement(
            arrayOf(
                intArrayOf(5, 1),
                intArrayOf(4, 5),
                intArrayOf(11, 9),
                intArrayOf(9, 4)
            )
        )
    )

    printMatrixLikeArray(
        sol.validArrangement(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(3, 2),
                intArrayOf(2, 1)
            )
        )
    )

    printMatrixLikeArray(
        sol.validArrangement(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 1)
            )
        )
    )
}