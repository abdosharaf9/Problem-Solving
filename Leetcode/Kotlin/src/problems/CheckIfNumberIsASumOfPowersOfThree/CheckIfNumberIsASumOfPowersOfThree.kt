package problems.CheckIfNumberIsASumOfPowersOfThree

import kotlin.math.pow

// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

private class Solution {
    // Time: O(log3 n)
    // Space: O(1)
    fun checkPowersOfThree(n: Int): Boolean {
        // If there is any power of 3 is needed twice, thus we can't
        // reach n using unique powers of 3.
        var num = n
        while (num > 0) {
            val digit = num % 3
            num /= 3

            if (digit == 2) {
                return false
            }
        }

        return true
    }

    // Time: O(2^(log3 n))
    // Space: O(1)
    /*fun checkPowersOfThree(n: Int): Boolean {
        // Use backtracking to check the possibility of including or skipping each power of 3.
        fun backtrack(i: Int, cur: Int): Boolean {
            // We can reach n.
            if (cur == n) {
                return true
            }

            // The current power of 3.
            val p = (3.0.pow(i)).toInt()

            // We can't reach n.
            if (cur > n || p > n) {
                return false
            }

            // include
            if (backtrack(i + 1, cur + p)) {
                return true
            }

            // skip
            return backtrack(i + 1, cur)
        }

        return backtrack(0, 0)
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.checkPowersOfThree(12))
    println(sol.checkPowersOfThree(91))
    println(sol.checkPowersOfThree(21))
}