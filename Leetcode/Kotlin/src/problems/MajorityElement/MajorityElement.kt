package problems.MajorityElement

// https://leetcode.com/problems/majority-element/

private class Solution {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var result = nums[0]

        for (i in nums.indices) {
            if (count == 0) result = nums[i]

            if (result == nums[i]) count++
            else count--
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.majorityElement(intArrayOf(3, 2, 3)))
    println(sol.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}