package problems.MaximumBeautyOfAnArrayAfterApplyingOperation

// https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/

private class Solution {
    // Time: O(n * log n)
    // Space: O(1)
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        // Sorting the array because the order doesn't matter because the
        // numbers will be changed anyway.
        nums.sort()

        // Check for every window that is in the range of 2k
        // using the sliding window approach.
        var res = 0
        var left = 0
        for (right in nums.indices) {
            while (nums[right] - nums[left] > 2 * k) {
                left++
            }

            // Maximize the result window size.
            res = maxOf(res, right - left + 1)
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.maximumBeauty(intArrayOf(4, 6, 1, 2), 2))
    println(sol.maximumBeauty(intArrayOf(1, 1, 1, 1), 10))
}