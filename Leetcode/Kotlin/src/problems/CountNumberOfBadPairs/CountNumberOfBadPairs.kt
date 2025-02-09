package problems.CountNumberOfBadPairs

// https://leetcode.com/problems/count-number-of-bad-pairs/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun countBadPairs(nums: IntArray): Long {
        // Calculate the total number of pairs.
        val n = nums.size.toLong()
        val totalPairs = n * (n - 1) / 2

        // Store the number of good pairs (their difference is equal).
        var goodPairs = 0L

        // Store the count of each difference (nums[i] - i).
        val count = HashMap<Int, Int>()

        for (i in nums.indices) {
            // Calculate the difference (nums[i] - i).
            val cur = nums[i] - i

            // Increase the number of good pairs if we can.
            goodPairs += count[cur] ?: 0

            // Increase the count of the current different.
            count[cur] = (count[cur] ?: 0) + 1
        }

        // Return the number of bad pairs.
        return totalPairs - goodPairs
    }
}

fun main() {
    val sol = Solution()
    println(sol.countBadPairs(intArrayOf(4, 1, 3, 3)))
    println(sol.countBadPairs(intArrayOf(1, 2, 3, 4, 5)))
}