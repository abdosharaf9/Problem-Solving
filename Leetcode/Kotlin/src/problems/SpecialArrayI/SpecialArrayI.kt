package problems.SpecialArrayI

// https://leetcode.com/problems/special-array-i/

private class Solution {
    fun isArraySpecial(nums: IntArray): Boolean {
        val n = nums.size

        for (i in 1..<n) {
            if ((nums[i] + nums[i - 1]) % 2 == 0) {
                return false
            }
        }

        return true
    }
}