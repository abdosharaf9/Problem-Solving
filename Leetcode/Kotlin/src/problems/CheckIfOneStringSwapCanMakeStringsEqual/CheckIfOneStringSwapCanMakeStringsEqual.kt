package problems.CheckIfOneStringSwapCanMakeStringsEqual

// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        // Store the indices of the two different characters, because if
        // there is more than two, we can't make the swap.
        var diff1 = -1
        var diff2 = -1

        // Loop over all the characters to match them.
        for (i in 0..s1.lastIndex) {
            // The characters in the same index aren't matched.
            if (s1[i] != s2[i]) {
                if (diff1 == -1) {
                    // Store the first different index.
                    diff1 = i
                } else if (diff2 == -1) {
                    // Store the second different index.
                    diff2 = i
                } else {
                    // When there is a third different, there is no way to match them.
                    return false
                }
            }
        }

        // If both are still -1, they are equal already.
        if (maxOf(diff1, diff2) == -1) {
            return true
        }

        // If only one of them is -1, this means there is a single different
        // index, and we can't perform the swap
        if (minOf(diff1, diff2) == -1) {
            return false
        }

        // If we have two indices, check if the characters in them are
        // equal to perform the swap.
        return s1[diff1] == s2[diff2] && s1[diff2] == s2[diff1]
    }
}

fun main() {
    val sol = Solution()
    println(sol.areAlmostEqual(s1 = "bank", s2 = "kanb"))
    println(sol.areAlmostEqual(s1 = "attack", s2 = "defend"))
    println(sol.areAlmostEqual(s1 = "kelb", s2 = "kelb"))
}