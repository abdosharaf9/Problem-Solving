package problems.CountSquareSubmatricesWithAllOnes

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

private class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        val rows = matrix.size
        val cols = matrix[0].size
        val dp = Array(rows + 1) { IntArray(cols + 1) }
        var result = 0

        for (row in 0..<rows) {
            for (col in 0..<cols) {
                if (matrix[row][col] == 1) {
                    dp[row + 1][col + 1] = 1 + minOf(
                        dp[row][col + 1],
                        dp[row + 1][col],
                        dp[row][col]
                    )

                    result += dp[row + 1][col + 1]
                }
            }
        }

        return result
    }

    /*fun countSquares(matrix: Array<IntArray>): Int {
        val rows = matrix.size
        val cols = matrix[0].size
        val cache = mutableMapOf<Pair<Int, Int>, Int>()

        fun dfs(row: Int, col: Int): Int {
            if (row == rows || col == cols || matrix[row][col] == 0) return 0
            if (cache.containsKey(Pair(row, col))) return cache[Pair(row, col)]!!

            cache[Pair(row, col)] = 1 + minOf(
                dfs(row, col + 1),
                dfs(row + 1, col),
                dfs(row + 1, col + 1)
            )

            return cache[Pair(row, col)]!!
        }

        var result = 0
        for (row in matrix.indices) {
            for (col in matrix[0].indices) {
                result += dfs(row, col)
            }
        }

        return result
    }*/
}

fun main() {
    val sol = Solution()

    println(
        sol.countSquares(
            arrayOf(
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(0, 1, 1, 1)
            )
        )
    )

    println(
        sol.countSquares(
            arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0)
            )
        )
    )
}