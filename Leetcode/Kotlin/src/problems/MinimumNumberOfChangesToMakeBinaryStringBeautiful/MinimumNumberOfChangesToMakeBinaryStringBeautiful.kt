package problems.MinimumNumberOfChangesToMakeBinaryStringBeautiful

// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

private class Solution {
    fun minChanges(s: String): Int {
        var count = 0
        for (i in 0..<s.lastIndex step 2) {
            if (s[i] != s[i + 1]) count++
        }

        return count
    }
}

fun main() {
    val sol = Solution()
    println(sol.minChanges("1001"))
    println(sol.minChanges("10"))
    println(sol.minChanges("0000"))
}