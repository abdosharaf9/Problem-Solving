package problems.MaximumNumberOfFishInAGrid

// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/

private class Solution {
    // Time: O(m * n), because we will loop over all the cells.
    // Space: O(m * n), because we use a 2D array to mark the visited cells.
    fun findMaxFish(grid: Array<IntArray>): Int {
        // Get the grid dimensions.
        val rows = grid.size
        val cols = grid[0].size

        // Mark the visited cells.
        val visited = Array(rows) { BooleanArray(cols) }

        // Use DFS to traverse the cells.
        fun dfs(r: Int, c: Int): Int {
            // If we get out of bounds, visited the cell before, or the
            // cell is land, then return 0 fish.
            if (
                r < 0 || r == rows ||
                c < 0 || c == cols ||
                visited[r][c] ||
                grid[r][c] == 0
            ) {
                return 0
            }

            // Mark the cell as visited and collect the fish in it and its neighbors.
            visited[r][c] = true
            var res = grid[r][c]
            val neighbors = listOf(r to c - 1, r to c + 1, r - 1 to c, r + 1 to c)
            for ((nr, nc) in neighbors) {
                res += dfs(nr, nc)
            }

            // Return the total fishes in the current connected water cells.
            return res
        }

        // Loop over all the cells, and get the fishes counts in all the
        // water connected components and maximize the result.
        var res = 0
        for (r in 0..<rows) {
            for (c in 0..<cols) {
                // If the cell is not visited and have fish.
                if (!visited[r][c] && grid[r][c] > 0) {
                    res = maxOf(res, dfs(r, c))
                }
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.findMaxFish(
            arrayOf(
                intArrayOf(0, 2, 1, 0),
                intArrayOf(4, 0, 0, 3),
                intArrayOf(1, 0, 0, 4),
                intArrayOf(0, 3, 2, 0)
            )
        )
    )

    println(
        sol.findMaxFish(
            arrayOf(
                intArrayOf(1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1)
            )
        )
    )
}