package problems.MinimumFallingPathSum

import kotlin.math.min

// https://leetcode.com/problems/minimum-falling-path-sum/

private class Solution {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        for (row in 1..matrix.lastIndex) {
            for (col in 0..matrix.lastIndex) {
                val left = if (col > 0) matrix[row - 1][col - 1] else Int.MAX_VALUE
                val mid = matrix[row - 1][col]
                val right = if (col < matrix.lastIndex) matrix[row - 1][col + 1] else Int.MAX_VALUE
                matrix[row][col] += minOf(left, mid, right)
            }
        }

        return matrix.last().min()
    }

    /*fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()

        fun dfs(r: Int, c: Int): Int {
            if (r == matrix.size) return 0
            if (c < 0 || c == matrix.size) return Int.MAX_VALUE
            if (cache.containsKey(Pair(r, c))) return cache[Pair(r, c)]!!

            val res = matrix[r][c] + minOf(
                dfs(r + 1, c - 1),
                dfs(r + 1, c),
                dfs(r + 1, c + 1),
            )

            cache[Pair(r, c)] = res
            return res
        }

        var res = Int.MAX_VALUE
        for (col in 0..matrix.lastIndex) {
            res = min(res, dfs(0, col))
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(
        sol.minFallingPathSum(
            arrayOf(
                intArrayOf(2, 1, 3),
                intArrayOf(6, 5, 4),
                intArrayOf(7, 8, 9)
            )
        )
    )

    println(
        sol.minFallingPathSum(
            arrayOf(
                intArrayOf(-19, 57),
                intArrayOf(-40, -5)
            )
        )
    )
}