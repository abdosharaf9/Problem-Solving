package problems.SortAnArray

import utils.printArray

// https://leetcode.com/problems/sort-an-array/

// Sorting using Heap Sort
// Time: O(n * log n)
// Space: O(1)
private class Solution {
    fun heapify(nums: IntArray, n: Int, i: Int) {
        val left = i * 2 + 1
        val right = i * 2 + 2
        var max = i

        if (left < n && nums[left] > nums[max]) {
            max = left
        }

        if (right < n && nums[right] > nums[max]) {
            max = right
        }

        if (max != i) {
            nums[i] = nums[max].also { nums[max] = nums[i] }
            heapify(nums, n, max)
        }
    }

    fun buildMaxHeap(nums: IntArray) {
        for (i in nums.size / 2 - 1 downTo 0) {
            heapify(nums, nums.size, i)
        }
    }

    fun sortArray(nums: IntArray): IntArray {
        buildMaxHeap(nums)

        for (i in nums.lastIndex downTo 1) {
            nums[i] = nums[0].also { nums[0] = nums[i] }
            heapify(nums, i, 0)
        }

        return nums
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.sortArray(intArrayOf(5, 2, 3, 1)))
    printArray(sol.sortArray(intArrayOf(5, 1, 1, 2, 0, 0)))
}