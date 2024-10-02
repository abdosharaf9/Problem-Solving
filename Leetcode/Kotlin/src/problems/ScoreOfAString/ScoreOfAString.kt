package problems.ScoreOfAString

// https://leetcode.com/problems/score-of-a-string

import kotlin.math.abs

private class Solution {
    fun scoreOfString(s: String): Int {
        var score = 0

        for (i in 0..s.length - 2) {
            score += abs(s[i].code - s[i + 1].code)
        }

        return score
    }
}

fun main() {
    val sol = Solution()
    print(sol.scoreOfString(s = "hello"))
    print(sol.scoreOfString(s = "zaz"))
}