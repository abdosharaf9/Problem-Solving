package problems.MakingALargeIsland

// https://leetcode.com/problems/making-a-large-island/

private class Solution {
    // Time: O(n^2)
    // Space: O(n^2)
    fun largestIsland(grid: Array<IntArray>): Int {
        // Get the grid size.
        val n = grid.size

        // Check if we get out of bounds.
        fun outOfBounds(r: Int, c: Int): Boolean {
            return r < 0 || r == n || c < 0 || c == n
        }

        // Use DFS to traverse all connected 1's that form an island and compute its area.
        fun dfs(r: Int, c: Int, label: Int): Int {
            // If we get out of bounds, or we traversed this cell before, or it is a water
            // cell, return 0 as the area because there is no island.
            if (
                outOfBounds(r, c) ||
                grid[r][c] != 1
            ) {
                return 0
            }

            // Change the value of the cell to its label (ID) to know to which island this
            // cell belongs, and also we can use it as a marker for the visited cells.
            grid[r][c] = label

            // The initial area of the island is 1 that is the current cell.
            var islandArea = 1

            // Traverse the four neighbors to get the whole island area.
            val neighbors = listOf(r - 1 to c, r + 1 to c, r to c - 1, r to c + 1)
            for ((nr, nc) in neighbors) {
                // Add the area of neighbor's island to the current one.
                islandArea += dfs(nr, nc, label)
            }

            // Return the island area.
            return islandArea
        }

        // Start the labels (IDs) with 2, because 0 and 1 are used in the input.
        var label = 2

        // Map each island label to its area, and store the maximum area.
        val areaMap = mutableMapOf<Int, Int>()
        var maxArea = 0

        // Loop over all the grid and compute all the islands' areas.
        for (r in 0..<n) { // O(n^2)
            for (c in 0..<n) {
                // If the current cell isn't a water cell, or it isn't marked as visited.
                if (grid[r][c] == 1) {
                    // Get the island area, store it, and update the maximum area according to it.
                    val islandArea = dfs(r, c, label)
                    areaMap[label] = islandArea
                    maxArea = maxOf(maxArea, islandArea)

                    // Update the label.
                    label++
                }
            }
        }

        // Used to get the island area that contains the current cell after flipping it from 0 to 1
        fun connect(r: Int, c: Int): Int { // O(1)
            // At least the current cell will be considered in the area.
            var area = 1

            // Store the visited islands' IDs to make sure we won't visit them again.
            val visited = mutableSetOf<Int>()

            // Loop over the four neighbors to get the island area of each one.
            val neighbors = listOf(r - 1 to c, r + 1 to c, r to c - 1, r to c + 1)
            for ((nr, nc) in neighbors) {
                // If we don't get out of bounds and didn't see this island ID before,
                // then add its area to the result and mark it as visited.
                if (
                    !outOfBounds(nr, nc) &&
                    grid[nr][nc] !in visited
                ) {
                    // The default area is 0.
                    area += areaMap[grid[nr][nc]] ?: 0
                    visited.add(grid[nr][nc])
                }
            }

            return area
        }

        // Loop over all the cells and if we found a 0, get the new area after
        // flipping it, then update the maximum area
        for (r in 0..<n) { // O(n^2)
            for (c in 0..<n) {
                if (grid[r][c] == 0) {
                    maxArea = maxOf(maxArea, connect(r, c))
                }
            }
        }

        return maxArea
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.largestIsland(
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 1)
            )
        )
    )

    println(
        sol.largestIsland(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 0)
            )
        )
    )

    println(
        sol.largestIsland(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 1)
            )
        )
    )
}