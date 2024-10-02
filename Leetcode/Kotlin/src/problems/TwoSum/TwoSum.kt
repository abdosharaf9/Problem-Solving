package problems.TwoSum

import utils.printArray

// https://leetcode.com/problems/two-sum/

private class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1..<nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }

        return intArrayOf()
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.twoSum(intArrayOf(2, 7, 11, 15), 9))
    printArray(sol.twoSum(intArrayOf(3, 2, 4), 6))
    printArray(sol.twoSum(intArrayOf(3, 3), 6))
}