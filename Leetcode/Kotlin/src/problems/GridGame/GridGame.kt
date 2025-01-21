package problems.GridGame

// https://leetcode.com/problems/grid-game/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun gridGame(grid: Array<IntArray>): Long {
        // Store the size of each row and its prefix sum.
        val n = grid[0].size
        val topPrefix = LongArray(n + 1)
        val bottomPrefix = LongArray(n + 1)

        // Calculate prefix sums.
        for (i in 0..<n) {
            topPrefix[i + 1] = topPrefix[i] + grid[0][i]
            bottomPrefix[i + 1] = bottomPrefix[i] + grid[1][i]
        }

        // Loop over each index and assume that the first robot will move
        // down from it and see what will the second robot result will be.
        var res = Long.MAX_VALUE
        for (i in 0..<n) {
            // The robot will collect all the points of the top row from the
            // first cell until the index it will move down from. So the second
            // robot can take the rest of the row cell.
            val top = topPrefix[n] - topPrefix[i + 1]

            // The robot will collect all the points of the bottom row from the
            // cell it got down from until the last cell. So the second robot
            // can take the rest of the row cell.
            val bottom = bottomPrefix[i]

            // The second will maximize its points.
            val secondRobot = maxOf(top, bottom)

            // The first robot tries to minimize the second robot's points.
            res = minOf(res, secondRobot)
        }

        return res
    }
}

fun main() {
    val sol = Solution()

//    println(
//        sol.gridGame(
//            arrayOf(
//                intArrayOf(2, 5, 4),
//                intArrayOf(1, 5, 1)
//            )
//        )
//    )

//    println(
//        sol.gridGame(
//            arrayOf(
//                intArrayOf(3, 3, 1),
//                intArrayOf(8, 5, 2)
//            )
//        )
//    )
//
//    println(
//        sol.gridGame(
//            arrayOf(
//                intArrayOf(1, 3, 1, 15),
//                intArrayOf(1, 3, 3, 1)
//            )
//        )
//    )

    println(
        sol.gridGame(
            arrayOf(
                intArrayOf(20, 3, 20, 17, 2, 12, 15, 17, 4, 15),
                intArrayOf(20, 10, 13, 14, 15, 5, 2, 3, 14, 3)
            )
        )
    )
}