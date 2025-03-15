package problems.HouseRobberIV

// https://leetcode.com/problems/house-robber-iv/

private class Solution {
    // Time: O(n * log m), where m is the maximum number in nums.
    // Space: O(1)
    fun minCapability(nums: IntArray, k: Int): Int {
        // Check if the chosen capability is valid.
        fun check(c: Int): Boolean {
            // Count the number smaller than or equal to the capability,
            // but make sure not to consider any adjacent houses.
            var count = 0
            var i = 0

            while (i <= nums.lastIndex) {
                // If the current house's amount is smaller than c, update
                // the count and make sure to dismiss the adjacent house.
                // If not, go to the next house.
                if (nums[i] <= c) {
                    count++
                    i += 2
                } else {
                    i++
                }

                // Stop the loop early if we already found k houses with
                // amount smaller than or equal to c.
                if (count == k) {
                    return true
                }
            }

            // Check if c is valid.
            return count >= k
        }

        // Initialize the range we will search in.
        var left = nums.min()
        var right = nums.max()
        var res = 0

        // Search for our result in that range.
        while (left <= right) {
            // Calculate the mid point.
            val mid = (left + right) / 2

            // If the mid point is a valid capability, update the result and search for
            // a smaller one (minimize the result). If not, search for a bigger one.
            if (check(mid)) {
                res = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.minCapability(intArrayOf(2, 3, 5, 9), 2))
    println(sol.minCapability(intArrayOf(2, 7, 9, 3, 1), 2))
}