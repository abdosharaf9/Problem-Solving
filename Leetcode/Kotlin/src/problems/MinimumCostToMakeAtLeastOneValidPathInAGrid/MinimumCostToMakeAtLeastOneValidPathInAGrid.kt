package problems.MinimumCostToMakeAtLeastOneValidPathInAGrid

import java.util.Deque
import java.util.LinkedList

// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/

private class Solution {
    // Time: O(m * n), because we will visit all the grid cells.
    // Space: O(m * n), because the queue will store all the grid cells.
    // Use BFS to Visit all the cells and see what is the minimum cost we
    // can use to get to each one of them until we reach the last one.
    fun minCost(grid: Array<IntArray>): Int {
        // Store the directions with the change in the
        // row/column for each one to use them easily.
        val directions = mapOf(
            1 to Pair(0, 1),
            2 to Pair(0, -1),
            3 to Pair(1, 0),
            4 to Pair(-1, 0),
        )

        // Get the number of rows and columns.
        val rows = grid.size
        val cols = grid[0].size

        // Used a Deque because we need to store the values in a monotonic order,
        // so we will push the values in both directions. Each value will be a Triple
        // that represents: (row, column, cost).
        val queue: Deque<Triple<Int, Int, Int>> = LinkedList(listOf(Triple(0, 0, 0)))

        // Store the minimum cost we can use to reach each cell to avoid visiting
        // it again using a bigger cost. The key will be a Pair that represents
        // (row, column), and the value will be the used cost.
        val minCostMap = mutableMapOf<Pair<Int, Int>, Int>(Pair(0, 0) to 0)

        while (queue.isNotEmpty()) {
            // Get the cell with the minimum cost.
            val (r, c, cost) = queue.pop()

            // If we reached the last cell, return its cost.
            if (r == rows - 1 && c == cols - 1) {
                return cost
            }

            // Add the four neighbors to the queue.
            for (d in directions) {
                // Get the row and column of the neighbor.
                val (dr, dc) = d.value
                val newRow = r + dr
                val newCol = c + dc

                // Calculate the cost we will use to reach that neighbor.
                val newCost = if (grid[r][c] == d.key) cost else cost + 1

                // If we get out of grid bounds, or that neighbor is visited before
                // with a cost minimum than the new one, we will avoid visiting it.
                if (
                    newRow < 0 || newRow == rows ||
                    newCol < 0 || newCol == cols ||
                    newCost >= (minCostMap[newRow to newCol] ?: Int.MAX_VALUE)
                ) {
                    continue
                }

                // If the new cost is the same as the old one, add the neighbor
                // in the front because it will be the minimum cost. If not, this
                // means it will be bigger and must be added to the tail.
                if (newCost == cost) {
                    queue.addFirst(Triple(newRow, newCol, newCost))
                } else {
                    queue.addLast(Triple(newRow, newCol, newCost))
                }

                // Store the used minimum cost in the map.
                minCostMap[newRow to newCol] = newCost
            }
        }

        // We won't get here anyway.
        return 0
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.minCost(
            arrayOf(
                intArrayOf(1, 1, 1, 1),
                intArrayOf(2, 2, 2, 2),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(2, 2, 2, 2)
            )
        )
    )

    println(
        sol.minCost(
            arrayOf(
                intArrayOf(1, 1, 3),
                intArrayOf(3, 2, 2),
                intArrayOf(1, 1, 4)
            )
        )
    )

    println(
        sol.minCost(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(4, 3)
            )
        )
    )
}