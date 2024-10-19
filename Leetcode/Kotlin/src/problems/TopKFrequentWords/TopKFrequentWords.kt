package problems.TopKFrequentWords

import java.util.PriorityQueue

// https://leetcode.com/problems/top-k-frequent-words/

private class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val map = mutableMapOf<String, Int>()

        for (word in words) {
            map[word] = map.getOrPut(word) { 0 } + 1
        }

        val heap = PriorityQueue(compareBy<Pair<String, Int>> { -it.second }.thenBy { it.first })

        for (entry in map.entries) {
            heap.add(Pair(entry.key, entry.value))
        }

        for (item in heap) println(item)

        val result = mutableListOf<String>()
        repeat(k) {
            result.add(heap.poll().first)
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2))
    println(sol.topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), 4))
}