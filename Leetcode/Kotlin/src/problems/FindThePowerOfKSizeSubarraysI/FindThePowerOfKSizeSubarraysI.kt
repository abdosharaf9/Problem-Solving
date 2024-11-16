package problems.FindThePowerOfKSizeSubarraysI

import utils.printArray

// https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/

private class Solution {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        if (k == 1) return nums

        val n = nums.size
        val result = IntArray(n - k + 1) { -1 }
        var cons = 0

        for (i in 1..<k - 1) {
            if (nums[i] != nums[i - 1] + 1) cons = 0
            else cons++
        }

        for (i in k - 1..<n) {
            if (nums[i] != nums[i - 1] + 1) cons = 0
            else cons++

            result[i - k + 1] = if (cons >= k - 1) nums[i]
            else -1
        }

        return result
    }

    /*fun resultsArray(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val result = IntArray(n - k + 1) { -1 }

        var l = 0
        var r = k - 1

        while (r < n) {
            var max = Int.MIN_VALUE
            for (i in l..r) {
                if (i != r && nums[i + 1] - nums[i] != 1) {
                    max = Int.MIN_VALUE
                    break
                }

                if (nums[i] > max) max = nums[i]
            }

            result[l] = maxOf(max, result[l])
            r++
            l++
        }

        return result
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.resultsArray(intArrayOf(1, 2, 3, 4, 3, 2, 5), 3))
    printArray(sol.resultsArray(intArrayOf(2, 2, 2, 2, 2), 4))
    printArray(sol.resultsArray(intArrayOf(3, 2, 3, 2, 3, 2), 2))
}