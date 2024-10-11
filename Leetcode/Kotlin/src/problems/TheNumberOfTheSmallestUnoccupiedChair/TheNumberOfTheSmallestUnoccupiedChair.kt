package problems.TheNumberOfTheSmallestUnoccupiedChair

import java.util.PriorityQueue

// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/

private class Solution {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val indices = times.indices.sortedBy { i -> times[i][0] }

        val usedChairs = PriorityQueue(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        val availableChairs = PriorityQueue<Int>()
        availableChairs.addAll(times.indices)

        for (i in indices) {
            val (arrival, leave) = times[i]
            while (usedChairs.isNotEmpty() && usedChairs.peek().first <= arrival) {
                val (_, chair) = usedChairs.poll()
                availableChairs.add(chair)
            }

            val chair = availableChairs.poll()
            usedChairs.add(Pair(leave, chair))

            if (i == targetFriend) return chair
        }

        return -1
    }
}

fun main() {
    val sol = Solution()
    println(sol.smallestChair(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(4, 6)), 1))
    println(sol.smallestChair(arrayOf(intArrayOf(3, 10), intArrayOf(1, 5), intArrayOf(2, 6)), 0))
}