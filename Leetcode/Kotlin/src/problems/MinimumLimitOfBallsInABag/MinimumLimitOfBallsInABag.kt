package problems.MinimumLimitOfBallsInABag

import kotlin.math.ceil

// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

private class Solution {
    // Time: O(n * log m), where m is the maximum number in the array
    // Space: O(1)
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        // Check if the selected number can be used as the maximum number
        // of balls for all bags using just the maximum number of operations
        // we can use
        fun canDivide(n: Int): Boolean {
            var ops = 0
            for (x in nums) {
                // How many operations we need to split the current number
                // into multiple of bags each of them has maximum balls of n.
                ops += ceil(x / n.toDouble()).toInt() - 1

                // Can't split using the maximum number of operations
                if (ops > maxOperations) {
                    return false
                }
            }

            return true
        }

        // Do a Binary Search between the minimum and maximum values we can have
        var left = 1
        var right = nums.max()

        while (left < right) {
            // If the current number can be used, search for a smaller one.
            // If it can't, search for a bigger one.
            val mid = (left + right) / 2
            if (canDivide(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        // The left pointer will be in the minimum value we can use
        return left
    }
}

fun main() {
    val sol = Solution()
    println(sol.minimumSize(intArrayOf(9), 2))
    println(sol.minimumSize(intArrayOf(2, 4, 8, 2), 4))
}