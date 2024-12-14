package problems.ContinuousSubarrays

import kotlin.math.abs

// https://leetcode.com/problems/continuous-subarrays/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun continuousSubarrays(nums: IntArray): Long {
        // Use Sliding Window approach to validate all the sub-arrays.
        // Use the map to keep track of the maximum and minimum values
        // in the current window.
        var res = 0L
        var l = 0
        val freq = mutableMapOf<Int, Int>()

        for (r in nums.indices) {
            // Updating the frequency of the current item.
            freq[nums[r]] = (freq[nums[r]] ?: 0) + 1

            // Shrink the window until it is a valid one.
            while (abs(freq.keys.max() - freq.keys.min()) > 2) {
                freq[nums[l]] = freq[nums[l]]!! - 1

                // Remove the key from the map to exclude it from the keys
                // when we get the minimum and maximum values.
                if (freq[nums[l]] == 0) {
                    freq.remove(nums[l])
                }

                l++
            }

            // Adding all the possible sub-arrays in the current window.
            res += r - l + 1
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.continuousSubarrays(intArrayOf(5, 4, 2, 4)))
    println(sol.continuousSubarrays(intArrayOf(1, 2, 3)))
}