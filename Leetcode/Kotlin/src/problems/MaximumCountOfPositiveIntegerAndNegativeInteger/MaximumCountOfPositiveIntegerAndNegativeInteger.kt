package problems.MaximumCountOfPositiveIntegerAndNegativeInteger

// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

private class Solution {
    // Time: O(log n)
    // Space: O(1)
    fun maximumCount(nums: IntArray): Int {
        // Use the Binary Search to get the lower bound of the target number.
        fun findFirstIndex(target: Int): Int {
            // Initialize the pointers.
            var left = 0
            var right = nums.size

            // Loop until the pointers cross each other.
            while (left < right) {
                // Update the range according to the target number.
                val mid = left + (right - left) / 2
                if (nums[mid] >= target) right = mid
                else left = mid + 1
            }

            // Return the left pointer which is the lower bound
            // (index of first occurrence) of the target number.
            return left
        }

        // Store the count of positive and negative numbers using the
        // index of the first 0 and the first number bigger than 0.
        val neg = findFirstIndex(0)
        val pos = nums.size - findFirstIndex(1)

        // Return the maximum between them.
        return maxOf(neg, pos)
    }

    // Time: O(1)
    // Space: O(1)
    /*fun maximumCount(nums: IntArray): Int {
        // Store the count of positive and negative numbers, and return the maximum.
        val pos = nums.count { it > 0 }
        val neg = nums.count { it < 0 }
        return maxOf(pos, neg)
    }*/

    // Time: O(n)
    // Space: O(1)
    /*fun maximumCount(nums: IntArray): Int {
        // Store the count of positive and negative numbers.
        var pos = 0
        var neg = 0

        // Loop over the numbers and update the counts.
        for (n in nums) {
            if (n > 0) pos++
            else if (n < 0) neg++
        }

        // Return the maximum between them.
        return maxOf(pos, neg)
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.maximumCount(intArrayOf(-2, -1, -1, 1, 2, 3)))
    println(sol.maximumCount(intArrayOf(-3, -2, -1, 0, 0, 1, 2)))
    println(sol.maximumCount(intArrayOf(5, 20, 66, 1314)))
}