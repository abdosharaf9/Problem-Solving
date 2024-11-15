package problems.ShortestSubarrayToBeRemovedToMakeArraySorted

// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

private class Solution {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        val n = arr.size
        var r = n - 1

        // Remove prefix
        while (r > 0 && arr[r - 1] <= arr[r]) r--

        var res = r

        // Remove postfix or middle
        var l = 0
        while (l < r) {
            // Expand invalid window
            while (r < n && arr[l] > arr[r]) r++

            res = minOf(res, r - 1 - l)

            if (arr[l] > arr[l + 1]) break

            l++
        }

        return res
    }

    /*fun findLengthOfShortestSubarray(arr: IntArray): Int {
        val n = arr.size
        var r = n - 1

        // Remove prefix
        while (r > 0 && arr[r - 1] <= arr[r]) r--

        var res = r

        // Remove postfix
        var l = 0
        while (l + 1 < n && arr[l] <= arr[l + 1]) l++

        res = minOf(res, n - 1 - l)

        // Remove middle
        l = 0
        r = n - 1
        while (l < r) {
            // Shrink valid window
            while (r < n && l + 1 < r && arr[r - 1] <= arr[r] && arr[l] <= arr[r]) r--

            // Expand invalid window
            while (r < n && arr[l] > arr[r]) r++

            res = minOf(res, r - 1 - l)

            if (arr[l] > arr[l + 1]) break

            l++
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.findLengthOfShortestSubarray(intArrayOf(1, 2, 3, 10, 4, 2, 3, 5)))
    println(sol.findLengthOfShortestSubarray(intArrayOf(5, 4, 3, 2, 1)))
    println(sol.findLengthOfShortestSubarray(intArrayOf(1, 2, 3)))
}