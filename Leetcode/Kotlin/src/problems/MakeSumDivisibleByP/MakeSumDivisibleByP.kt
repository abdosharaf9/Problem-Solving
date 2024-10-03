package problems.MakeSumDivisibleByP

import kotlin.math.min

// https://leetcode.com/problems/make-sum-divisible-by-p/

private class Solution {
    fun minSubarray(nums: IntArray, p: Int): Int {
        val goal = nums.sumOf { it.toLong() } % p
        if (goal == 0L) return 0

        val mp = mutableMapOf(0L to -1)
        var result = nums.size
        var sum = 0L

        for (i in nums.indices) {
            sum += nums[i]
            sum %= p
            val search = (sum - goal + p) % p
            if (mp.containsKey(search)) {
                result = min(result, i - mp[search]!!)
            }
            mp[sum] = i
        }

        return if (result == nums.size) -1 else result
    }
}

fun main() {
    val sol = Solution()
    println(sol.minSubarray(intArrayOf(3, 1, 4, 2), 6))
    println(sol.minSubarray(intArrayOf(6, 3, 5, 2), 9))
    println(sol.minSubarray(intArrayOf(1, 2, 3), 3))
    println(sol.minSubarray(intArrayOf(1000000000, 1000000000, 1000000000), 3))
}