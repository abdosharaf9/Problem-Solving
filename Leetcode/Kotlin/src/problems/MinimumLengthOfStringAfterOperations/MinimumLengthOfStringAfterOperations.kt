package problems.MinimumLengthOfStringAfterOperations

// https://leetcode.com/problems/minimum-length-of-string-after-operations/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun minimumLength(s: String): Int {
        // Store counts of each character.
        val counts = IntArray(26)
        for (c in s) {
            counts[c - 'a']++
        }

        var res = 0

        // Loop over each count and see if the count is bigger
        // than 2, we can delete 2 of those occurrences. We keep
        // doing this until the count is no longer bigger than 2.
        // If the count of 'a' is 3, so we have "a.a...a" in
        // somewhere of the string, and we don't care about those
        // positions, we just need the count after deleting them.
        for (i in 0..25) {
            while (counts[i] > 2) {
                counts[i] -= 2
            }

            res += counts[i]
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.minimumLength("abaacbcbb"))
    println(sol.minimumLength("aa"))
}