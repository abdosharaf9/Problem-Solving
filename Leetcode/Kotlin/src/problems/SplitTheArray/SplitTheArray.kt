package problems.SplitTheArray

// https://leetcode.com/problems/split-the-array/

private class Solution {
    fun isPossibleToSplit(nums: IntArray): Boolean {
        val counts = IntArray(101) { 0 }

        for (x in nums) {
            counts[x]++
        }

        for (count in counts) {
            if (count > 2) return false
        }

        return true
    }

    /*fun isPossibleToSplit(nums: IntArray): Boolean {
        val counts = mutableMapOf<Int, Int>()

        for (x in nums) {
            counts[x] = counts.getOrPut(x) { 0 } + 1
            if (counts[x]!! > 2) return false
        }

        for (value in counts.values) {
            if (value > 2) return false
        }

        return true
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.isPossibleToSplit(intArrayOf(1, 1, 2, 2, 3, 4)))
    println(sol.isPossibleToSplit(intArrayOf(1, 1, 1, 1)))
}