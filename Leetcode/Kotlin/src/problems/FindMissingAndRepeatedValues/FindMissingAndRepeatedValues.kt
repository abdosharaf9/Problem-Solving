package problems.FindMissingAndRepeatedValues

import utils.printArray

// https://leetcode.com/problems/find-missing-and-repeated-values/

private class Solution {
    // Time: O(n^2)
    // Space: O(n^2)
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        // Store the frequency of each number.
        val n = grid.size
        val freq = IntArray(n * n + 1)

        for (i in 0..<n) {
            for (j in 0..<n) {
                freq[grid[i][j]]++
            }
        }

        // Loop over the frequencies to get both the numbers.
        var a = 0
        var b = 0
        for (i in 1..n * n) {
            when (freq[i]) {
                2 -> a = i
                0 -> b = i
            }
        }

        return intArrayOf(a, b)
    }

    // Time: O(n^2)
    // Space: O(n^2)
    /*fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        // Store if a number appeared in the grid or not.
        val appear = BooleanArray(grid.size * grid.size + 1)
        val res = IntArray(2)

        // Loop over the grid.
        for (list in grid) {
            for (n in list) {
                // If the current number already shown before, take it in the result.
                if (appear[n]) {
                    res[0] = n
                }
                // Mark the current number as shown.
                appear[n] = true
            }
        }

        // Loop over the appeared list to get the second number.
        for (i in 1..appear.lastIndex) {
            if (!appear[i]) {
                res[1] = i
                break
            }
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()

    printArray(
        sol.findMissingAndRepeatedValues(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 2)
            )
        )
    )

    printArray(
        sol.findMissingAndRepeatedValues(
            arrayOf(
                intArrayOf(9, 1, 7),
                intArrayOf(8, 9, 2),
                intArrayOf(3, 4, 6)
            )
        )
    )
}