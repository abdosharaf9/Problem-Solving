package problems.NumberOfSubArraysWithOddSum

// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun numOfSubarrays(arr: IntArray): Int {
        // Store the prefix sum, number of subarrays with an odd sum,
        // number of subarrays with an even sum, and the result
        var curSum = 0
        var odd = 0
        var even = 0
        var res = 0

        for (num in arr) {
            // Accumulate the summation.
            curSum += num

            // The direct case would be if the current sum is odd, then
            // we can add 1 to the result.

            // If the current sum is even, we can make it odd by removing any
            // previous odd subarray to get a new odd one, and vice versa. So,
            // when the current sum is even, add to the result the number of
            // previous odd sums, and if it is odd, add to the result the number
            // of the previous even sums.

            // [1,3,5]
            // i = 0, curSum = 1, odd = 1, even = 0, res = 0 + 1 (direct) = 1
            // i = 1, curSum = 4, odd = 1, even = 1, res = 1 + 1 (odd) = 2
            // i = 2, curSum = 9, odd = 2, even = 1, res = 2 + 1 (direct) + 1 (even) = 4
            // When i = 2, the current sum is odd (9). We can directly add 1 to the result, and
            // we have 1 previous even subarray ([1,3]) which we can remove from the current sum
            // to get a new odd subarray. The result in this case will be res + 1 (direct) + 1 (even) = 4.
            if (curSum % 2 == 1) {
                res = (res + even + 1) % 1_000_000_007
                odd++
            } else {
                res = (res + odd) % 1_000_000_007
                even++
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.numOfSubarrays(intArrayOf(1, 3, 5)))
    println(sol.numOfSubarrays(intArrayOf(2, 4, 6)))
    println(sol.numOfSubarrays(intArrayOf(1, 2, 3, 4, 5, 6, 7)))
}