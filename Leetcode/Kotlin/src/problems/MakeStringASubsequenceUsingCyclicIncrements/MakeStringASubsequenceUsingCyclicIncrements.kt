package problems.MakeStringASubsequenceUsingCyclicIncrements

// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        // If the second size is bigger, we can't get it from the first
        if (str2.length > str1.length) return false

        // Pointer for each string
        var i = 0
        var j = 0
        while (i < str1.length && j < str2.length) {
            // Check if the current character of the second can be matched
            if (canBeMatched(str1[i], str2[j])) {
                j++
            }

            // We will loop over the first string any way
            i++
        }

        // If we reached the last character of the second, we can get the whole string
        return (j == str2.length)
    }

    // Check if they are currently matched, or after a single operation
    private fun canBeMatched(c1: Char, c2: Char): Boolean {
        if (c1 == c2) return true
        val next = if (c1 == 'z') 'a' else c1 + 1
        return (next == c2)
    }
}

fun main() {
    val sol = Solution()
    println(sol.canMakeSubsequence("abc", "ad"))
    println(sol.canMakeSubsequence("zc", "ad"))
    println(sol.canMakeSubsequence("ab", "d"))
}