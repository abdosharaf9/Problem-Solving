package problems.LongestSquareStreakInAnArray

// https://leetcode.com/problems/longest-square-streak-in-an-array/

private class Solution {
    fun longestSquareStreak(nums: IntArray): Int {
        val numsSet = nums.toSet()
        var res = -1

        for (num in numsSet) {
            var curCount = 0
            var temp = num
            while (temp in numsSet) {
                curCount++
                if (temp.toLong() * temp > Int.MAX_VALUE) break
                temp *= temp
            }

            if (curCount > 1) res = maxOf(curCount, res)
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestSquareStreak(intArrayOf(4, 3, 6, 16, 8, 2)))
    println(sol.longestSquareStreak(intArrayOf(2, 3, 5, 6, 7)))
}