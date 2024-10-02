package problems.SortArrayByIncreasingFrequency

import utils.printArray

// https://leetcode.com/problems/sort-array-by-increasing-frequency/

private class Solution {
    fun frequencySort(nums: IntArray): IntArray {
        val freq = mutableMapOf<Int, Int>()
        for (x in nums) {
            freq[x] = (freq[x] ?: 0) + 1
        }

        val comparator = Comparator<Int> { x, y ->
            if (freq[x]!! < freq[y]!!) -1
            else if (freq[y]!! < freq[x]!!) 1
            else if (x > y) -1
            else if (y > x) 1
            else 0
        }

        return nums.sortedWith(comparator).toIntArray()
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.frequencySort(intArrayOf(1, 1, 2, 2, 2, 3)))
    printArray(sol.frequencySort(intArrayOf(2, 3, 1, 3, 2)))
    printArray(sol.frequencySort(intArrayOf(-1, 1, -6, 4, 5, -6, 1, 4, 1)))
}