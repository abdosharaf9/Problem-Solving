package problems.FindThePrefixCommonArrayOfTwoArrays

import utils.printArray

// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val n = A.size
        val res = IntArray(n) { 0 }

        // We will see the same number only two times at most, so
        // if we found its value equals true, this means we have
        // seen it before, and we can count it.
        val seen = BooleanArray(n + 1)

        // Loop over all the indices.
        for (i in 0..<n) {
            // The current count at least will be the same as the previous one.
            if (i != 0) {
                res[i] = res[i - 1]
            }

            // If the two numbers are equal, we just add 1 to the count.
            if (A[i] == B[i]) {
                res[i]++
            } else {
                // If not, we check about each one if we have seen it
                // before to add 1 to the count
                if (seen[A[i]]) {
                    res[i]++
                }

                if (seen[B[i]]) {
                    res[i]++
                }
            }

            // Mark both numbers as seen.
            seen[B[i]] = true
            seen[A[i]] = true
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.findThePrefixCommonArray(intArrayOf(1, 3, 2, 4), intArrayOf(3, 1, 2, 4)))
    printArray(sol.findThePrefixCommonArray(intArrayOf(2, 3, 1), intArrayOf(3, 1, 2)))
}