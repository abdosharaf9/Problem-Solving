package problems.NumberOfSubstringsContainingAllThreeCharacters

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

private class Solution {
    // Time: O(n)
    // Space: O(1), actually we use an array to store the frequencies, but it just stores 3 characters.
    fun numberOfSubstrings(s: String): Int {
        // Store the frequency of each character.
        val freq = IntArray(3)

        // Initialize the left pointer, and the result.
        var res = 0
        var left = 0

        // Use the Sliding Window approach.
        for (r in s.indices) {
            // Update the frequencies.
            freq[s[r] - 'a']++

            // While the current window is valid, increase the result and shrink
            // the window from the left to try a new starting point.
            while (freq.all { it > 0 }) {
                // Because the window doesn't have to be of a fixed size, so we are
                // sure that evey coming window that starts at the left pointer and
                // contains the right pointer will be valid as well. Thus, count them
                // in a single iteration and start a new window.
                res += s.length - r

                // Shrink the window from the left and update the frequencies.
                freq[s[left] - 'a']--
                left++
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.numberOfSubstrings("abcabc"))
    println(sol.numberOfSubstrings("aaacb"))
    println(sol.numberOfSubstrings("abc"))
}