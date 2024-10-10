package problems.MaximumWidthRamp

import kotlin.math.max

// https://leetcode.com/problems/maximum-width-ramp/

private class Solution {
    fun maxWidthRamp(nums: IntArray): Int {
        val maxToRight = IntArray(nums.size)
        var max = nums.last()

        for (i in nums.indices.reversed()) {
            if (nums[i] > max) max = nums[i]
            maxToRight[i] = max
        }

        var left = 0
        var result = 0
        for (right in nums.indices) {
            while (nums[left] > maxToRight[right]) {
                left++
            }

            result = max(result, right - left)
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxWidthRamp(intArrayOf(6, 0, 8, 2, 1, 5)))
    println(sol.maxWidthRamp(intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1)))
}