package problems.RotateImage

import utils.printMatrixLikeArray

// https://leetcode.com/problems/rotate-image/

private class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        println("Before: ")
        printMatrixLikeArray(matrix)

        for (i in 0..<n) {
            for (j in i + 1..<n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        for (i in 0..<n) {
            var left = 0
            var right = n - 1

            while (left < right) {
                val temp = matrix[i][left]
                matrix[i][left] = matrix[i][right]
                matrix[i][right] = temp

                left++
                right--
            }
        }

        println("After: ")
        printMatrixLikeArray(matrix)
    }
}

fun main() {
    val sol = Solution()
    sol.rotate(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    )

    sol.rotate(
        arrayOf(
            intArrayOf(5, 1, 9, 11),
            intArrayOf(2, 4, 8, 10),
            intArrayOf(13, 3, 6, 7),
            intArrayOf(15, 14, 12, 16)
        )
    )
}