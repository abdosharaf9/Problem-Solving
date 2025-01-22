package problems.MapOfHighestPeak

import utils.printMatrixLikeMatrix
import java.util.Queue
import java.util.LinkedList

// https://leetcode.com/problems/map-of-highest-peak/

private class Solution {
    // Time: O(m * n)
    // Space: O(m * n)
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        // Get the grid dimensions.
        val rows = isWater.size
        val cols = isWater[0].size

        // Store the cells' positions to run a Multi-Source BFS.
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        // Add water cells to the queue and change their values to 0.
        // Note that land cells are changed to -1 to mark them as unvisited.
        for (r in 0..<rows) {
            for (c in 0..<cols) {
                if (isWater[r][c] == 1) {
                    isWater[r][c] = 0
                    queue.add(r to c)
                } else {
                    isWater[r][c] = -1
                }
            }
        }

        while (queue.isNotEmpty()) {
            // Get the current cell and check its neighbors.
            val (r, c) = queue.poll()
            val neighbors = listOf(r to c - 1, r to c + 1, r - 1 to c, r + 1 to c)

            for ((nr, nc) in neighbors) {
                // If the neighbor is out of bounds, or visited before we continue to the next one.
                if (
                    nr < 0 || nr == rows ||
                    nc < 0 || nc == cols ||
                    isWater[nr][nc] != -1
                ) {
                    continue
                }

                // Assign the neighbor a height higher than the current cell's
                // height by 1 and add it to the queue to explore its neighbors.
                isWater[nr][nc] = isWater[r][c] + 1
                queue.add(nr to nc)
            }
        }

        // The grid after the manipulation.
        return isWater
    }
}

fun main() {
    val sol = Solution()

    printMatrixLikeMatrix(
        sol.highestPeak(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 0)
            )
        )
    )

    printMatrixLikeMatrix(
        sol.highestPeak(
            arrayOf(
                intArrayOf(0, 0, 1),
                intArrayOf(1, 0, 0),
                intArrayOf(0, 0, 0)
            )
        )
    )
}