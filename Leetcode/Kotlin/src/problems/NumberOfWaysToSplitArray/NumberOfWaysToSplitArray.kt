package problems.NumberOfWaysToSplitArray

// https://leetcode.com/problems/number-of-ways-to-split-array/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun waysToSplitArray(nums: IntArray): Int {
        val n = nums.size

        // Store the summation of all values
        val total = nums.fold(0L) { acc, num -> acc + num }

        var res = 0
        var leftPart = 0L

        // Loop over all the items and increment the left part.
        for (i in 0..<n - 1) {
            // Add the current item to the left part.
            leftPart += nums[i]

            // Check the condition to increment the result.
            if (leftPart >= total - leftPart) {
                res++
            }
        }

        return res
    }

    // Time: O(n)
    // Space: O(n)
    /*fun waysToSplitArray(nums: IntArray): Int {
        val n = nums.size

        // Store the prefix sum.
        val prefix = IntArray(n + 1) { 0 }
        nums.forEachIndexed { i, num ->
            prefix[i + 1] = prefix[i] + num
        }

        var res = 0

        // Loop over all the prefix summations and consider each one as the
        // left part, and the rest of the array summation will be the right part.
        for (i in 1..<n) {
            // Check the condition to increment the result.
            if (prefix[i] >= prefix[n] - prefix[i]) {
                res++
            }
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.waysToSplitArray(intArrayOf(10, 4, -8, 7)))
    println(sol.waysToSplitArray(intArrayOf(2, 3, 1, 0)))
}