package problems.SquaresOfASortedArray

import utils.printArray
import kotlin.math.abs

// https://leetcode.com/problems/squares-of-a-sorted-array/

private class Solution {

    fun sortedSquares(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var left = 0
        var right = nums.lastIndex

        for (i in nums.indices.reversed()) {
            if (abs(nums[left]) > abs(nums[right])) {
                result[i] = nums[left] * nums[left]
                left++
            } else {
                result[i] = nums[right] * nums[right]
                right--
            }
        }

        return result
    }

    /*fun sortedSquares(nums: IntArray): IntArray {
        return nums.map { it * it }.sorted().toIntArray()
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.sortedSquares(intArrayOf(-4, -1, 0, 3, 10)))
    printArray(sol.sortedSquares(intArrayOf(-7, -3, 2, 3, 11)))
}