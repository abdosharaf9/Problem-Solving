package problems.WordSubsets

import utils.printArray

// https://leetcode.com/problems/word-subsets/

private class Solution {
    // Time: O(n * l1 + m * l2), where:
    //      - n is the size of words1
    //      - l1 is the number of characters in each word of words1
    //      - m is the size of words2
    //      - l2 is the number of characters in each word of words2
    // Space: O(1), because we only use arrays with size 26 alongside with the output list.
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        // Return an IntArray with size 26 that contains count of
        // each character in the input word.
        fun countChars(word: String): IntArray {
            val counter = IntArray(26) { 0 }
            for (c in word) {
                counter[c - 'a']++
            }
            return counter
        }

        // Store the maximum counts of characters in words2. We combined
        // all the counts in a single array to make the comparing much
        // easier instead of dealing with all the counters.
        val counts2 = IntArray(26) { 0 }
        for (word in words2) {
            // Characters counts of the current word.
            val counter = countChars(word)

            // Update the maximum counts of words2.
            for (i in 0..25) {
                counts2[i] = maxOf(counts2[i], counter[i])
            }
        }

        val res = arrayListOf<String>()

        // Loop over each word and get its counter, then compare it
        // with the words2 max counts. If the word contains the same
        // counts or more, we consider it in the output list.
        for (word in words1) {
            // Characters counts of the current word.
            val counter = countChars(word)

            // Used to know if all counts are valid.
            var flag = true

            // Compare all the counts of the current word and the words2.
            for (i in 0..25) {
                if (counter[i] < counts2[i]) {
                    flag = false
                    break
                }
            }

            // Add it to the result if the count is valid.
            if (flag) {
                res.add(word)
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("e", "o")))
    printArray(sol.wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("l", "e")))
}