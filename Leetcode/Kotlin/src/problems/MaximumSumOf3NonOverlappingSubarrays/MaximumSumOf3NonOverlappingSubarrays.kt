package problems.MaximumSumOf3NonOverlappingSubarrays

import utils.printArray

// https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

private class Solution {
    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        // Store the summation of all sub-arrays with size k.
        val subArrays = IntArray(nums.size - k + 1)

        // Use Sliding Window approach to get all the sub-arrays.
        var l = 0
        var curSum = 0
        for (r in nums.indices) {
            curSum += nums[r]

            // If the window size is k, store the current sub-array summation.
            if (r - l + 1 == k) {
                subArrays[l] = curSum
                curSum -= nums[l]
                l++
            }
        }

        // Using Dynamic Programming to see what is the maximum size we can
        // get when we include or exclude the current sub-array.
        val dp = mutableMapOf<Pair<Int, Int>, Int>()
        fun getMaxSum(idx: Int, count: Int): Int {
            // If we have already chosen the 3 sub-arrays or get out of bounds.
            if (idx > nums.size - k || count == 3) return 0

            // Return the result if it is computed before.
            dp[idx to count]?.let { return it }

            // Calculate what is the maximum size we can get by including
            // or excluding the current sub-array.
            val include = subArrays[idx] + getMaxSum(idx + k, count + 1)
            val exclude = getMaxSum(idx + 1, count)
            dp[idx to count] = maxOf(include, exclude)

            return dp[idx to count]!!
        }

        // Store the 3 indices we will choose.
        val res = mutableListOf<Int>()

        // Loop over all the sub-arrays summations and check if we can
        // choose it and add its start index to the result array.
        var i = 0
        while (i <= nums.size - k && res.size < 3) {
            val include = subArrays[i] + getMaxSum(i + k, res.size + 1)
            val exclude = getMaxSum(i + 1, res.size)

            if (include >= exclude) {
                res.add(i)
                i += k
            } else {
                i += 1
            }
        }

        return res.toIntArray()
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.maxSumOfThreeSubarrays(intArrayOf(1, 2, 1, 2, 6, 7, 5, 1), 2))
    printArray(sol.maxSumOfThreeSubarrays(intArrayOf(1, 2, 1, 2, 1, 2, 1, 2, 1), 2))
}