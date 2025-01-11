package problems.ConstructKPalindromeStrings

// https://leetcode.com/problems/construct-k-palindrome-strings/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun canConstruct(s: String, k: Int): Boolean {
        // If the string size is smaller that k, we can't
        // form this number of palindromes anyway.
        if (s.length < k) return false

        // Count the frequency of each character in the string.
        val counts = IntArray(26) { 0 }
        for (c in s) {
            counts[c - 'a']++
        }

        // We can for the number of palindromes we need if the
        // number of odd frequencies is smaller than or equal to
        // k. We can put those characters in the middle and the
        // other on both sides and form the intended number of palindromes.
        // Ex: [a: 2, b: 2, c: 2, d: 1], k = 2 ==> abcdcba, bacdcab, ...etc.
        return counts.count { it % 2 == 1 } <= k
    }
}

fun main() {
    val sol = Solution()
    println(sol.canConstruct("annabelle", 2))
    println(sol.canConstruct("leetcode", 3))
    println(sol.canConstruct("true", 4))
}