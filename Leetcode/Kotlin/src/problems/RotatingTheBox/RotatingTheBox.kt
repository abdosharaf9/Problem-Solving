package problems.RotatingTheBox

import utils.printMatrixLikeMatrix

// https://leetcode.com/problems/rotating-the-box/

private class Solution {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        val rows = box.size
        val cols = box[0].size

        for (r in 0..<rows) {
            var i = cols - 1
            for (c in cols - 1 downTo 0) {
                if (box[r][c] == '#') {
                    val temp = box[r][c]
                    box[r][c] = box[r][i]
                    box[r][i] = temp
                    i--
                } else if (box[r][c] == '*') {
                    i = c - 1
                }
            }
        }

        val res = Array(cols) { CharArray(rows) }
        for (row in 0..<rows) {
            for (col in 0..<cols) {
                res[col][rows - 1 - row] = box[row][col]
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()

    printMatrixLikeMatrix(
        sol.rotateTheBox(
            arrayOf(
                charArrayOf('#', '.', '#')
            )
        )
    )

    printMatrixLikeMatrix(
        sol.rotateTheBox(
            arrayOf(
                charArrayOf('#', '.', '*', '.'),
                charArrayOf('#', '#', '*', '.')
            )
        )
    )

    printMatrixLikeMatrix(
        sol.rotateTheBox(
            arrayOf(
                charArrayOf('#', '#', '*', '.', '*', '.'),
                charArrayOf('#', '#', '#', '*', '.', '.'),
                charArrayOf('#', '#', '#', '.', '#', '.')
            )
        )
    )
}