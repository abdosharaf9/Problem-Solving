package problems.JumpGame

// https://leetcode.com/problems/jump-game/

private class Solution {
    fun canJump(nums: IntArray): Boolean {
        var goal = nums.size - 1

        for (i in nums.size - 2 downTo 0) {
            if (i + nums[i] >= goal) goal = i
        }

        return goal == 0
    }
}

fun main() {
    val sol = Solution()
    println(sol.canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(sol.canJump(intArrayOf(3, 2, 1, 0, 4)))
}