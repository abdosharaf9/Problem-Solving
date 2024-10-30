package problems.MinimumNumberOfRemovalsToMakeMountainArray

// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/

private class Solution {
    fun minimumMountainRemovals(nums: IntArray): Int {
        val n = nums.size

        val lds = IntArray(n) { 1 }
        for (i in n - 1 downTo 0) {
            for (j in i..<n) {
                if (nums[j] < nums[i]) lds[i] = maxOf(lds[j] + 1, lds[i])
            }
        }

        val lis = IntArray(n) { 1 }
        var result = n
        for (i in 0..<n) {
            for (j in 0..i) {
                if (nums[j] < nums[i]) lis[i] = maxOf(lis[j] + 1, lis[i])
            }

            if (i in 1..<n - 1 && lis[i] > 1 && lds[i] > 1) {
                result = minOf(
                    result,
                    n - lis[i] - lds[i] + 1
                )
            }
        }

        return result
    }

    /*fun minimumMountainRemovals(nums: IntArray): Int {
        val n = nums.size

        val lis = IntArray(n) { 1 }
        for (i in 0..<n) {
            for (j in 0..i) {
                if (nums[j] < nums[i]) lis[i] = maxOf(lis[j] + 1, lis[i])
            }
        }

        val lds = IntArray(n) { 1 }
        for (i in n - 1 downTo 0) {
            for (j in i..<n) {
                if (nums[j] < nums[i]) lds[i] = maxOf(lds[j] + 1, lds[i])
            }
        }

        var result = n
        for (i in 1..<n - 1) {
            if (lis[i] > 1 && lds[i] > 1) {
                result = minOf(
                    result,
                    n - lis[i] - lds[i] + 1
                )
            }
        }

        return result
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.minimumMountainRemovals(intArrayOf(1, 3, 1)))
    println(sol.minimumMountainRemovals(intArrayOf(2, 1, 1, 5, 6, 2, 3, 1)))
}