package problems.SeparateBlackAndWhiteBalls

// https://leetcode.com/problems/separate-black-and-white-balls/

private class Solution {
    fun minimumSteps(s: String): Long {
        var result = 0L
        var left = 0

        for (right in s.indices) {
            if (s[right] == '0') {
                result += right - left
                left++
            }
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.minimumSteps("101"))
    println(sol.minimumSteps("100"))
    println(sol.minimumSteps("0111"))
}