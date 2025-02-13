package problems.MinimumOperationsToExceedThresholdValueI

// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun minOperations(nums: IntArray, k: Int): Int {
        // Count how many numbers are less than k.
        var res = 0
        for (num in nums) {
            if (num < k) {
                res++
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.minOperations(intArrayOf(2, 11, 10, 1, 3), 10))
    println(sol.minOperations(intArrayOf(1, 1, 2, 4, 9), 1))
    println(sol.minOperations(intArrayOf(1, 1, 2, 4, 9), 9))
}