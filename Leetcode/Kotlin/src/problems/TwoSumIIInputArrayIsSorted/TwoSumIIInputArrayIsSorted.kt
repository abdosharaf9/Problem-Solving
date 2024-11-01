package problems.TwoSumIIInputArrayIsSorted

import utils.printArray

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

private class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex

        while (left < right) {
            val cur = numbers[left] + numbers[right]
            if (cur == target) return intArrayOf(left + 1, right + 1)
            else if (cur > target) right--
            else left++
        }

        return intArrayOf(0, 0)
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.twoSum(intArrayOf(2, 7, 11, 15), 9))
    printArray(sol.twoSum(intArrayOf(2, 3, 4), 6))
    printArray(sol.twoSum(intArrayOf(-1, 0), -1))
}