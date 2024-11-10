package problems.ShortestSubarrayWithORAtLeastKII

// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/

private class Solution {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var res = Int.MAX_VALUE
        val bits = IntArray(32) { 0 }

        fun updateBits(num: Int, diff: Int) {
            for (i in 0..31) {
                if (num and (1 shl i) != 0) {
                    bits[i] += diff
                }
            }
        }

        fun bitsToInt(): Int {
            var num = 0
            for (i in 0..31) {
                if (bits[i] != 0) {
                    num += 1 shl i
                }
            }

            return num
        }


        var left = 0
        for (r in 0..nums.lastIndex) {
            updateBits(nums[r], 1)
            var curOr = bitsToInt()

            while (left <= r && curOr >= k) {
                res = minOf(res, r - left + 1)
                updateBits(nums[left], -1)
                curOr = bitsToInt()
                left++
            }
        }

        return if (res == Int.MAX_VALUE) -1 else res
    }
}

fun main() {
    val sol = Solution()
    println(sol.minimumSubarrayLength(intArrayOf(1, 2, 3), 2))
    println(sol.minimumSubarrayLength(intArrayOf(2, 1, 8), 10))
    println(sol.minimumSubarrayLength(intArrayOf(1, 2), 0))
}