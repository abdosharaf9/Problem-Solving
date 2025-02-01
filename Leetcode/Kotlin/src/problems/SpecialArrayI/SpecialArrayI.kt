package problems.SpecialArrayI

// https://leetcode.com/problems/special-array-i/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun isArraySpecial(nums: IntArray): Boolean {
        // Loop over all the item from the second one to the last one, and check
        // the item and the one before it if they are both even or both odd.
        for (i in 1..nums.lastIndex) {
            if ((nums[i] + nums[i - 1]) % 2 == 0) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.isArraySpecial(intArrayOf(1)))
    println(sol.isArraySpecial(intArrayOf(2, 1, 4)))
    println(sol.isArraySpecial(intArrayOf(4, 3, 1, 6)))
}