package problems.DivideIntervalsIntoMinimumNumberOfGroups

import kotlin.math.max

// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/

private class Solution {
    fun minGroups(intervals: Array<IntArray>): Int {
        val starts = IntArray(intervals.size) { i -> intervals[i][0] }.sorted()
        val ends = IntArray(intervals.size) { i -> intervals[i][1] }.sorted()

        var i = 0
        var j = 0
        var result = 0

        while (i < intervals.size) {
            if (starts[i] <= ends[j]) i++
            else j++
            result = max(result, i - j)
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    println(
        sol.minGroups(
            arrayOf(intArrayOf(5, 10), intArrayOf(6, 8), intArrayOf(1, 5), intArrayOf(2, 3), intArrayOf(1, 10))
        )
    )
    println(sol.minGroups(arrayOf(intArrayOf(1, 3), intArrayOf(5, 6), intArrayOf(8, 10), intArrayOf(11, 13))))
    println(sol.minGroups(arrayOf(intArrayOf(159431, 428743), intArrayOf(614908, 651142), intArrayOf(431031, 806494))))
}