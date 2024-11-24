package problems.MaximumMatrixSum

import kotlin.math.abs

// https://leetcode.com/problems/maximum-matrix-sum/

private class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var sum = 0L
        var smallest = Int.MAX_VALUE
        var negative = 0

        for (row in matrix) {
            for (n in row) {
                sum += abs(n)
                smallest = minOf(smallest, abs(n))
                if (n < 0) negative++
            }
        }

        return if (negative % 2 == 0) sum
        else sum - (2 * smallest)
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.maxMatrixSum(
            arrayOf(
                intArrayOf(1, -1),
                intArrayOf(-1, 1)
            )
        )
    )

    println(
        sol.maxMatrixSum(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(-1, -2, -3),
                intArrayOf(1, 2, 3)
            )
        )
    )
}