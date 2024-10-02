package problems.SumOfPrefixScoresOfStrings

import utils.printArray

// https://leetcode.com/problems/sum-of-prefix-scores-of-strings/

private data class PrefixTreeNode(
    var count: Int = 0,
    val children: MutableList<PrefixTreeNode?> = MutableList(26) { null }
)

private class PrefixTree {
    private val root = PrefixTreeNode()

    fun insert(word: String) {
        var cur = root

        for (c in word) {
            val i = c - 'a'
            if (cur.children[i] == null) {
                cur.children[i] = PrefixTreeNode()
            }

            cur = cur.children[i]!!
            cur.count++
        }
    }

    fun getScore(word: String): Int {
        var cur = root
        var score = 0

        for (c in word) {
            cur = cur.children[c - 'a']!!
            score += cur.count
        }

        return score
    }
}

private class Solution {
    fun sumPrefixScores(words: Array<String>): IntArray {
        val tree = PrefixTree()
        val scores = mutableListOf<Int>()

        for (word in words) {
            tree.insert(word)
        }

        for (word in words) {
            scores.add(tree.getScore(word))
        }

        return scores.toIntArray()
    }

    // TLE
    /*fun sumPrefixScores(words: Array<String>): IntArray {
        val result = mutableListOf<Int>()
        val count = mutableMapOf<String, Int>()

        for (word in words) {
            for (i in word.indices) {
                count[word.substring(0..i)] = count.getOrDefault(word.substring(0..i), 0) + 1
            }
        }

        for (word in words) {
            var score = 0
            for (i in word.indices) {
                score += count[word.substring(0..i)]!!
            }
            result.add(score)
        }

        return result.toIntArray()
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.sumPrefixScores(arrayOf("abc", "ab", "bc", "b")))
    printArray(sol.sumPrefixScores(arrayOf("abcd")))
}