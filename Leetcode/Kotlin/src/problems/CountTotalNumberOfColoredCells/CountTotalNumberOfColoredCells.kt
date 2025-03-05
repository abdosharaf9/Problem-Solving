package problems.CountTotalNumberOfColoredCells

import kotlin.math.pow

// https://leetcode.com/problems/count-total-number-of-colored-cells/

private class Solution {
    // The pattern we follow is: 1, 5, 13, 25,...etc. Which is:
    // (4 * 0), (4 * 0 + 4 * 1), (4 * 0 + 4 * 1 + 4 * 2), (4 * 0 + 4 * 1 + 4 * 2 + 4 * 3), ...etc.
    // This pattern can be formatted as: 1 + 4 * (1 + 2 + 3 + ... n-1).
    // Note that the part multiplied by 4 is the sum of the numbers between 1 and n-1, which can
    // be calculated using the Gauss series law as: (n - 1) * (n / 2).
    // Thus, the final formula will be: 1 + 4 * (n - 1) * (n / 2) or 1 + 2 * (n - 1) * n.
    // All the solutions just follow this pattern to calculate the result according to n.

    // Time: O(1)
    // Space: O(1)
    fun coloredCells(n: Int): Long {
        // Use the formula after simplified as: 2n^2 + 2n + 1
        val p = (n.toDouble().pow(2)).toLong()
        return (2 * p) - (2 * n) + 1

        // Use the formula 1 + 4 * (n - 1) * (n / 2)
        // return 1 + 4 * (n.toLong() - 1) * n / 2

        // Use the formula 1 + 2 * (n - 1) * n
        // return 1 + 2 * (n.toLong() - 1) * n
    }

    // Time: O(n)
    // Space: O(1)
    /*fun coloredCells(n: Int): Long {
        // Use a loop to calculate the series.
        var res = 1L
        for (i in 0..<n) {
            res += (4 * i)
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.coloredCells(1))
    println(sol.coloredCells(2))
}