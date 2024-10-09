package problems.MinimumAddToMakeParenthesesValid

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

private class Solution {
    fun minAddToMakeValid(s: String): Int {
        var open = 0
        var close = 0

        for (i in s.indices) {
            if (s[i] == '(') open++
            else if (open == 0) close++
            else open--
        }

        return open + close
    }
}

fun main() {
    val sol = Solution()
    println(sol.minAddToMakeValid("())"))
    println(sol.minAddToMakeValid("((("))
}