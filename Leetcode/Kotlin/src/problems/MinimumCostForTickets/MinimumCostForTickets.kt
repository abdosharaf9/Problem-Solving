package problems.MinimumCostForTickets

// https://leetcode.com/problems/minimum-cost-for-tickets/

private class Solution {
    // Top-Down Dynamic Programming Solution.
    // Time: O(n)
    // Space: O(n)
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        // Used as memoization.
        val dp = IntArray(days.size) { -1 }

        fun dfs(i: Int): Int {
            // The initial state is going out of the array bound which means there
            // are no more tickets needed (0).
            if (i >= days.size) {
                return 0
            }

            // Return the result if it was precalculated.
            if (dp[i] != -1) {
                return dp[i]
            }

            // Use a big value to minimize the answer.
            dp[i] = Int.MAX_VALUE

            // Loop over the costs and try each of them and see which one will
            // give the minimum result.
            for ((cost, duration) in costs.zip(intArrayOf(1, 7, 30))) {
                // Go to the next index of the array where the chosen duration
                // will be ended (which means the next day we need to buy new tickets).
                var j = i
                while (j < days.size && days[j] < days[i] + duration) {
                    j++
                }

                // Try to minimize the result by choosing the current duration cost
                // and see what will be the rest of the array cost.
                dp[i] = minOf(dp[i], cost + dfs(j))
            }

            // Return the calculated cost.
            return dp[i]
        }
        // Start with the first index of the array.
        return dfs(0)
    }

    // Bottom-Up Dynamic Programming Solution (not working currently).
    // Time: O(n)
    // Space: O(n)
    /*fun mincostTickets(days: IntArray, costs: IntArray): Int {
        // Used as memoization.
        val dp = IntArray(days.size + 1) { 0 }

        // Loop over the array in backwards.
        for (i in dp.lastIndex downTo 0) {
            // Use a big value to minimize the answer.
            dp[i] = Int.MAX_VALUE

            // Loop over the costs and try each of them and see which one will
            // give the minimum result.
            var j = i
            for ((cost, duration) in costs.zip(intArrayOf(1, 7, 30))) {
                // Go to the next index of the array where the chosen duration
                // will be ended (which means the next day we need to buy new tickets).
                while (j < days.size && days[j] < days[i] + duration) {
                    j++
                }

                // Try to minimize the result by choosing the current duration cost
                // added with the cost of the next index.
                dp[i] = minOf(dp[i], cost + dp[j])
            }
        }

        return dp[0]
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.mincostTickets(intArrayOf(1, 4, 6, 7, 8, 20), intArrayOf(2, 7, 15)))
    println(sol.mincostTickets(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31), intArrayOf(2, 7, 15)))
}