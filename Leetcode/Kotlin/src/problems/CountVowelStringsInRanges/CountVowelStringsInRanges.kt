package problems.CountVowelStringsInRanges

import utils.printArray

// https://leetcode.com/problems/count-vowel-strings-in-ranges/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        // Store the prefix count of words that start and end with vowels
        // with offset of one to ease the subtraction.
        val vowelWords = IntArray(words.size + 1) { 0 }

        // Used to easily access the vowels in Constant time.
        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        // Loop over the words and build the prefix count of the words.
        for ((i, word) in words.withIndex()) {
            val isVowel = if (word.first() in vowels && word.last() in vowels) 1 else 0

            // Note that we used the offset here also.
            vowelWords[i + 1] = vowelWords[i] + isVowel
        }

        // Populate the result by calculating: range end count - range start count.
        val ans = IntArray(queries.size) { 0 }
        for (i in queries.indices) {
            val (from, to) = queries[i]
            // Note that we used the offset here also to avoid the (-1) index exception.
            ans[i] = vowelWords[to + 1] - vowelWords[from]
        }

        return ans
    }
}

fun main() {
    val sol = Solution()

    printArray(
        sol.vowelStrings(
            arrayOf("aba", "bcb", "ece", "aa", "e"),
            arrayOf(
                intArrayOf(0, 2),
                intArrayOf(1, 4),
                intArrayOf(1, 1)
            )
        )
    )

    printArray(
        sol.vowelStrings(
            arrayOf("a", "e", "i"),
            arrayOf(
                intArrayOf(0, 2),
                intArrayOf(0, 1),
                intArrayOf(2, 2)
            )
        )
    )
}