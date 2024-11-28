package problems.MinimumObstacleRemovalToReachCorner

import java.util.Deque
import java.util.LinkedList
import java.util.PriorityQueue

// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/

private class Solution {
    // This solution is more optimal because we are using a deque instead of the heap and this will decrease the
    // time complexity because there is no time needed for adding and deleting here.
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        // Using a Deque to always choose the minimum obstacles
        // Each item will be (obstacles, row, col)
        val deque: Deque<Triple<Int, Int, Int>> = LinkedList()
        deque.add(Triple(0, 0, 0))

        // Avoid visiting the same cell again
        val visited = mutableSetOf(Pair(0, 0))

        while (deque.isNotEmpty()) {
            // Get the cell with the minimum obstacles and check if it is the target
            val (obs, row, col) = deque.pollFirst()

            if (row == rows - 1 && col == cols - 1) {
                return obs
            }

            // If it is not, add its four neighbors to the heap
            val rowDel = listOf(-1, 1, 0, 0)
            val colDel = listOf(0, 0, -1, 1)

            for (i in 0..3) {
                val newRow = row + rowDel[i]
                val newCol = col + colDel[i]

                // Check if we visited that cell before, or it is out of bounds
                if (
                    visited.contains(Pair(newRow, newCol)) ||
                    newRow < 0 || newRow == rows ||
                    newCol < 0 || newCol == cols
                ) {
                    continue
                }

                // Add the cell to the deque and the visited set.
                // Note that we add the cells with bigger obstacles at the queue end,
                // and those with the same obstacles to the front. This will allow us
                // to always pick the cells with the minimum obstacles easily.
                if (grid[newRow][newCol] == 1) {
                    deque.addLast(Triple(obs + 1, newRow, newCol))
                } else {
                    deque.addFirst(Triple(obs, newRow, newCol))
                }

                visited.add(Pair(newRow, newCol))
            }
        }

        return -1
    }

    /*fun minimumObstacles(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        // Using a Min Heap to always choose the minimum obstacles
        // Each item will be (obstacles, row, col)
        val heap = PriorityQueue(compareBy<Triple<Int, Int, Int>> { it.first })
        heap.add(Triple(0, 0, 0))

        // Avoid visiting the same cell again
        val visited = mutableSetOf(Pair(0, 0))

        while (heap.isNotEmpty()) {
            // Get the cell with the minimum obstacles and check if it is the target
            val (obs, row, col) = heap.poll()

            if (row == rows - 1 && col == cols - 1) {
                return obs
            }

            // If it is not, add its four neighbors to the heap
            val rowDel = listOf(-1, 1, 0, 0)
            val colDel = listOf(0, 0, -1, 1)

            for (i in 0..3) {
                val newRow = row + rowDel[i]
                val newCol = col + colDel[i]

                // Check if we visited that cell before, or it is out of bounds
                if (
                    visited.contains(Pair(newRow, newCol)) ||
                    newRow < 0 || newRow == rows ||
                    newCol < 0 || newCol == cols
                ) {
                    continue
                }

                // Add the cell to the heap and the visited set
                heap.add(Triple(obs + grid[newRow][newCol], newRow, newCol))
                visited.add(Pair(newRow, newCol))
            }
        }

        // We won't get here any way
        return -1
    }*/
}

fun main() {
    val sol = Solution()

    println(
        sol.minimumObstacles(
            arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0)
            )
        )
    )

    println(
        sol.minimumObstacles(
            arrayOf(
                intArrayOf(0, 1, 0, 0, 0),
                intArrayOf(0, 1, 0, 1, 0),
                intArrayOf(0, 0, 0, 1, 0)
            )
        )
    )
}