package problems.HouseRobber

// https://leetcode.com/problems/house-robber/

private class Solution {
    fun rob(nums: IntArray): Int {
        val size = nums.size
        if (size == 1) return nums[0]
        if (size == 2) return maxOf(nums[0], nums[1])

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])

        for (i in 2..<size) {
            dp[i] = maxOf(dp[i - 1], dp[i - 2] + nums[i])
        }

        return dp[size - 1]
    }
}

fun main() {
    val sol = Solution()
    println(sol.rob(intArrayOf(1, 2, 3, 1)))
    println(sol.rob(intArrayOf(2, 7, 9, 3, 1)))
}