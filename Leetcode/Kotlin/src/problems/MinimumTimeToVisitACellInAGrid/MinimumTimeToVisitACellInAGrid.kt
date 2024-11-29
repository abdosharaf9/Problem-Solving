package problems.MinimumTimeToVisitACellInAGrid

import java.util.PriorityQueue
import kotlin.math.abs

// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/

private class Solution {
    fun minimumTime(grid: Array<IntArray>): Int {
        // The only case we can't move any further
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1

        val rows = grid.size
        val cols = grid[0].size

        // Using a Min Heap to always choose the minimum time
        // Each item will be (time, row, col)
        val heap = PriorityQueue(compareBy<Triple<Int, Int, Int>> { it.first })
        heap.add(Triple(0, 0, 0))

        // Avoid visiting the same cell again
        val visited = mutableSetOf<Pair<Int, Int>>()

        while (heap.isNotEmpty()) {
            // Get the cell with the minimum time and check if it is the target
            val (t, r, c) = heap.poll()

            if (r == rows - 1 && c == cols - 1) {
                return t
            }

            // If it is not, add its four neighbors to the heap
            val rowDel = listOf(-1, 1, 0, 0)
            val colDel = listOf(0, 0, -1, 1)

            for (i in 0..3) {
                val newRow = r + rowDel[i]
                val newCol = c + colDel[i]

                // Check if we visited that cell before, or it is out of bounds
                if (
                    visited.contains(Pair(newRow, newCol)) ||
                    newRow < 0 || newRow == rows ||
                    newCol < 0 || newCol == cols
                ) {
                    continue
                }

                // Get the new time. We have two cases:
                // 1. Move directly by only adding 1.
                // 2. Needs to go back and forth which will be the new cell time or bigger than it by 1.
                // We will take the maximum of the two cases because the time can't go back.
                val wait = if (abs(grid[newRow][newCol] - t) % 2 == 0) 1 else 0
                val newTime = maxOf(grid[newRow][newCol] + wait, t + 1)

                // Add the cell to the heap and the visited set
                heap.add(Triple(newTime, newRow, newCol))
                visited.add(Pair(newRow, newCol))
            }
        }

        // We won't get here any way
        return -1
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.minimumTime(
            arrayOf(
                intArrayOf(0, 1, 3, 2),
                intArrayOf(5, 1, 2, 5),
                intArrayOf(4, 3, 8, 6)
            )
        )
    )

    println(
        sol.minimumTime(
            arrayOf(
                intArrayOf(0, 2, 4),
                intArrayOf(3, 2, 1),
                intArrayOf(1, 0, 4)
            )
        )
    )
}