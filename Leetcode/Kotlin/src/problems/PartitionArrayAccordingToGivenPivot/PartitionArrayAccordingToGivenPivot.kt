package problems.PartitionArrayAccordingToGivenPivot

import utils.printArray

// https://leetcode.com/problems/partition-array-according-to-given-pivot/

private class Solution {
    // Time: O(n)
    // Space: O(1), because we don't use any extra memory other than the result array.
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        // Initialize the result array with the pivot to avoid looping
        // again to add it in the middle.
        val n = nums.size
        val res = IntArray(n) { pivot }

        // Add the smaller numbers first.
        var left = 0
        for (i in 0..<n) {
            if (nums[i] < pivot) {
                res[left++] = nums[i]
            }
        }

        // Add the larger numbers in the end.
        var right = n - 1
        for (i in n - 1 downTo 0) {
            if (nums[i] > pivot) {
                res[right--] = nums[i]
            }
        }

        return res
    }

    // Time: O(n)
    // Space: O(n), because we use extra memory other than the result array.
    /*fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        // Store the smaller/larger numbers in a separate array to preserve their order.
        val smaller = mutableListOf<Int>()
        val larger = mutableListOf<Int>()

        // Count the number of pivots.
        var cnt = 0

        // Loop over the numbers and add each number to the array it belongs to.
        for (num in nums) {
            if (num < pivot) {
                smaller.add(num)
            } else if (num > pivot) {
                larger.add(num)
            } else {
                cnt++
            }
        }

        // Initialize the result array.
        val res = IntArray(nums.size)
        var idx = 0

        // Add the smaller numbers first.
        for (s in smaller) {
            res[idx++] = s
        }

        // Add the pivot in the middle.
        repeat(cnt) {
            res[idx++] = pivot
        }

        // Add the larger numbers in the end.
        for (l in larger) {
            res[idx++] = l
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.pivotArray(intArrayOf(9, 12, 5, 10, 14, 3, 10), 10))
    printArray(sol.pivotArray(intArrayOf(-3, 4, 3, 2), 2))
}