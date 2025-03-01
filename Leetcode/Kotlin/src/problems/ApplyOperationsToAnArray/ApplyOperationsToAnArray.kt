package problems.ApplyOperationsToAnArray

import utils.printArray

// https://leetcode.com/problems/apply-operations-to-an-array/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun applyOperations(nums: IntArray): IntArray {
        val n = nums.size
        var l = 0
        for (i in 0..<n) {
            // Apply the operation.
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                nums[i] *= 2
                nums[i + 1] = 0
            }

            // Swap the non-zero value with a zero.
            if (nums[i] != 0) {
                nums[l] = nums[i].also { nums[i] = nums[l] }
                l++
            }
        }

        return nums
    }

    // Time: O(n)
    // Space: O(1)
    /*fun applyOperations(nums: IntArray): IntArray {
        val n = nums.size
        for (i in 0..<n - 1) {
            // Apply the operation.
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2
                nums[i + 1] = 0
            }
        }

        // Use the partition (from Quick Sort) to push the non-zero value into the beginning.
        var l = 0
        for (i in 0..<n) {
            if (nums[i] != 0) {
                // Swap the non-zero value with a zero.
                nums[l] = nums[i].also { nums[i] = nums[l] }
                l++
            }
        }

        return nums
    }*/

    // Time: O(n)
    // Space: O(n)
    /*fun applyOperations(nums: IntArray): IntArray {
        val n = nums.size

        // Use extra array initialized with all zeros, and only add the non-zero values.
        val res = IntArray(n)
        var j = 0

        for (i in 0..<n) {
            // Perform the operation.
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                nums[i] *= 2
                nums[i + 1] = 0

            }

            // If the number is non-zero, add it to the result.
            if (nums[i] != 0) {
                res[j] = nums[i]
                j++
            }
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.applyOperations(intArrayOf(1, 2, 2, 1, 1, 0)))
    printArray(sol.applyOperations(intArrayOf(0, 1)))
}