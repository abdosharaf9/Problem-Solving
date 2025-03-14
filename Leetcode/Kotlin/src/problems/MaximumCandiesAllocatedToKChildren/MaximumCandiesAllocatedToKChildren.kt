package problems.MaximumCandiesAllocatedToKChildren

// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/

private class Solution {
    // Time: O(n * log x), where n is the size of candies array,
    // and x is the sum of all candies divided by k.
    // Space: O(1)
    fun maximumCandies(candies: IntArray, k: Long): Int {
        // Check if the chosen number of candies is valid.
        fun canSplit(p: Int): Boolean {
            // Count the number of piles we can get by splitting each pile.
            var count = 0L
            for (c in candies) {
                count += c / p

                // Small optimization to stop earlier.
                if (count >= k) return true
            }

            // Check if the number of piles is suitable for k children.
            return count >= k
        }

        // Get the sum of all candies, and check if there is a possible answer.
        val sum = candies.sumOf { it.toLong() }
        if (sum < k) return 0

        // If there is a possible solution, initialize our search space with 1 as the
        // smallest value, and x is the biggest value we can get, where x is the sum
        // of candies divided by k (split the candies evenly).
        var left = 1
        var right = (sum / k).toInt()
        var res = 0

        while (left <= right) {
            // Calculate the mid value.
            val mid = (left + right) / 2

            // If the mid value is valid, update the result and search for a bigger
            // value. If not, search for a smaller one.
            if (canSplit(mid)) {
                res = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.maximumCandies(intArrayOf(5, 8, 6), 3))
    println(sol.maximumCandies(intArrayOf(2, 5), 11))
}