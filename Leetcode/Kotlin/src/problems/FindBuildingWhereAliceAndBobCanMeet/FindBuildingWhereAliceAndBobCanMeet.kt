package problems.FindBuildingWhereAliceAndBobCanMeet

import utils.printArray
import java.util.PriorityQueue

// https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/

private class Solution {
    // Time: O(n + q * log q)
    // Space: O(q), which is the maximum size the heap can store.
    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        // Stores the answers of each query.
        val ans = IntArray(queries.size) { -1 }

        // r -> [(h, i)]
        // Each query is represented as a pair (h, i) which means the maximum height
        // of the query bounds (l, r), and its  original index at the queries array.
        // Here we store a list of these pairs for each index (r) in the heights array,
        // which means these pairs are queries that ends at this index.
        val groups = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        for ((i, q) in queries.withIndex()) {
            // Always the left pointer smaller than the right pointer.
            val (l, r) = q.sorted()

            // If they are at the same building or the second building is
            // higher than the first one, they will meet at the second one.
            if (l == r || heights[r] > heights[l]) {
                ans[i] = r
            } else {
                // If not, we will store the pair of this query in the map.
                val mx = maxOf(heights[l], heights[r])
                groups.computeIfAbsent(r) { mutableListOf() }.add(mx to i)
            }
        }

        // This Min Heap is used to always pick the smallest-height query pair.
        val heap = PriorityQueue(compareBy<Pair<Int, Int>> { it.first })

        // Loop over each height and see if it can answer any pairs in the heap.
        for ((i, h) in heights.withIndex()) {
            // Add the list of pairs that is mapped to the current index.
            heap.addAll(groups.getOrDefault(i, emptyList()))

            // Pop all the pairs we can answer with the current height.
            while (heap.isNotEmpty() && h > heap.peek().first) {
                val (_, qi) = heap.poll()
                ans[qi] = i
            }
        }

        return ans
    }

    // Time: O(q * n), and it gives a TLE
    // Space: O(1)
    /*fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        // Stores the answers of each query.
        val ans = IntArray(queries.size) { -1 }

        for ((i, q) in queries.withIndex()) {
            // Always the left pointer smaller than the right pointer.
            val (l, r) = q.sorted()

            // If they are at the same building or the second building is
            // higher than the first one, they will meet at the second one.
            if (l == r || heights[r] > heights[l]) {
                ans[i] = r
                continue
            }

            // If not, find the next greater high after the right pointer.
            val mx = maxOf(heights[l], heights[r])
            for (j in r + 1..heights.lastIndex) {
                if (heights[j] > mx) {
                    ans[i] = j
                    break
                }
            }
        }

        return ans
    }*/
}

fun main() {
    val sol = Solution()

    printArray(
        sol.leftmostBuildingQueries(
            intArrayOf(6, 4, 8, 5, 2, 7),
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 3),
                intArrayOf(2, 4),
                intArrayOf(3, 4),
                intArrayOf(2, 2)
            )
        )
    )

    printArray(
        sol.leftmostBuildingQueries(
            intArrayOf(5, 3, 8, 2, 6, 1, 4, 6),
            arrayOf(
                intArrayOf(0, 7),
                intArrayOf(3, 5),
                intArrayOf(5, 2),
                intArrayOf(3, 0),
                intArrayOf(1, 6)
            )
        )
    )
}