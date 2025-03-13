package problems.ZeroArrayTransformationII

// https://leetcode.com/problems/zero-array-transformation-ii/

private class Solution {
    // Line Sweep approach
    // Time: O(n + q), where n is the size of nums array, and q is the size of queries array.
    // Space: O(n)
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        // Initialize the array used for the Partial sum.
        val n = nums.size
        val arr = IntArray(n + 1)

        // Store the Prefix sum and the number of used queries.
        var sum = 0
        var idx = 0

        // Iterate over all the nums.
        for (i in 0..<n) {
            // Check if the current number can be smaller than or equal to 0
            // after the current number of queries (idx).
            while (arr[i] + sum < nums[i]) {
                // There are no more queries to use, so we can't form a zero array.
                if (idx == queries.size) {
                    return -1
                }

                // Extract the next query and increase the idx.
                val (l, r, v) = queries[idx]
                idx++

                // If the current query doesn't change the current number, continue to the next one.
                if (r < i) {
                    continue
                }

                // Update the range of the current query.
                arr[maxOf(i, l)] += v
                arr[r + 1] -= v
            }

            // Update the prefix sum.
            sum += arr[i]
        }

        // Return the number of queries used.
        return idx
    }

    // Use Binary Search, Prefix Sum, and Partial Sum to get the lower number of queries that results in a zero array.
    // Time: O(log q * (n + q)), where n is the size of nums array, and q is the size of queries array.
    // Space: O(n)
    /*fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        // Use the Prefix Sum and Partial Sum to check if the current number
        // of queries can result in a zero array.
        fun canBeZero(q: Int): Boolean {
            // Initialize the array used for the Partial Sum.
            val n = nums.size
            val arr = IntArray(n + 1)

            // Update the range of all queries until the index we test.
            for (i in 0..<q) { // O(q)
                val (l, r, v) = queries[i]
                arr[l] += v
                arr[r + 1] -= v
            }

            // Use the prefix sum to check if all the values of nums
            // will be smaller than or equal to 0.
            var sum = 0
            for (i in 0..<n) { // O(n)
                // Update the prefix sum.
                sum += arr[i]

                // If the current item is not smaller than or equal to 0, we can't
                // form a zero array using the current number of queries.
                if (nums[i] - sum > 0) {
                    return false
                }
            }

            // We can form a zero array using the current number of queries.
            return true
        }

        // Initialize the left and right pointers, and the result.
        var left = 0
        var right = queries.size
        var cur = -1

        // Search for the lower bound.
        while (left <= right) { // O(log q)
            val mid = (left + right) / 2

            // If the current number of queries (mid pointer) can result in a zero
            // array, try to minimize the result, and if not, try a bigger number.
            if (canBeZero(mid)) {
                cur = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return cur
    }*/
}

fun main() {
    val sol = Solution()

    println(
        sol.minZeroArray(
            intArrayOf(2, 0, 2),
            arrayOf(
                intArrayOf(0, 2, 1),
                intArrayOf(0, 2, 1),
                intArrayOf(1, 1, 3)
            )
        )
    )

    println(
        sol.minZeroArray(
            intArrayOf(4, 3, 2, 1),
            arrayOf(
                intArrayOf(1, 3, 2),
                intArrayOf(0, 2, 1)
            )
        )
    )
}