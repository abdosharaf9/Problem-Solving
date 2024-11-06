package problems.FindIfArrayCanBeSorted

// https://leetcode.com/problems/find-if-array-can-be-sorted/

private class Solution {
    fun canSortArray(nums: IntArray): Boolean {
        var curMin = nums[0]
        var curMax = nums[0]
        var prevMax = Int.MIN_VALUE

        for (n in nums) {
            if (n.countOneBits() == curMax.countOneBits()) {
                curMax = maxOf(n, curMax)
                curMin = minOf(n, curMin)
            } else if (prevMax < curMin) {
                prevMax = curMax
                curMin = n
                curMax = n
            } else {
                return false
            }
        }

        return prevMax <= curMin
    }
}

fun main() {
    val sol = Solution()
    println(sol.canSortArray(intArrayOf(8, 4, 2, 30, 15)))
    println(sol.canSortArray(intArrayOf(1, 2, 3, 4, 5)))
    println(sol.canSortArray(intArrayOf(3, 16, 8, 4, 2)))
}