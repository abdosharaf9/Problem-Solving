package problems.TheKthLexicographicalStringOfAllHappyStringsOfLengthN

import kotlin.math.pow

// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun getHappyString(n: Int, k: Int): String {
        // The total number of happy strings with size n comes from:
        //    - in the first spot, you have 3 choices for the current character.
        //    - for any other spot, you have just 2 choices for the current character.
        val totalHappy = 3 * (2.0.pow(n - 1)).toInt()

        // There won't be kth happy string.
        if (k > totalHappy) {
            return ""
        }

        // Store the result string.
        val res = StringBuilder()

        // The current choices we can choose from, which is initially is the 3 characters.
        // Also, we use this map to easily get the choices we will have for the next character.
        var choices = "abc"
        val nextChar = mapOf('a' to "bc", 'b' to "ac", 'c' to "ab")

        // The bounds of the happy string number, which is initially equal to all the strings.
        var left = 1
        var right = totalHappy

        // The string will have n characters.
        repeat(n) {
            // If we draw a decision tree for the choices, we will see that the tree is
            // a full/complete tree, which means in each step we have the same number of
            // choices to choose from. Here we calculate the range of each branch and see
            // in which range our k exists to go deeper in that branch.

            // For example, if we have a total of 12 happy strings and k = 3, in the first
            // step, we have 3 choices with 3 branches, thus each one of them has 4 (12/3)
            // strings. Our desired string (k=3) exists in the first one because 1 < k < 4
            // which is the first range. In the second step, we will be interested only in
            // all strings of the first branch, and the new range is 1:4, but this time we
            // have 2 choices (1:2 & 3:4), and our k is in the second one. AND SO ON......

            // Used to check each partition, and the first one will start at the left boundary.
            var cur = left

            // Calculate the partition size according to the total number of strings in the
            // current range divided by the number of choices we have now.
            val partitionSize = (right - left + 1) / choices.length

            // Try the choices we have by checking the range of each one if it contains the k.
            for (c in choices) {
                // If we found the range that contains the k, we use this character as our choice,
                // and update the range and the choices.
                if (k in cur..<cur + partitionSize) {
                    res.append(c)
                    left = cur
                    // The -1 is because both the range start and end is included.
                    right = cur + partitionSize - 1
                    choices = nextChar[c]!!

                    // Make sure to break the loop because we already made a choice.
                    break
                }

                // Go to the next range (branch).
                cur += partitionSize
            }
        }

        return res.toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.getHappyString(1, 3))
    println(sol.getHappyString(1, 4))
    println(sol.getHappyString(3, 9))
}