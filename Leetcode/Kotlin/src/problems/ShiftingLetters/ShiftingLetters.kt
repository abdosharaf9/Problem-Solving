package problems.ShiftingLetters

// https://leetcode.com/problems/shifting-letters/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun shiftingLetters(s: String, shifts: IntArray): String {
        // Store all the changes and apply it later at once. We only
        // mark the start index and the end index to avoid the nested
        // loops in applying changes. Later we will perform a prefix
        // sum to get the overall shifts applied to the current position.
        val changes = IntArray(s.length + 1) { 0 }

        // Mark the boundaries of each shift.
        shifts.forEachIndexed { idx, shift ->
            changes[0] += shift % 26

            // When summing all the values in the future, this will be 0
            // because the (-change) is added to (+change) coming from the
            // previous index which gives 0.
            changes[idx + 1] -= shift % 26
        }

        // Summing the values and apply the shift value to each character.
        val res = StringBuilder("")
        for (i in s.indices) {
            if (i > 0) changes[i] += changes[i - 1]
            res.append(shiftLetter(s[i], changes[i]))
        }

        return res.toString()
    }

    // Getting the new letter after applying the shift with taking in mind,
    // we need to wrap the values if it gets out of the 'a-z' range.
    fun shiftLetter(c: Char, shift: Int): Char {
        val newPosition = (c - 'a' + shift).mod(26)
        return 'a' + newPosition
    }
}

fun main() {
    val sol = Solution()
    println(sol.shiftingLetters("abc", intArrayOf(3, 5, 9)))
    println(sol.shiftingLetters("aaa", intArrayOf(1, 2, 3)))
}