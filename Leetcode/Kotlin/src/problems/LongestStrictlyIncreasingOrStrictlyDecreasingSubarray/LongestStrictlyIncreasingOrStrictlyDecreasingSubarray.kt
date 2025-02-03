package problems.LongestStrictlyIncreasingOrStrictlyDecreasingSubarray

// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun longestMonotonicSubarray(nums: IntArray): Int {
        // Store the current state.
        var isIncreasing = true
        var max = 1
        var cur = 1

        // Loop over all the items and check if the current subarray is still
        // using the same state, or we started a new subarray with different state.
        for (i in 1..nums.lastIndex) {
            if (isIncreasing) {
                if (nums[i] > nums[i - 1]) {
                    // We are still in the same increasing subarray.
                    cur++
                } else if (nums[i] == nums[i - 1]) {
                    // Start a new increasing subarray. This is because we need
                    // only the strictly increasing subarray.
                    max = maxOf(max, cur)
                    cur = 1
                } else {
                    // Start a new decreasing subarray.
                    max = maxOf(max, cur)
                    cur = 2
                    isIncreasing = false
                }
            } else {
                if (nums[i] < nums[i - 1]) {
                    // We are still in the same decreasing subarray.
                    cur++
                } else if (nums[i] == nums[i - 1]) {
                    // We started a new decreasing subarray. This is because we need
                    // only the strictly decreasing subarray.
                    max = maxOf(max, cur)
                    cur = 1
                } else {
                    // Start a new increasing subarray.
                    max = maxOf(max, cur)
                    cur = 2
                    isIncreasing = true
                }
            }
        }

        // Update the max length.
        max = maxOf(max, cur)
        return max
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestMonotonicSubarray(intArrayOf(1, 4, 3, 3, 2)))
    println(sol.longestMonotonicSubarray(intArrayOf(3, 3, 3, 3)))
    println(sol.longestMonotonicSubarray(intArrayOf(3, 2, 1)))
}