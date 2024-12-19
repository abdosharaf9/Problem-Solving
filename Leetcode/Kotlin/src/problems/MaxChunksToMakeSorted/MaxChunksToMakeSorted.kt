package problems.MaxChunksToMakeSorted

// https://leetcode.com/problems/max-chunks-to-make-sorted/

private class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        var count = 0
        var curMax = -1

        for (i in arr.indices) {
            curMax = maxOf(curMax, arr[i])
            if (curMax == i) count++
        }

        return count
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxChunksToSorted(intArrayOf(4, 3, 2, 1, 0)))
    println(sol.maxChunksToSorted(intArrayOf(1, 0, 2, 3, 4)))
}