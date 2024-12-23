package problems.PlusOne

import utils.printArray

// https://leetcode.com/problems/plus-one/

private class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var carry = 0

        digits[digits.lastIndex]++

        for (i in digits.lastIndex downTo 0) {
            val new = digits[i] + carry
            digits[i] = new % 10
            carry = new / 10
        }

        if (carry != 0) {
            return intArrayOf(carry).plus(digits)
        }

        return digits
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.plusOne(intArrayOf(1, 2, 3)))
    printArray(sol.plusOne(intArrayOf(4, 3, 2, 1)))
    printArray(sol.plusOne(intArrayOf(9)))
    printArray(sol.plusOne(intArrayOf(9, 9)))
}