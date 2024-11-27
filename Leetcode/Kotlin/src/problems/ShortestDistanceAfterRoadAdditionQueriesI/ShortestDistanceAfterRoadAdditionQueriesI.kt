package problems.ShortestDistanceAfterRoadAdditionQueriesI

import utils.printArray
import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/

private class Solution {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        // Each node will have a list of the nodes it can go to using a single step
        val roads = Array(n - 1) { mutableListOf(it + 1) }

        // Run a BFS algorithm to try all the possible ways
        fun getMinimum(): Int {
            // Save the node and the steps to reach it
            val q: Queue<Pair<Int, Int>> = LinkedList()
            q.add(Pair(0, 0))

            // To avoid visiting the same node again
            val visited = mutableSetOf(0)

            while (q.isNotEmpty()) {
                val (dst, len) = q.poll()

                // Return the steps if we arrived at the final one
                if (dst == n - 1) return len

                // If not found, add the possible ways to try them
                for (node in roads[dst]) {
                    if (!visited.contains(node)) {
                        q.add(Pair(node, len + 1))
                        visited.add(node)
                    }
                }
            }

            return 0
        }

        // Build the answer array by getting the steps after applying each query
        val ans = IntArray(queries.size)
        queries.forEachIndexed { i, (from, to) ->
            roads[from].add(to)
            ans[i] = getMinimum()
        }

        return ans
    }

    // TLE because there is no visited set not the Map
    /*fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val ans = IntArray(queries.size)
        val roads = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0..<n - 1) {
            roads[i] = mutableListOf(i + 1)
        }

        fun getMinimum(): Int {
            val q: Queue<Pair<Int, Int>> = LinkedList()
            q.add(Pair(0, 0))

            while (q.isNotEmpty()) {
                val (dst, len) = q.poll()
                if (dst == n - 1) return len

                for (node in roads[dst]!!) {
                    q.add(Pair(node, len + 1))
                }
            }

            return 0
        }

        queries.forEachIndexed { i, (from, to) ->
            roads[from]!!.add(to)
            ans[i] = getMinimum()
        }

        return ans
    }*/

    // TLE because of the recursion
    /*fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val ans = IntArray(queries.size)
        val roads = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0..<n - 1) {
            roads[i] = mutableListOf(i + 1)
        }

        fun getMinimum(x: Int): Int {
            if (x == n - 1) return 0

            var len = Int.MAX_VALUE

            for (dst in roads[x]!!) {
                len = minOf(len, 1 + getMinimum(dst))
            }

            return len
        }

        queries.forEachIndexed { i, (from, to) ->
            roads[from]!!.add(to)
            ans[i] = getMinimum(0)
        }

        return ans
    }*/
}

fun main() {
    val sol = Solution()

    printArray(
        sol.shortestDistanceAfterQueries(
            5,
            arrayOf(
                intArrayOf(2, 4),
                intArrayOf(0, 2),
                intArrayOf(0, 4)
            )
        )
    )

    printArray(
        sol.shortestDistanceAfterQueries(
            4,
            arrayOf(
                intArrayOf(0, 3),
                intArrayOf(0, 2)
            )
        )
    )
}