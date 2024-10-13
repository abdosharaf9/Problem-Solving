package problems.SmallestRangeCoveringElementsFromKLists

import utils.printArray
import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

private class Solution {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val k = nums.size
        var left = nums[0][0]
        var right = nums[0][0]
        val heap = PriorityQueue(compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }.thenBy { it.third })

        for (i in 0..<k) {
            val list = nums[i]
            heap.add(Triple(list[0], i, 0))
            left = min(left, list[0])
            right = max(right, list[0])
        }

        var result = intArrayOf(left, right)

        while (true) {
            var (_, i, idx) = heap.poll()
            idx++
            if (idx == nums[i].size) break

            val next = nums[i][idx]
            heap.add(Triple(next, i, idx))

            right = max(right, next)
            left = heap.peek().first

            if (right - left < result[1] - result[0]) {
                result = intArrayOf(left, right)
            }
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    printArray(
        sol.smallestRange(
            listOf(
                listOf(4, 10, 15, 24, 26), listOf(0, 9, 12, 20), listOf(5, 18, 22, 30)
            )
        )
    )

    printArray(
        sol.smallestRange(
            listOf(
                listOf(1, 2, 3), listOf(1, 2, 3), listOf(1, 2, 3)
            )
        )
    )
}