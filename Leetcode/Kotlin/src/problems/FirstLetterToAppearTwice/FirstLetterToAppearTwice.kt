package problems.FirstLetterToAppearTwice

// https://leetcode.com/problems/first-letter-to-appear-twice/

private class Solution {
    fun repeatedCharacter(s: String): Char {
        val count = BooleanArray(26) { false }

        for (c in s) {
            if (count[c - 'a']) return c
            count[c - 'a'] = true
        }

        return 'a'
    }
}

fun main() {
    val sol = Solution()
    println(sol.repeatedCharacter("abccbaacz"))
    println(sol.repeatedCharacter("abcdd"))
}