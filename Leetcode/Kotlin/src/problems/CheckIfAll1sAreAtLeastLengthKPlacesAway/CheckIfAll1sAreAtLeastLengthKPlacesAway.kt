package problems.CheckIfAll1sAreAtLeastLengthKPlacesAway

// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    // Loop over all numbers while preserving the position of last 1. If the
    // current number is 1, check about the distance.
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var lastIdx = -1
        nums.forEachIndexed { idx, x ->
            if (x == 1) {
                if (lastIdx == -1 || idx - lastIdx - 1 >= k) {
                    lastIdx = idx
                } else {
                    return false
                }
            }
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.kLengthApart(intArrayOf(1, 0, 0, 0, 1, 0, 0, 1), 2))
    println(sol.kLengthApart(intArrayOf(1, 0, 0, 1, 0, 1), 2))
}