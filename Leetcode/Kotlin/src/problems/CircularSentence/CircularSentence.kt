package problems.CircularSentence

// https://leetcode.com/problems/circular-sentence/

private class Solution {
    fun isCircularSentence(sentence: String): Boolean {
        if (sentence == "") return false

        for (i in 0..sentence.lastIndex) {
            if (sentence[i] == ' ') {
                if (sentence[i - 1] != sentence[i + 1]) return false
            }
        }

        return sentence[0] == sentence.last()
    }

    /*fun isCircularSentence(sentence: String): Boolean {
        val words = sentence.split(" ")

        for (i in 1..words.lastIndex) {
            if (words[i][0] != words[i - 1].last()) return false
        }

        return words[0][0] == words.last().last()
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.isCircularSentence("leetcode exercises sound delightful"))
    println(sol.isCircularSentence("eetcode"))
    println(sol.isCircularSentence("Leetcode is cool"))
}