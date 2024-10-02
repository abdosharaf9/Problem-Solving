package RankTransformOfAnArray

import utils.printArray

// https://leetcode.com/problems/rank-transform-of-an-array/

class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val list = arr.toSet().sorted().mapIndexed { index, i -> Pair(i, index + 1) }.toMap()

        val result = IntArray(arr.size)
        arr.forEachIndexed { index, i ->
            result[index] = list[i]!!
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.arrayRankTransform(intArrayOf(40, 10, 20, 30)))
    printArray(sol.arrayRankTransform(intArrayOf(100, 100, 100)))
    printArray(sol.arrayRankTransform(intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12)))
}