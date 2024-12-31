package problems.MinimumCostForTickets

// https://leetcode.com/problems/minimum-cost-for-tickets/

private class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val dp = IntArray(366) { -1 }
        dp[days.size] = 0

        fun dfs(i: Int): Int {
            if (dp[i] != -1) {
                return dp[i]
            }

            dp[i] = Int.MAX_VALUE
            for ((cost, duration) in costs.zip(intArrayOf(1, 7, 30))) {
                var j = i
                while (j < days.size && days[j] < days[i] + duration) {
                    j++
                }
                dp[i] = minOf(dp[i], cost + dfs(j))
            }

            return dp[i]
        }

        return dfs(0)
    }
}

fun main() {
    val sol = Solution()
    println(sol.mincostTickets(intArrayOf(1, 4, 6, 7, 8, 20), intArrayOf(2, 7, 15)))
    println(sol.mincostTickets(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31), intArrayOf(2, 7, 15)))
}