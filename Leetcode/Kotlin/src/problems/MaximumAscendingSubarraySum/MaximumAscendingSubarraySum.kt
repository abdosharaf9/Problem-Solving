package problems.MaximumAscendingSubarraySum

// https://leetcode.com/problems/maximum-ascending-subarray-sum/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun maxAscendingSum(nums: IntArray): Int {
        // Store the maximum and current sum.
        var max = 0
        var cur = nums[0]

        // Loop over all the items.
        for (i in 1..nums.lastIndex) {
            if (nums[i] > nums[i - 1]) {
                // Add the current item to the current ascending subarray.
                cur += nums[i]
            } else {
                // start a new subarray and update the maximum sum.
                max = maxOf(max, cur)
                cur = nums[i]
            }
        }

        // Update the maximum sum.
        max = maxOf(max, cur)
        return max
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxAscendingSum(intArrayOf(10, 20, 30, 5, 10, 50)))
    println(sol.maxAscendingSum(intArrayOf(10, 20, 30, 40, 50)))
    println(sol.maxAscendingSum(intArrayOf(12, 17, 15, 13, 10, 11, 12)))
}