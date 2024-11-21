package problems.CountUnguardedCellsInTheGrid

// https://leetcode.com/problems/count-unguarded-cells-in-the-grid/

private class Solution {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        // 0 -> unguarded, 1 -> guard, 2 -> wall, 3 -> guarded
        val matrix = Array(m) { IntArray(n) { 0 } }

        // Add guards
        for ((r, c) in guards) {
            matrix[r][c] = 1
        }

        // Add walls
        for ((r, c) in walls) {
            matrix[r][c] = 2
        }

        fun markGuarded(row: Int, col: Int) {
            // Guard all the cells to the top
            for (r in row - 1 downTo 0) {
                if (matrix[r][col] == 1 || matrix[r][col] == 2) break
                matrix[r][col] = 3
            }

            // Guard all the cells to the bottom
            for (r in row + 1..<m) {
                if (matrix[r][col] == 1 || matrix[r][col] == 2) break
                matrix[r][col] = 3
            }

            // Guard all the cells to the left
            for (c in col - 1 downTo 0) {
                if (matrix[row][c] == 1 || matrix[row][c] == 2) break
                matrix[row][c] = 3
            }

            // Guard all the cells to the right
            for (c in col + 1..<n) {
                if (matrix[row][c] == 1 || matrix[row][c] == 2) break
                matrix[row][c] = 3
            }
        }

        // Add guarded
        for ((r, c) in guards) {
            markGuarded(r, c)
        }

        // Count unguarded
        var res = 0
        for (row in matrix) {
            for (x in row) {
                if (x == 0) res++
            }
        }

        return res
    }

    // TLE & Wrong answer in some cases
    /*fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        var res = m * n - walls.size
        val wallsMap = mutableMapOf<Pair<Int, Int>, Boolean>()
        val visited = mutableMapOf<Pair<Int, Int>, Boolean>()

        // Add walls to block the guards
        for ((row, col) in walls) {
            wallsMap[Pair(row, col)] = true
        }

        // If the cell is guarded, the result will be decreased to count only the unguarded
        for ((row, col) in guards) {
            // Guard all the cells to the top
            for (r in row downTo 0) {
                if (wallsMap[Pair(r, col)] == true) break
                if (visited[Pair(r, col)] == true) continue

                visited[Pair(r, col)] = true
                res--
            }

            // Guard all the cells to the bottom
            for (r in row + 1..<m) {
                if (wallsMap[Pair(r, col)] == true) break
                if (visited[Pair(r, col)] == true) continue

                wallsMap[Pair(r, col)] = true
                res--
            }

            // Guard all the cells to the left
            for (c in col downTo 0) {
                if (wallsMap[Pair(row, c)] == true) break
                if (visited[Pair(row, c)] == true) continue

                visited[Pair(row, c)] = true
                res--
            }

            // Guard all the cells to the right
            for (c in col + 1..<n) {
                if (wallsMap[Pair(row, c)] == true) break
                if (visited[Pair(row, c)] == true) continue

                visited[Pair(row, c)] = true
                res--
            }
        }

        return res
    }*/

    // TLE
    /*fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        // -1 -> wall, 0 -> unguarded, 1 -> guarded
        val matrix = Array(m) { IntArray(n) { 0 } }

        // Add walls to block the guards
        for ((row, col) in walls) {
            matrix[row][col] = -1
        }

        for ((row, col) in guards) {
            // Guard all the cells to the top
            for (r in row downTo 0) {
                if (matrix[r][col] == -1) break
                matrix[r][col] = 1
            }

            // Guard all the cells to the bottom
            for (r in row + 1..<m) {
                if (matrix[r][col] == -1) break
                matrix[r][col] = 1
            }

            // Guard all the cells to the left
            for (c in col downTo 0) {
                if (matrix[row][c] == -1) break
                matrix[row][c] = 1
            }

            // Guard all the cells to the right
            for (c in col + 1..<n) {
                if (matrix[row][c] == -1) break
                matrix[row][c] = 1
            }
        }

        // count unguarded only (zeros)
        var res = 0
        for (r in 0..<m) {
            for (c in 0..<n) {
                if (matrix[r][c] == 0) res++
            }
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(
        sol.countUnguarded(
            4,
            6,
            arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 3)),
            arrayOf(intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(1, 4))
        )
    )

    println(
        sol.countUnguarded(
            3,
            3,
            arrayOf(intArrayOf(1, 1)),
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(2, 1), intArrayOf(1, 2))
        )
    )
}