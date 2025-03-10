package problems.TheTwoSneakyNumbersOfDigitville

import utils.printArray

// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/

private class Solution {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val map = mutableMapOf<Int, Boolean>()
        val result = mutableListOf<Int>()

        for (i in nums.indices) {
            if (map[nums[i]] == true) result.add(nums[i])
            else map[nums[i]] = true
        }

        return result.toIntArray()
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.getSneakyNumbers(intArrayOf(0, 1, 1, 0)))
    printArray(sol.getSneakyNumbers(intArrayOf(0, 3, 2, 1, 3, 2)))
    printArray(sol.getSneakyNumbers(intArrayOf(7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2)))
}