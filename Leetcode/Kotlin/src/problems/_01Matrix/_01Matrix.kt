package problems._01Matrix

import utils.printMatrixLikeMatrix
import java.util.Queue
import java.util.LinkedList

// https://leetcode.com/problems/01-matrix/

private class Solution {
    // Dynamic Programming
    // Time: O(m * n)
    // Space: O(1)
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        // Get the matrix dimensions.
        val rows = mat.size
        val cols = mat[0].size

        // The maximum distance we can have.
        val inf = rows * cols

        // Loop over the cells from left to right and top to down.
        for (r in 0..<rows) {
            for (c in 0..<cols) {
                // If the cell is already 0, it won't be changed.
                if (mat[r][c] == 0) {
                    continue
                }

                // Get the value of the top and left cells if they exist or use the maximum value.
                val top = if (r > 0) mat[r - 1][c] else inf
                val left = if (c > 0) mat[r][c - 1] else inf

                // Use the minimum distance of them and add 1 to it.
                mat[r][c] = minOf(top, left) + 1
            }
        }

        // Loop over the cells from right to left and bottom to up.
        for (r in rows - 1 downTo 0) {
            for (c in cols - 1 downTo 0) {
                // If the cell is already 0, it won't be changed.
                if (mat[r][c] == 0) {
                    continue
                }

                // Get the value of the bottom and right cells if they exist or use the maximum value.
                val bottom = if (r < rows - 1) mat[r + 1][c] else inf
                val right = if (c < cols - 1) mat[r][c + 1] else inf

                // Use the minimum distance of them and add 1 to it, or us the distance we
                // assigned in the previous loop if it is smaller.
                mat[r][c] = minOf(mat[r][c], minOf(bottom, right) + 1)
            }
        }

        // The matrix after the manipulation.
        return mat
    }

    // Multi-Source BFS
    // Time: O(m * n)
    // Space: O(m * n)
    /*fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        // Get the matrix dimensions.
        val rows = mat.size
        val cols = mat[0].size

        // Store the cells' positions to run a Multi-Source BFS.
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        // Add zero cells to the queue to process them first. Note that
        // other cells are changed to -1 to mark them as unvisited.
        for (r in 0..<rows) {
            for (c in 0..<cols) {
                if (mat[r][c] == 0) {
                    queue.add(r to c)
                } else {
                    mat[r][c] = -1
                }
            }
        }

        while (queue.isNotEmpty()) {
            // Get the current cell and check its neighbors.
            val (r, c) = queue.poll()
            val neighbors = listOf(r - 1 to c, r + 1 to c, r to c - 1, r to c + 1)

            for ((nr, nc) in neighbors) {
                // If the neighbor is out of bounds, or visited before we continue to the next one.
                if (
                    nr < 0 || nr == rows ||
                    nc < 0 || nc == cols ||
                    mat[nr][nc] != -1
                ) {
                    continue
                }

                // Assign the neighbor a distance higher than the current cell's
                // distance by 1 and add it to the queue to explore its neighbors.
                mat[nr][nc] = mat[r][c] + 1
                queue.add(nr to nc)
            }
        }

        // The matrix after the manipulation.
        return mat
    }*/
}

fun main() {
    val sol = Solution()

    printMatrixLikeMatrix(
        sol.updateMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)
            )
        )
    )

    printMatrixLikeMatrix(
        sol.updateMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 1, 1)
            )
        )
    )
}