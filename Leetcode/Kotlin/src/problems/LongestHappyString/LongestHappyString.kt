package problems.LongestHappyString

import java.util.PriorityQueue

// https://leetcode.com/problems/longest-happy-string/

private class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val result = StringBuilder()
        val heap = PriorityQueue(compareByDescending<Pair<Char, Int>> { it.second })

        if (a > 0) heap.add(Pair('a', a))
        if (b > 0) heap.add(Pair('b', b))
        if (c > 0) heap.add(Pair('c', c))

        while (heap.isNotEmpty()) {
            val (char1, count1) = heap.poll()

            if (result.takeLast(2) == "$char1$char1") {
                if (heap.isEmpty()) break

                val (char2, count2) = heap.poll()
                result.append(char2)
                if (count2 > 1) heap.add(Pair(char2, count2 - 1))

                heap.add(Pair(char1, count1))

            } else {
                result.append(char1)
                if (count1 > 1) heap.add(Pair(char1, count1 - 1))
            }
        }

        return result.toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestDiverseString(1, 1, 7))
    println(sol.longestDiverseString(7, 1, 0))
}