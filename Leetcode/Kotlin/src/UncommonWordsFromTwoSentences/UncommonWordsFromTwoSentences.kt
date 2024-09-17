package UncommonWordsFromTwoSentences

// https://leetcode.com/problems/uncommon-words-from-two-sentences/

private class Solution {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val counts = mutableMapOf<String, Int>()

        s1.split(" ").forEach {
            if (counts.contains(it)) counts[it] = counts[it]!! + 1
            else counts[it] = 1
        }

        s2.split(" ").forEach {
            if (counts.contains(it)) counts[it] = counts[it]!! + 1
            else counts[it] = 1
        }

        return counts.filter { it.value == 1 }.map { it.key }.toTypedArray()
    }
}

fun main() {
    val sol = Solution()
    print(sol.uncommonFromSentences("this apple is sweet", "this apple is sour"))
    print(sol.uncommonFromSentences("apple apple", "banana"))
}

fun print(arr: Array<String>) {
    for (s in arr) {
        print("$s, ")
    }
    println()
}