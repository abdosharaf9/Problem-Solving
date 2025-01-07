package problems.StringMatchingInAnArray

import utils.printArray

// https://leetcode.com/problems/string-matching-in-an-array/

private class Solution {
    // This solution is simple, but it is better for small inputs,
    // and it will perform poorly with large inputs.
    // Time: O(n^2 * k^2)
    // Space: O(n)
    fun stringMatching(words: Array<String>): List<String> {
        // Store the output.
        val result = arrayListOf<String>()

        // Loop over all the words and for each word, check if it is
        // a sub-string of another word in the array.
        for (i in words.indices) {
            for (j in words.indices) {
                // Make sure that we aren't checking the same word.
                if (i != j && words[i] in words[j]) {
                    result.add(words[i])

                    // Because the current word is already considered.
                    break
                }
            }
        }

        return result
    }

    // The simplest and most concise solution using the built-in functions.
    // It is better for small inputs, and it will perform poorly with large inputs.
    // Time: O(n^2 * k^2)
    // Space: O(n)
    /*fun stringMatching(words: Array<String>): List<String> {
        // We filter the array to keep only the words that are
        // a sub-string of another word.
        return words.filter { word ->
            words.any {
                // Make sure we are not matching the same word.
                it != word && it in word
            }
        }
    }*/

    // This is a more efficient solution, but it is better for
    // large inputs, not these small constraints.
    // Time: O(n * k^2), where n is the size of words' array, and k is the length of each word
    // Space: O(n * k^2), because we will save all the sub-strings.
    /*fun stringMatching(words: Array<String>): List<String> {
        // Store all the unique sub-strings.
        val subs = mutableSetOf<String>()

        // Loop over all the words and generate all the sub-strings
        // of each one of them.
        for (word in words) {
            for (i in word.indices) {
                for (j in i..word.lastIndex) {
                    // We don't need the whole word.
                    if (i == 0 && j == word.lastIndex) continue

                    // Store the sub-string.
                    subs.add(word.substring(i, j + 1))
                }
            }
        }

        // Loop over all the words and check if the current word
        // is saved in the sub-strings set.
        val result = mutableListOf<String>()
        for (word in words) {
            if (word in subs) {
                result.add(word)
            }
        }

        return result
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.stringMatching(arrayOf("mass", "as", "hero", "superhero")))
    printArray(sol.stringMatching(arrayOf("leetcode", "et", "code")))
    printArray(sol.stringMatching(arrayOf("blue", "green", "bu")))
}