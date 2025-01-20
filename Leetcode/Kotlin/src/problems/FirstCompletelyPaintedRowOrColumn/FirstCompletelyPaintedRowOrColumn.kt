package problems.FirstCompletelyPaintedRowOrColumn

// https://leetcode.com/problems/first-completely-painted-row-or-column/

private class Solution {
    // Time: O(m * n), because we will traverse all the cells.
    // Space: O(m * n), because we will store all the cells in the HashMap.
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        // Get grid size.
        val rows = mat.size
        val cols = mat[0].size

        // Map each item to its position to easily get its position when
        // we need it in constant time. The key will be the value in the cell,
        // and the value will be its position (row, col).
        val positions = mutableMapOf<Int, Pair<Int, Int>>()
        for (r in 0..<rows) {
            for (c in 0..<cols) {
                positions[mat[r][c]] = r to c
            }
        }

        // Store the count of painted cells in each row/column
        // to easily verify if the whole row/column is painted.
        val rowsCount = IntArray(rows)
        val colsCount = IntArray(cols)

        for (i in arr.indices) {
            // Get the position of the cell, and increment its
            // row and column count by 1.
            val (r, c) = positions[arr[i]]!!
            rowsCount[r]++
            colsCount[c]++

            // Check if the current row/column is fully painted.
            if (rowsCount[r] == cols || colsCount[c] == rows) {
                return i
            }
        }

        // Won't get here anyway.
        return 0
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.firstCompleteIndex(
            intArrayOf(1, 3, 4, 2),
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 3)
            )
        )
    )

    println(
        sol.firstCompleteIndex(
            intArrayOf(2, 8, 7, 4, 1, 3, 5, 6, 9),
            arrayOf(
                intArrayOf(3, 2, 5),
                intArrayOf(1, 4, 6),
                intArrayOf(8, 7, 9)
            )
        )
    )
}