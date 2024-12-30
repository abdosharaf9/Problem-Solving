package problems.CountWaysToBuildGoodStrings

// https://leetcode.com/problems/count-ways-to-build-good-strings/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val mod = 1_000_000_007
        // Store all the states we can have, the initial case is only one
        // string with length 0.
        val dp = IntArray(high + 1) { 1 }

        fun count(length: Int): Int {
            // If we exceed the limit, we can't form any string.
            if (length > high) {
                return 0
            }

            // Return the result if precomputed.
            if (dp[length] != -1) {
                return dp[length]
            }

            // Currently if we are in the range, thus we have a valid string.
            var res: Long = if (length >= low) 1 else 0

            // Add the number of ways we can form a string by choose zeros
            // as the next characters, and the same if we choose ones. Then,
            // store the result for memoization.
            res += count(length + zero) + count(length + one)
            dp[length] = (res % mod).toInt()

            return dp[length]
        }

        // Start with an empty string.
        return count(0)
    }

    // Time: O(n), but it has two loops not a single recursion.
    // Space: O(n)
    /*fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val mod = 1_000_000_007
        // The initial case is only one string with length 0.
        val dp = IntArray(high + 1) { 1 }

        for (i in 1..high) {
            // The current count will be based on the previous valid strings.
            val res: Long = 0L + dp.getOrElse(i - zero) { 0 } + dp.getOrElse(i - one) { 0 }

            // Convert the count and save it.
            dp[i] = (res % mod).toInt()
        }

        // Sum all the counts of the valid strings.
        var res = 0
        for (i in low..high) {
            res = (res + dp[i]) % mod
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.countGoodStrings(3, 3, 1, 1))
    println(sol.countGoodStrings(2, 3, 1, 2))
}