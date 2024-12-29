package problems.NumberOfWaysToFormATargetStringGivenADictionary

// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

private class Solution {
    // Time: O(n * m + m * t), where:
    //     - n is the number of words.
    //     - m is the word size.
    //     - t is the target size.
    // Space: O(m * t), which is used to store the DP array.
    fun numWays(words: Array<String>, target: String): Int {
        val mod = 1_000_000_007
        val wordSize = words[0].length
        val targetSize = target.length

        // Calculate the frequency of each character in each column.
        val freq = Array(wordSize) { IntArray(26) { 0 } }
        for (word in words) {
            for (i in 0..<wordSize) {
                freq[i][word[i] - 'a']++
            }
        }

        // Add memoization to save the states.
        val dp = Array(wordSize) { IntArray(targetSize) { -1 } }

        fun countWays(column: Int, idx: Int): Int {
            // If we reached the end of the target, thus this is a valid way.
            if (idx == targetSize) {
                return 1
            }

            // If we ran out of columns, thus this is an invalid way.
            if (column == wordSize) {
                return 0
            }

            // If we calculated this state before.
            if (dp[column][idx] != -1) {
                return dp[column][idx]
            }

            // Calculate the number of ways we can form the target by ignoring
            // the current column.
            val waysByNotMatching = countWays(column + 1, idx)
            var total = waysByNotMatching

            // If the needed character is in the current column, calculate the
            // number of ways we can form the target by using it.
            val ch = target[idx] - 'a'
            if (freq[column][ch] != 0) {
                val waysByMatching = countWays(column + 1, idx + 1)
                total = ((total + waysByMatching * freq[column][ch].toLong()) % mod).toInt()
            }

            // Save the current state.
            dp[column][idx] = total

            return dp[column][idx]
        }

        return countWays(0, 0)
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.numWays(
            arrayOf("acca", "bbbb", "caca"),
            "aba"
        )
    )

    println(
        sol.numWays(
            arrayOf("abba", "baab"),
            "bab"
        )
    )
}