package problems.CountPrefixAndSuffixPairsI

// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/

private class Solution {
    // Time: O(n^2 * l), where l is the length of each word.
    // Space: O(1)
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        // Check if a word is a prefix and suffix of another word.
        fun isPrefixAndSuffix(str1: String, str2: String): Boolean {
            val size1 = str1.length
            val size2 = str2.length

            // If the size is bigger, there is no way to be a prefix or a suffix.
            if (size1 > size2) return false

            // Slice the word to check if the first and last parts are
            // equal to the second word.
            return (str2.substring(0, size1) == str1 && str2.substring(size2 - size1) == str1)

            // Using the built-in functions
            // return (str2.startsWith(str1) && str2.endsWith(str1))
        }

        var res = 0
        for (i in words.indices) {
            // Loop over the words to the right of the current one.
            for (j in i + 1..words.lastIndex) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    // Update the count.
                    res++
                }
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.countPrefixSuffixPairs(arrayOf("a", "aba", "ababa", "aa")))
    println(sol.countPrefixSuffixPairs(arrayOf("pa", "papa", "ma", "mama")))
    println(sol.countPrefixSuffixPairs(arrayOf("abab", "ab")))
}