package problems.MaximumScoreAfterSplittingAString

// https://leetcode.com/problems/maximum-score-after-splitting-a-string/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun maxScore(s: String): Int {
        // Number of zeros in the left portion which is initially empty.
        var zeros = 0

        // Number of ones in the right portion which is initially the whole string.
        var ones = s.count { it == '1' }
        var res = 0

        // In each iteration, we decrease the left portion size by one and
        // increase the right portion size by one.
        for (i in 0..<s.lastIndex) {
            if (s[i] == '0') {
                // Increase the number of zeros in the left portion.
                zeros++
            } else {
                // Decrease the number of ones in the right portion.
                ones--
            }

            // Maximize the result.
            res = maxOf(res, zeros + ones)
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxScore("011101"))
    println(sol.maxScore("00111"))
    println(sol.maxScore("1111"))
}