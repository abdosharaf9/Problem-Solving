package problems.DivideNodesIntoTheMaximumNumberOfGroups

import java.util.Queue
import java.util.LinkedList

// https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/

private class Solution {
    // Time: O(V + E)
    // Space: O(V + E), because of the adjacency list.
    fun magnificentSets(n: Int, edges: Array<IntArray>): Int {
        // Create the adjacency list of the graph.
        val adj = Array(n + 1) { mutableListOf<Int>() }
        for ((n1, n2) in edges) { // O(E)
            // Adding to both because it is an undirected graph.
            adj[n1].add(n2)
            adj[n2].add(n1)
        }

        // Find the connected component that contains the src node using BFS.
        fun getConnectedComponent(src: Int): Set<Int> { // O(V + E)
            // Store all the nodes in the component using a Set.
            val component = mutableSetOf(src)

            // Used to run the BFS.
            val q: Queue<Int> = LinkedList(listOf(src))

            while (q.isNotEmpty()) {
                val node = q.poll()
                for (nei in adj[node]) {
                    // If the node is already visited, continue to the next.
                    if (nei in component) {
                        continue
                    }

                    // Add the node to the queue and the component set.
                    q.add(nei)
                    component.add(nei)
                }

            }

            return component
        }

        // Keep track of the visited nodes.
        val visited = BooleanArray(n + 1)

        // Find the longest path we can get starting from the src node using BFS.
        fun getLongestPath(src: Int): Int { // O(V + E)
            // Each item will be (node, length), where length is the path length
            // we used to reach that node. Note that the src node's length is 1,
            // because actually this is the number of groups, so if there is a single
            // node (src), there will be a single group.
            val q: Queue<Pair<Int, Int>> = LinkedList(listOf(src to 1))

            // Store the length for each node and keep track of the largest
            // one, because this will be the number of groups.
            val dist = mutableMapOf(src to 1)
            var max = 0

            while (q.isNotEmpty()) {
                val (node, length) = q.poll()

                // Update the maximum length.
                max = maxOf(max, length)

                for (nei in adj[node]) {
                    // If we visited this neighbor before, continue to the next one.
                    if (nei in dist) {
                        // If the neighbor and the current node have the same length, aka
                        // group number, this means we can't slice this graph into groups.
                        // This will happen if the cycle length is odd.
                        if (dist[nei] == length) {
                            return -1
                        }
                        continue
                    }
                    // Add the neighbor to the queue, store its length, and mark
                    // it as visited in the whole graph not just the current component.
                    q.add(nei to length + 1)
                    dist[nei] = length + 1
                    visited[nei] = true
                }
            }

            // The maximum length is the number of groups we can form using the
            // src node as the starting node of traversing.
            return max
        }

        var res = 0
        for (i in 1..n) { // O(V)
            // If the node is visited, we continue to the next one.
            if (visited[i]) {
                continue
            }

            // Mark the node as visited.
            visited[i] = true

            // Get its connected component, because the graph can be disconnected.
            val component = getConnectedComponent(i)

            // Get the maximum groups count we can have in the current component.
            var maxCount = 0
            for (src in component) {
                // Get the length (no of groups) we can have if we traversed the
                // component using the current node as the source.
                val length = getLongestPath(src)

                // If the length is -1, this means we have a cycle with odd length
                // which means we can't split the graph into groups.
                if (length == -1) {
                    return -1
                }

                // Update the maximum number of groups in the current component.
                maxCount = maxOf(maxCount, length)
            }

            // Add the component groups to the result.
            res += maxCount
        }

        return res

        // Note that if the whole graph is connected, we will just loop over the nodes
        // a single iteration, because all of them will be marked as visited. If we have
        // two connected components, then the answer would be the summation of the maximum
        // number of groups for each one of them.
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.magnificentSets(
            6,
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 4),
                intArrayOf(1, 5),
                intArrayOf(2, 6),
                intArrayOf(2, 3),
                intArrayOf(4, 6)
            )
        )
    )

    println(
        sol.magnificentSets(
            3,
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 1)
            )
        )
    )
}