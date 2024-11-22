package problems.FlipColumnsForMaximumNumberOfEqualRows

// https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/

private class Solution {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val counts = mutableMapOf<String, Int>()

        for (row in matrix) {
            var key = row.joinToString("")
            if (key[0] == '1') {
                key = key.map { if (it == '1') '0' else '1' }.joinToString("")
            }

            counts[key] = counts.getOrDefault(key, 0) + 1
        }

        return counts.values.max()
    }
}

fun main() {
    val sol = Solution()
    println(
        sol.maxEqualRowsAfterFlips(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 1)
            )
        )
    )

    println(
        sol.maxEqualRowsAfterFlips(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 0)
            )
        )
    )

    println(
        sol.maxEqualRowsAfterFlips(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 1),
                intArrayOf(1, 1, 0)
            )
        )
    )
}