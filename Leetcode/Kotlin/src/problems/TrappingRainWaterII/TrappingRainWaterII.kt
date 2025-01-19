package problems.TrappingRainWaterII

import java.util.PriorityQueue

// https://leetcode.com/problems/trapping-rain-water-ii/

private class Solution {
    // Time: O(m * n * log m*n), because each time we add or remove from the heap.
    // Space: O(m * n)
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        // Getting the grid size.
        val rows = heightMap.size
        val cols = heightMap[0].size

        // Use a Min Heap to traverse the cells in ascending order according to its
        // height. Each item will be a Triple that represents (height, row, column).
        val minHeap = PriorityQueue(compareBy<Triple<Int, Int, Int>> { it.first })

        // Add the boundary cells to the Min Heap and mark them as visited.
        for (r in 0..<rows) {
            for (c in 0..<cols) {
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                    minHeap.add(Triple(heightMap[r][c], r, c))
                    heightMap[r][c] = -1
                }
            }
        }

        // Keep track of the maximum height while traversing the cells.
        var res = 0
        var max = -1

        while (minHeap.isNotEmpty()) {
            // Get the cell with the minimum height.
            val (h, r, c) = minHeap.poll()

            // Update the maximum height value and the result.
            max = maxOf(max, h)
            res += max - h

            // Add its neighbors to the Min Heap.
            val neighbors = arrayOf(r to c - 1, r to c + 1, r - 1 to c, r + 1 to c)
            for ((nr, nc) in neighbors) {
                // If we went out of boundaries or visited that cell
                // before, then continue to the next one.
                if (
                    nr < 0 || nr == rows ||
                    nc < 0 || nc == cols ||
                    heightMap[nr][nc] == -1
                ) {
                    continue
                }

                // Add the neighbor and mark it as visited.
                minHeap.add(Triple(heightMap[nr][nc], nr, nc))
                heightMap[nr][nc] = -1
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.trapRainWater(
            arrayOf(
                intArrayOf(1, 4, 3, 1, 3, 2),
                intArrayOf(3, 2, 1, 3, 2, 4),
                intArrayOf(2, 3, 3, 2, 3, 1)
            )
        )
    )

    println(
        sol.trapRainWater(
            arrayOf(
                intArrayOf(3, 3, 3, 3, 3),
                intArrayOf(3, 2, 2, 2, 3),
                intArrayOf(3, 2, 1, 2, 3),
                intArrayOf(3, 2, 2, 2, 3),
                intArrayOf(3, 3, 3, 3, 3)
            )
        )
    )
}