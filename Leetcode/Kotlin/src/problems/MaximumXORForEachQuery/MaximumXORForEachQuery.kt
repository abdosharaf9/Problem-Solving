package problems.MaximumXORForEachQuery

import utils.printArray

// https://leetcode.com/problems/maximum-xor-for-each-query/

private class Solution {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val n = nums.size
        val max = (1 shl maximumBit) - 1
        val answer = IntArray(n)

        val prefix = IntArray(n) { nums[0] }
        for (i in 1..<n) {
            prefix[i] = nums[i] xor prefix[i - 1]
        }

        for (i in 0..<n) {
            answer[i] = prefix[n - i - 1] xor max
        }

        return answer
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.getMaximumXor(intArrayOf(0, 1, 1, 3), 2))
    printArray(sol.getMaximumXor(intArrayOf(2, 3, 4, 7), 3))
    printArray(sol.getMaximumXor(intArrayOf(0, 1, 2, 2, 5, 7), 3))
}