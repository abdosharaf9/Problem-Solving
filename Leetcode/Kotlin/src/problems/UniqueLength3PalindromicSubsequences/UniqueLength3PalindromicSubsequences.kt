package problems.UniqueLength3PalindromicSubsequences

// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/

private class Solution {
    // Time: O(n)
    // Space: O(26^3) -> O(1), because at most we will store 26^3 unique palindromes.
    // Because we check about string of length 3, we just need to check about the
    // two characters on the left and the right. This will allow us to loop over all
    // the characters to use them as a middle character, and see how many characters
    // on both sides are equal to form a palindrome.
    fun countPalindromicSubsequence(s: String): Int {
        // Count letters on the right side of the middle character.
        val right = IntArray(26) { 0 }
        for (c in s) {
            right[c - 'a']++
        }

        // Store the unique left characters.
        val left = mutableSetOf<Char>()

        // Store the unique palindromes.
        val res = mutableSetOf<String>()

        // Loop over all characters to use them as a middle character.
        for (mid in s) {
            // Remove the current character from the right side.
            right[mid - 'a']--

            // Count the equal characters on the both sides.
            for (c in left) {
                if (right[c - 'a'] > 0) {
                    res.add("$c$mid")
                }
            }

            // Add the current character to the left side.
            left.add(mid)
        }

        // Return the count of unique palindromes.
        return res.size
    }
}

fun main() {
    val sol = Solution()
    println(sol.countPalindromicSubsequence("aabca"))
    println(sol.countPalindromicSubsequence("adc"))
    println(sol.countPalindromicSubsequence("bbcbaba"))
}