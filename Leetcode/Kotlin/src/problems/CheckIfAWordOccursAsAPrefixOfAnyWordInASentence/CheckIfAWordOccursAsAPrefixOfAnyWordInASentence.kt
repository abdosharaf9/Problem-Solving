package problems.CheckIfAWordOccursAsAPrefixOfAnyWordInASentence

// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

private class Solution {

    // Time: O(n), and it will be faster because there is no splitting and substrings
    // Space: O(1)
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        // Word index
        var word = 1
        // Character index
        var j = 0
        // If the current word still valid
        var isSolution = true

        for (c in sentence) {
            if (c == ' ') {
                // Stated a new word
                isSolution = true
                word++
                j = 0
            } else if (isSolution && searchWord[j] == c) {
                // The characters are matched
                j++
            } else {
                // The characters are not matched
                isSolution = false
            }

            // Check if we reached the last character and they all are matched
            if (j == searchWord.length) {
                return word
            }
        }

        return -1
    }

    // Time: O(n)
    // Space: O(n)
    /*fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        // Get every word and check if its prefix with the same
        // search word size is the desired prefix
        val words = sentence.split(" ")
        val end = searchWord.length

        words.forEachIndexed { i, word ->
            if (
                word.length >= searchWord.length &&
                word.substring(0, end) == searchWord
            ) {
                return i + 1
            }
        }

        return -1
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.isPrefixOfWord("i love eating burger", "burg"))
    println(sol.isPrefixOfWord("this problem is an easy problem", "pro"))
    println(sol.isPrefixOfWord("i am tired", "you"))
}