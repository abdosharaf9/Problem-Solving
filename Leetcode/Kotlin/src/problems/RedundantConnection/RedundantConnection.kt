package problems.RedundantConnection

import utils.printArray

// https://leetcode.com/problems/redundant-connection/

private class Solution {
    // Time: O(V + E)
    // Space: O(V)
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        // Get the number of vertices.
        val n = edges.size

        // Store the parent and rank of each node.
        val parent = IntArray(n + 1) { it }
        val rank = IntArray(n + 1) { 1 }

        // Find the parent of each node.
        fun find(n: Int): Int {
            if (parent[n] != n) {
                parent[n] = find(parent[n])
            }

            return parent[n]
        }

        // Union two nodes.
        fun union(n1: Int, n2: Int): Boolean {
            // Get the parent of both nodes.
            val p1 = find(n1)
            val p2 = find(n2)

            // If they have the same parent, we can't union them because they are
            // already part of the same component.
            if (p1 == p2) {
                return false
            }

            // Make the union according to the rank, and then change the ranks and parents.
            if (rank[p1] > rank[p2]) {
                parent[p2] = p1
                rank[p1] += rank[p2]
            } else {
                parent[p1] = p2
                rank[p2] += rank[p1]
            }

            return true
        }

        // Loop over all the edges until we can't union the nodes of
        // the current edge, which means they are already connected
        // and this edge will offer a cycle.
        for ((n1, n2) in edges) {
            if (!union(n1, n2)) {
                return intArrayOf(n1, n2)
            }
        }

        // We won't get here anyway.
        return intArrayOf(0, 0)
    }
}

fun main() {
    val sol = Solution()

    printArray(
        sol.findRedundantConnection(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 3)
            )
        )
    )

    printArray(
        sol.findRedundantConnection(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(1, 4),
                intArrayOf(1, 5)
            )
        )
    )
}