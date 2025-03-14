package problems.ZeroArrayTransformationI

// https://leetcode.com/problems/zero-array-transformation-i/

private class Solution {
    // Line Sweep approach
    // Time: O(n + q), where n is the size of nums array, and q is the size of queries array.
    // Space: O(n)
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        // Initialize the array used for the Partial sum.
        val n = nums.size
        val arr = IntArray(n + 1)

        // Store the Prefix sum and the index of used queries.
        var sum = 0
        var idx = 0

        // Iterate over all the nums.
        for (i in 0..<n) {
            // Check if the current number can be smaller than or equal to 0
            // after the current number of queries (idx).
            while (arr[i] + sum < nums[i]) {
                // There are no more queries to use, so we can't form a zero array.
                if (idx == queries.size) {
                    return false
                }

                // Extract the next query and increase the idx.
                val (l, r) = queries[idx]
                idx++

                // If the current query doesn't change the current number, continue to the next one.
                if (r < i) {
                    continue
                }

                // Update the range of the current query.
                arr[maxOf(i, l)]++
                arr[r + 1]--
            }

            // Update the prefix sum.
            sum += arr[i]
        }

        // We can form a zero array.
        return true
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.isZeroArray(
            intArrayOf(1, 0, 1),
            arrayOf(
                intArrayOf(0, 2)
            )
        )
    )

    println(
        sol.isZeroArray(
            intArrayOf(4, 3, 2, 1),
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(0, 2)
            )
        )
    )
}