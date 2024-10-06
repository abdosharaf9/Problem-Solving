package problems.SentenceSimilarityIII

// https://leetcode.com/problems/sentence-similarity-iii/

private class Solution {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        val (s1, s2) = if (sentence1.length < sentence2.length) {
            sentence1.split(" ") to sentence2.split(" ")
        } else {
            sentence2.split(" ") to sentence1.split(" ")
        }


        var left = 0
        while (left <= s1.lastIndex && s1[left] == s2[left]) {
            left++
        }

        var right1 = s1.lastIndex
        var right2 = s2.lastIndex
        while (right1 >= left && right2 >= 0 && s1[right1] == s2[right2]) {
            right1--
            right2--
        }

        return left > right1
    }
}

fun main() {
    val sol = Solution()
    println(sol.areSentencesSimilar("My name is Haley", "My Haley"))
    println(sol.areSentencesSimilar("of", "A lot of words"))
    println(sol.areSentencesSimilar("Eating right now", "Eating"))
}