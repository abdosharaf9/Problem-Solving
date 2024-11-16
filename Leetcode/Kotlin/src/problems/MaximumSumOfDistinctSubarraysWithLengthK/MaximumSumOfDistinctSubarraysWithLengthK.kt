package problems.MaximumSumOfDistinctSubarraysWithLengthK

// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/

private class Solution {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        var res = 0L
        var l = 0
        var curSum = 0L
        val numToIndex = mutableMapOf<Int, Int>()

        for (r in 0..nums.lastIndex) {
            val lastIdx = numToIndex.getOrDefault(nums[r], -1)

            while (l <= lastIdx || r - l + 1 > k) {
                curSum -= nums[l]
                l++
            }

            curSum += nums[r]
            numToIndex[nums[r]] = r

            if (r - l + 1 == k) {
                res = maxOf(res, curSum)
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.maximumSubarraySum(intArrayOf(1, 5, 4, 2, 9, 9, 9), 3))
    println(sol.maximumSubarraySum(intArrayOf(4, 4, 4), 3))
}