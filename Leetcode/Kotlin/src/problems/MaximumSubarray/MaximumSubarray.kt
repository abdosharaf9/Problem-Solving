package problems.MaximumSubarray

import kotlin.math.max

// https://leetcode.com/problems/maximum-subarray/

private class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        var cur = 0

        for (x in nums) {
            cur += x
            maxSum = max(maxSum, cur)
            if (cur < 0) cur = 0
        }

        return maxSum
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(sol.maxSubArray(intArrayOf(1)))
    println(sol.maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
}