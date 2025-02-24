package problems.MostProfitablePathInATree

import java.util.Queue
import java.util.LinkedList

// https://leetcode.com/problems/most-profitable-path-in-a-tree/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    // Note that this is a tree, which means we won't face any cycles in the graph, so
    // there is no need to mark any node as visited, we just need to avoid the parent.
    fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
        val n = amount.size

        // Build the adjacency list of the graph.
        val adj = Array(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            // Note that it's an undirected graph.
            adj[u].add(v)
            adj[v].add(u)
        }

        // Bob Simulation - DFS
        // Store the time Bob will reach each node until he reaches node 0.
        val bobTimes = IntArray(n) { -1 }

        fun dfs(src: Int, prev: Int, time: Int): Boolean {
            // If Bob reaches node 0, we store the time and return true to indicate
            // this path leads to 0.
            if (src == 0) {
                bobTimes[src] = time
                return true
            }

            // Try the neighbors of the current node.
            for (nei in adj[src]) {
                // Skip the node we came from.
                if (nei == prev) {
                    continue
                }

                // If we can reach node 0 through this node, update its time
                // and stop searching.
                if (dfs(nei, src, time + 1)) {
                    bobTimes[src] = time
                    return true
                }
            }

            // Bob can't reach node 0 using the current path.
            return false
        }

        // Start simulating Bob's path to reach node 0.
        dfs(bob, -1, 0)


        // Alice Simulation - BFS
        var res = Int.MIN_VALUE

        // Store each path Alice can go in using: current node, current time,
        // previous node she came from, and the profit collected until now.
        data class Path(val node: Int, val time: Int, val prev: Int, val profit: Int)

        // Start her path at node 0.
        val queue: Queue<Path> = LinkedList(listOf(Path(0, 0, -1, amount[0])))

        while (queue.isNotEmpty()) {
            // Get the current path.
            val path = queue.poll()

            // Explore all possible next nodes for Alice to continue her journey.
            for (nei in adj[path.node]) {
                // Avoid going back where we came from.
                if (nei == path.prev) {
                    continue
                }

                // Increase the time for the neighbor.
                val neiTime = path.time + 1

                // If Bob visits this node in his path, update the profit according to who
                // will reach it first. If Bob reaches it first, Alice won't get anything.
                // If both reach it at the same time, share the profit.
                val neiProfit = when {
                    bobTimes[nei] > -1 && neiTime > bobTimes[nei] -> 0
                    bobTimes[nei] > -1 && neiTime == bobTimes[nei] -> amount[nei] / 2
                    else -> amount[nei]
                }

                // Add the path again to the queue to try to go further in it.
                queue.add(Path(nei, neiTime, path.node, path.profit + neiProfit))

                // If this neighbor is a leaf node, maximize the result.
                if (adj[nei].size == 1) {
                    res = maxOf(res, path.profit + neiProfit)
                }
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.mostProfitablePath(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(3, 4)
            ),
            3,
            intArrayOf(-2, 4, 2, -4, 6)
        )
    )

    println(
        sol.mostProfitablePath(
            arrayOf(
                intArrayOf(0, 1)
            ),
            1,
            intArrayOf(-7280, 2350)
        )
    )
}