package problems.CheckIfArrayIsSortedAndRotated

// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun check(nums: IntArray): Boolean {
        // Suppose that the array is sorted in a non-decreasing order.
        var isIncreasing = true

        for (i in 1..nums.lastIndex) {
            // If the current element is smaller than the element before it and
            // we are still checking about the increasing order, change it to
            // decreasing order, and if we already changed the order before, this
            // means the array wasn't sorted.
            // The first one is the point of rotation. This means that we can't have more than one.
            if (nums[i] < nums[i - 1]) {
                if (isIncreasing) {
                    isIncreasing = false
                } else {
                    return false
                }
            }
        }

        // If we found a point of rotation before, we must check that
        // the last item is smaller than the first one.
        if (!isIncreasing && nums.last() > nums[0]) {
            return false
        }

        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.check(intArrayOf(3, 4, 5, 1, 2)))
    println(sol.check(intArrayOf(2, 1, 3, 4)))
    println(sol.check(intArrayOf(1, 2, 3)))
}