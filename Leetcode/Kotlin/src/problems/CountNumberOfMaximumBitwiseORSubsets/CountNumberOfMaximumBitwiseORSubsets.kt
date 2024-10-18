package problems.CountNumberOfMaximumBitwiseORSubsets

// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/

private class Solution {
    fun countMaxOrSubsets(nums: IntArray): Int {
        val maxOr = nums.fold(0) { acc, x -> acc or x }

        fun dfsSearch(i: Int, currentOr: Int): Int {
            if (i == nums.size) {
                return if (currentOr == maxOr) 1 else 0
            }

            return dfsSearch(i + 1, currentOr) + dfsSearch(i + 1, currentOr or nums[i])
        }

        return dfsSearch(0, 0)
    }

}

fun main() {
    val sol = Solution()
    println(sol.countMaxOrSubsets(intArrayOf(3, 1)))
    println(sol.countMaxOrSubsets(intArrayOf(2, 2, 2)))
    println(sol.countMaxOrSubsets(intArrayOf(3, 2, 1, 5)))
}