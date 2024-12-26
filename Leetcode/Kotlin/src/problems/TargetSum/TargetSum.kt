package problems.TargetSum

// https://leetcode.com/problems/target-sum/

private class Solution {
    // Bottom-Up optimized solution.
    // Time: O(n * S), where S is the possible sums of nums.
    // Space: O(S), because we store only one state (row).
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        // Store only one row of the table. Each item is represented as
        // (sum, count) which means there is $count ways to get the $sum.
        var dp = mutableMapOf<Int, Int>()
        dp[0] = 1 // one way to get the sum 0 by taking no elements.

        for (num in nums) {
            // Construct the next row using the previous one.
            val nextDp = mutableMapOf<Int, Int>()

            for ((sum, count) in dp) {
                // Update the cells of the new row by adding the count of the previous row
                // to it, which means we update the number of ways we can reach this sum.
                nextDp[sum + num] = count + (nextDp[sum + num] ?: 0)
                nextDp[sum - num] = count + (nextDp[sum - num] ?: 0)
            }

            // Make the next row is the current row.
            dp = nextDp
        }

        // Return the number of ways we can reach the target sum.
        return dp[target] ?: 0
    }

    // Bottom-Up full tabulation solution (2D).
    // Time: O(n * S), where S is the possible sums of nums.
    // Space: O(n * S), because we store the whole table of states.
    /*fun findTargetSumWays(nums: IntArray, target: Int): Int {
        // Store the table of states. Each item is represented as (sum, count)
        // which means there is $count ways to get the $sum. Each index represent
        // the number of items are added to get that sum.
        val n = nums.size
        val dp = Array(n + 1) { mutableMapOf<Int, Int>() }

        // We need 0 items to get the sum 0 which means there is only one way.
        dp[0][0] = 1

        for (i in 0..<n) {
            // Construct the next row using the previous one by Updating the cells
            // of the new row by adding the count of the previous row to it, which
            // means we update the number of ways we can reach this sum.
            for ((sum, count) in dp[i]) {
                dp[i + 1][sum + nums[i]] = count + (dp[i + 1][sum + nums[i]] ?: 0)
                dp[i + 1][sum - nums[i]] = count + (dp[i + 1][sum - nums[i]] ?: 0)
            }
        }

        // Return the number of ways we can reach the target sum after taking all the items.
        return dp[n][target] ?: 0
    }*/

    // Top-Down solution using memoization.
    // Time: O(n * S), where S is the possible sums of nums.
    // Space: O(n * S), because we store all the states in a single map.
    /*fun findTargetSumWays(nums: IntArray, target: Int): Int {
        // Store all the states. The keys are (idx, sum) which means the number of
        // items we added to get the $sum. The values represent the count, which means
        // the number of ways to get that sum.
        val dp = mutableMapOf<Pair<Int, Int>, Int>()

        fun backtrack(idx: Int, curSum: Int): Int {
            // Return the current state if computed before.
            dp[idx to curSum]?.let { return it }

            // If we reached the last item check if we can get the target sum.
            if (idx == nums.size) {
                return if (curSum == target) 1 else 0
            }

            // Count the number of ways of the current state by adding the ways
            // of adding or subtracting the current item from the sum.
            dp[idx to curSum] = backtrack(idx + 1, curSum + nums[idx]) +
                    backtrack(idx + 1, curSum - nums[idx])

            // Return the number of ways we can reach the target sum.
            return dp[idx to curSum]!!
        }

        return backtrack(0, 0)
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
    println(sol.findTargetSumWays(intArrayOf(1), 1))
}