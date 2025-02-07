package problems.FindTheNumberOfDistinctColorsAmongTheBalls

import utils.printArray

// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        // Store the color of each ball.
        val balls = mutableMapOf<Int, Int>()

        // Store the count of each color.
        val colors = mutableMapOf<Int, Int>()

        // Result array.
        val result = IntArray(queries.size)

        for (i in queries.indices) {
            // Unpack the query.
            val (ball, color) = queries[i]

            // If the ball was already colored, remove the count of that ball
            // before changing it to the new color.
            if (balls.containsKey(ball)) {
                // Get the previous color, and decrement its count.
                val prevColor = balls[ball]!!
                colors[prevColor] = colors[prevColor]!! - 1

                // If its count is 0, remove it from the map.
                if (colors[prevColor] == 0) {
                    colors.remove(prevColor)
                }
            }

            // Change the ball's color to the new one, and increment the color's count.
            balls[ball] = color
            colors[color] = colors.getOrDefault(color, 0) + 1

            // The current result is the number of distinct colors.
            result[i] = colors.size
        }

        return result
    }
}

fun main() {
    val sol = Solution()

    printArray(
        sol.queryResults(
            4,
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 5),
                intArrayOf(1, 3),
                intArrayOf(3, 4)
            )
        )
    )

    printArray(
        sol.queryResults(
            4,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(2, 2),
                intArrayOf(3, 4),
                intArrayOf(4, 5)
            )
        )
    )
}