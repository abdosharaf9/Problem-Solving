package problems.CountTheNumberOfFairPairs

// https://leetcode.com/problems/count-the-number-of-fair-pairs/

private class Solution {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {

        // Return the largest i, where nums[i] < target
        fun binarySearch(left: Int, right: Int, target: Int): Int {
            var l = left
            var r = right

            while (l <= r) {
                val m = (l + r) / 2
                if (nums[m] >= target) r = m - 1
                else l = m + 1
            }

            return r
        }

        nums.sort()
        var res = 0L

        for (i in 0..nums.lastIndex) {
            val low = lower - nums[i]
            val up = upper - nums[i]

            res += (binarySearch(i + 1, nums.lastIndex, up + 1) - binarySearch(i + 1, nums.lastIndex, low))
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.countFairPairs(intArrayOf(0, 1, 7, 4, 4, 5), 3, 6))
    println(sol.countFairPairs(intArrayOf(1, 7, 9, 2, 5), 11, 11))
}