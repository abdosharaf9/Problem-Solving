package problems.MakingALargeIsland

// https://leetcode.com/problems/making-a-large-island/

private class Solution {
    fun largestIsland(grid: Array<IntArray>): Int {
        val n = grid.size

        fun outOfBounds(r: Int, c: Int): Boolean {
            return (
                    r < 0 || r == n ||
                            c < 0 || c == n
                    )
        }

        fun dfs(r: Int, c: Int, label: Int): Int {
            if (
                outOfBounds(r, c) ||
                grid[r][c] != 1
            ) {
                return 0
            }

            grid[r][c] = label
            var size = 1

            val neighbors = listOf(r - 1 to c, r + 1 to c, r to c - 1, r to c + 1)
            for ((nr, nc) in neighbors) {
                size += dfs(nr, nc, label)
            }

            return size
        }

        var label = 2
        val area = mutableMapOf<Int, Int>()
        for (r in 0..<n) {
            for (c in 0..<n) {
                if (grid[r][c] == 1) {
                    area[label] = dfs(r, c, label)
                    label++
                }
            }
        }

        fun connect(r: Int, c: Int): Int {
            var size = 1
            val visited = mutableSetOf<Int>()
            val neighbors = listOf(r - 1 to c, r + 1 to c, r to c - 1, r to c + 1)
            for ((nr, nc) in neighbors) {
                if (
                    !outOfBounds(nr, nc) &&
                    grid[nr][nc] !in visited
                ) {
                    size += area[grid[nr][nc]] ?: 0
                    visited.add(grid[nr][nc])
                }
            }

            return size
        }

        var res = if (area.isEmpty()) 0 else area.values.max()
        for (r in 0..<n) {
            for (c in 0..<n) {
                if (grid[r][c] == 0) {
                    res = maxOf(res, connect(r, c))
                }
            }
        }

        return res
    }
}