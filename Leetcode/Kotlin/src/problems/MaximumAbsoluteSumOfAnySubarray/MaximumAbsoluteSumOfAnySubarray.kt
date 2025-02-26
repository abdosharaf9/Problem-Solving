package problems.MaximumAbsoluteSumOfAnySubarray

import kotlin.math.abs

// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun maxAbsoluteSum(nums: IntArray): Int {
        // Store the current sum, maximum prefix, minimum prefix, and the result.
        var curSum = 0
        var maxPrefix = 0
        var minPrefix = 0
        var res = 0

        for (num in nums) {
            // Accumulate the summation.
            curSum += num

            // We need to know which previous sum we can remove from the current sum
            // to get the absolute maximum value. The only two values that can do this
            // are the minimum and maximum sum. The minimum sum will give us the maximum
            // positive value, and the maximum value will give us the maximum negative
            // value, and both of them are the highest two values we can have in either
            // direction.
            res = maxOf(
                res,
                abs(curSum - maxPrefix), // abs(maximum value we can have in the negative direction)
                abs(curSum - minPrefix) // abs(maximum value we can have in the positive direction)
            )

            // Update the minimum and maximum prefixes.
            maxPrefix = maxOf(maxPrefix, curSum)
            minPrefix = minOf(minPrefix, curSum)
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxAbsoluteSum(intArrayOf(1, -3, 2, 3, -4)))
    println(sol.maxAbsoluteSum(intArrayOf(2, -5, 1, -4, 3, -2)))
}