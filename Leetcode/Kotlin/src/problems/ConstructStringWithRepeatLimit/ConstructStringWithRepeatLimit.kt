package problems.ConstructStringWithRepeatLimit

import java.util.PriorityQueue

// https://leetcode.com/problems/construct-string-with-repeat-limit/

private class Solution {
    // Time: O(n), but it is more efficient because we don't use the heap
    // and directly use the frequency array.
    // Space: O(n), which is used to store the result.
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        // Count the frequency of each character.
        val counts = IntArray(26) { 0 }
        for (c in s) {
            counts[c - 'a']++
        }

        // Loop over the character in backwards.
        var i = 25
        var j = i
        val res = StringBuilder("")
        while (i >= 0 && j >= 0) {
            // Go to the largest lexicographical character that has a frequency
            while (i >= 0 && counts[i] == 0) {
                i--
            }

            // We reached the end of the array
            if (i < 0) continue

            // Add the largest lexicographical character as much as we can.
            val minCount = minOf(repeatLimit, counts[i])
            repeat(minCount) {
                res.append('a' + i)
            }
            counts[i] -= minCount

            // If there is more of this character left, use the second-largest
            // lexicographical character to split the occurrences of the largest.
            if (counts[i] > 0) {
                j = i - 1
                while (j >= 0 && counts[j] == 0) {
                    j--
                }

                // We reached the end of the array
                if (j < 0) continue

                // Append the second-largest only once.
                res.append('a' + j)
                counts[j]--
            }
        }

        return res.toString()
    }

    // Time: O(n * log 26) -> O(n), because we have fixed number of elements.
    // Space: O(n), which is used to store the result.
    /*fun repeatLimitedString(s: String, repeatLimit: Int): String {
        // Count the frequency of each character.
        val counts = IntArray(26) { 0 }
        for (c in s) {
            counts[c - 'a']++
        }

        // Build a Max Heap that sorts the characters in a Desc order.
        val heap = PriorityQueue(compareByDescending<Pair<Int, Int>> { it.first })
        for (i in 0..25) {
            if (counts[i] > 0) {
                heap.add(i to counts[i])
            }
        }

        val res = StringBuilder("")
        while (heap.isNotEmpty()) {
            // Getting the largest lexicographical character and add it to the
            // result as much as we can.
            val (idx, count) = heap.poll()
            val char = 'a' + idx
            val minCount = minOf(count, repeatLimit)
            repeat(minCount) {
                res.append(char)
            }

            // If it is repeated larger than the repeat limit, we will get the
            // second-largest lexicographical character and add it once to the
            // result to split between the occurrences.
            if (count - minCount > 0 && heap.isNotEmpty()) {
                val (secondIdx, secondCount) = heap.poll()
                res.append('a' + secondIdx)

                // Add it back if there is more of it.
                if (secondCount > 1) {
                    heap.add(secondIdx to secondCount - 1)
                }

                // Add the left count.
                heap.add(idx to count - minCount)
            }
        }

        return res.toString()
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.repeatLimitedString("cczazcc", 3))
    println(sol.repeatLimitedString("aababab", 2))
}