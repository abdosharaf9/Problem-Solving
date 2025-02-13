package problems.MinimumOperationsToExceedThresholdValueII

import java.util.PriorityQueue

// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

private class Solution {
    // Time: O(n * log n)
    // Space: O(n)
    fun minOperations(nums: IntArray, k: Int): Int {
        // Store the numbers in ascending order to get the minimum two easily.
        val queue = PriorityQueue<Long>()
        for (num in nums) {
            queue.add(num.toLong())
        }

        // Loop until the minimum number is bigger than or equal to k.
        var res = 0
        while (queue.isNotEmpty() && queue.peek() < k) {
            // Get the minimum two numbers
            val x = queue.poll()
            val y = queue.poll()

            // Perform the operation.
            queue.add(x * 2 + y)

            // Increase the count.
            res++
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.minOperations(intArrayOf(2, 11, 10, 1, 3), 10))
    println(sol.minOperations(intArrayOf(1, 1, 2, 4, 9), 20))
}