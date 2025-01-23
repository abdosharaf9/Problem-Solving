package problems.CountServersThatCommunicate

// https://leetcode.com/problems/count-servers-that-communicate

private class Solution {
    // Time: O(m * n)
    // Space: O(m + n)
    fun countServers(grid: Array<IntArray>): Int {
        // Get the grid size.
        val rows = grid.size
        val cols = grid[0].size

        // Count servers in each row and column.
        val rowCounts = IntArray(rows)
        val colCounts = IntArray(cols)
        for (r in 0..<rows) {
            for (c in 0..<cols) {
                if (grid[r][c] == 1) {
                    rowCounts[r]++
                    colCounts[c]++
                }
            }
        }

        var res = 0

        // Check if the current row/column has at least another server to
        // consider the current one in the count.
        for (r in 0..<rows) {
            for (c in 0..<cols) {
                if (
                    grid[r][c] == 1 &&
                    (rowCounts[r] > 1 || colCounts[c] > 1)
                ) {
                    res++
                }
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.countServers(
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 1)
            )
        )
    )

    println(
        sol.countServers(
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 1)
            )
        )
    )

    println(
        sol.countServers(
            arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(0, 0, 1, 0),
                intArrayOf(0, 0, 1, 0),
                intArrayOf(0, 0, 0, 1)
            )
        )
    )
}