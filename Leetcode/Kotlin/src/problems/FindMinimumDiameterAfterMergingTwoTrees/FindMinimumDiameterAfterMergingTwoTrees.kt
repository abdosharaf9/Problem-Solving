package problems.FindMinimumDiameterAfterMergingTwoTrees

import java.util.PriorityQueue
import kotlin.math.ceil

// https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/

private class Solution {
    // Time: O(n), because we just loop over the nodes and avoid the cycles.
    // Space: O(n), which is used to store the adjacency list.
    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {

        // Build the adjacency list from the provided edges.
        fun buildAdj(edges: Array<IntArray>): Map<Int, List<Int>> {
            val adj = mutableMapOf<Int, MutableList<Int>>()
            for ((n1, n2) in edges) {
                // Add both nodes to the list of neighbors of each other, because
                // it isn't a directed graph.
                adj.computeIfAbsent(n1) { mutableListOf() }.add(n2)
                adj.computeIfAbsent(n2) { mutableListOf() }.add(n1)
            }
            return adj
        }

        // Calculate the maximum diameter of a tree using the adjacency list.
        fun calcDiameter(node: Int, parent: Int, adj: Map<Int, List<Int>>): Pair<Int, Int> {
            // Store the maximum value we get.
            var maxDiam = 0

            // Keep track of the two longest paths of the neighbors.
            val maxNeiPaths = PriorityQueue(listOf(0, 0))

            // Explore each neighbor of the current node.
            for (nei in adj.getOrDefault(node, emptyList())) {
                // Avoid going back to the parents to avoid cycles.
                if (nei == parent) {
                    continue
                }

                // Get the maximum values we can get from this neighbor, and then
                // update the diameter.
                val (neiDiam, neiMaxLeafPath) = calcDiameter(nei, node, adj)
                maxDiam = maxOf(maxDiam, neiDiam)

                // Add the longest path through this neighbor.
                maxNeiPaths.add(neiMaxLeafPath)
                // Only keep the longest two paths.
                maxNeiPaths.poll()
            }

            // See if the longest path is the one that goes through this node.
            // In other words, this node is just a node in the middle of it not the root.
            maxDiam = maxOf(maxDiam, maxNeiPaths.sum())

            // Return the maximum diameter and the longest path from the current node.
            return maxDiam to 1 + maxNeiPaths.max()
        }

        // Build the adjacency list for both trees.
        val adj1 = buildAdj(edges1)
        val adj2 = buildAdj(edges2)

        // Calculate the diameter of both trees.
        val (d1, _) = calcDiameter(0, -1, adj1)
        val (d2, _) = calcDiameter(0, -1, adj2)

        // The new diameter can be:
        // 1- the maximum of d1 or d2.
        // 2- d1/2 + d2/2 + 1, because the smallest path we can form will come from
        // adding the new edge between the middle point of each diameter.
        return maxOf(
            d1,
            d2,
            1 + (ceil(d1 / 2.0) + ceil(d2 / 2.0)).toInt()
        )
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.minimumDiameterAfterMerge(
            edges1 = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3)
            ),
            edges2 = arrayOf(
                intArrayOf(0, 1)
            )
        )
    )

    println(
        sol.minimumDiameterAfterMerge(
            edges1 =
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(2, 4),
                    intArrayOf(2, 5),
                    intArrayOf(3, 6),
                    intArrayOf(2, 7)
                ),
            edges2 = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(2, 4),
                intArrayOf(2, 5),
                intArrayOf(3, 6),
                intArrayOf(2, 7)
            )
        )
    )
}