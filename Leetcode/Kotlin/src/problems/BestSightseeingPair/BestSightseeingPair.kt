package problems.BestSightseeingPair

import java.util.PriorityQueue

// https://leetcode.com/problems/best-sightseeing-pair/

private class Solution {
    // We can use this formula "(values[i] + i) + (values[j] - j)"
    // instead of "values[i] + values[j] + i - j" to make the calculation
    // much easier.

    // The optimal solution by just keeping the maximum value of (values[i] + i).
    // Time: O(n)
    // Space: O(1)
    fun maxScoreSightseeingPair(values: IntArray): Int {
        var score = Int.MIN_VALUE

        // Sort the values of (values[i] + i) in descending order to pick
        // the maximum one each time.
        var max = values[0] // i = 0

        for (i in 1..values.lastIndex) {
            // Maximize the score and add update the maximum value.
            score = maxOf(score, max + values[i] - i)
            max = maxOf(max, values[i] + i)
        }

        return score
    }

    // More optimized solution using Maximum heap.
    // Time: O(n * log n)
    // Space: O(n), because the heap stores all the values.
    /*fun maxScoreSightseeingPair(values: IntArray): Int {
        var score = Int.MIN_VALUE

        // Sort the values of (values[i] + i) in descending order to pick
        // the maximum one each time.
        val heap = PriorityQueue(compareByDescending<Int> { it })
        heap.add(values[0]) // i = 0

        for (i in 1..values.lastIndex) {
            // Maximize the score and add the current value to the heap.
            score = maxOf(score, heap.peek() + values[i] - i)
            heap.add(values[i] + i)
        }

        return score
    }*/

    // Brute force solution that works but not very efficient.
    // Time: O(n^2)
    // Space: O(1)
    /*fun maxScoreSightseeingPair(values: IntArray): Int {
        var score = Int.MIN_VALUE

        // Loop over all pairs in the array and maximize the score.
        for (i in values.indices) {
            for (j in i + 1..values.lastIndex) {
                score = maxOf(score, values[i] + i + values[j] - j)
            }
        }

        return score
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.maxScoreSightseeingPair(intArrayOf(8, 1, 5, 2, 6)))
    println(sol.maxScoreSightseeingPair(intArrayOf(1, 2)))
}