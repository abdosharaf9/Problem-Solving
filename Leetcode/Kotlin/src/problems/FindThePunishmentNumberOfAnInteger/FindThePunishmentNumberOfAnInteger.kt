package problems.FindThePunishmentNumberOfAnInteger

// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/

private class Solution {
    // Time: O(n^2), because in each iteration we use the recursive function that runs in O(n).
    // Space: O(1), because we don't use any extra space rather than the call stack which takes O(log n).
    fun punishmentNumber(n: Int): Int {
        // Check if we can partition the squared number's string such that
        // the sum of partitions equals the target number.
        fun canPartition(idx: Int, cur: Int, target: Int, str: String): Boolean { // O(n)
            // If we have processed the entire string and sum equals target, return true.
            if (idx == str.length && cur == target) {
                return true
            }

            // Try all possible partitions of the string from index `idx` to the end.
            for (i in idx..str.lastIndex) {
                // Extract substring from `idx` to `i` and convert to integer.
                val newCur = str.substring(idx, i + 1).toInt() + cur

                // Recursively check if this partitioning leads to a valid sum.
                if (canPartition(i + 1, newCur, target, str)) {
                    return true
                }
            }

            // If we can't partition the number.
            return false
        }

        // Iterate from 1 to n to check each number.
        var res = 0
        for (i in 1..n) { // O(n)
            // Check if i^2 can be partitioned into parts summing to `i`.
            if (canPartition(0, 0, i, (i * i).toString())) {
                // Add to the result if it satisfies the condition.
                res += i * i
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.punishmentNumber(10))
    println(sol.punishmentNumber(37))
}