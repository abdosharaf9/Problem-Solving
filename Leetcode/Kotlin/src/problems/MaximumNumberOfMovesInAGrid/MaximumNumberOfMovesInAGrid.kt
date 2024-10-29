package problems.MaximumNumberOfMovesInAGrid

// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/

private class Solution {
    fun maxMoves(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val cache = mutableMapOf<Pair<Int, Int>, Int>()

        fun countMoves(r: Int, c: Int): Int {
            if (cache.containsKey(Pair(r, c))) return cache[Pair(r, c)]!!

            var maxMovesFromCell = 0
            val directions = listOf(-1 to 1, 0 to 1, 1 to 1)

            for ((dr, dc) in directions) {
                val nr = r + dr
                val nc = c + dc

                if (nr in 0..<rows && nc < cols && grid[nr][nc] > grid[r][c]) {
                    maxMovesFromCell = maxOf(maxMovesFromCell, 1 + countMoves(nr, nc))
                }
            }

            cache[Pair(r, c)] = maxMovesFromCell
            return maxMovesFromCell
        }

        var maxMoves = 0
        for (i in 0..<rows) {
            maxMoves = maxOf(maxMoves, countMoves(i, 0))
        }

        return maxMoves
    }

}

fun main() {
    val sol = Solution()

    println(
        sol.maxMoves(
            arrayOf(
                intArrayOf(2, 4, 3, 5),
                intArrayOf(5, 4, 9, 3),
                intArrayOf(3, 4, 2, 11),
                intArrayOf(10, 9, 13, 15)
            )
        )
    )

    println(
        sol.maxMoves(
            arrayOf(
                intArrayOf(3, 2, 4),
                intArrayOf(2, 1, 9),
                intArrayOf(1, 1, 7)
            )
        )
    )
}