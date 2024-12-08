package problems.TwoBestNonOverlappingEvents

import java.util.PriorityQueue

// https://leetcode.com/problems/two-best-non-overlapping-events/

private class Solution {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        // Wrong answer in: [[2,1000000000,1000000],[1,1,1000000]]
        /*val timeline = PriorityQueue(compareBy<Triple<Int, Boolean, Int>> { it.first })
        for ((start, end, value) in events) {
            timeline.add(Triple(start, true, value))
            timeline.add(Triple(end + 1, false, value))
        }

        var maxSum = 0
        var maxSeenOnLeft = 0
        while (timeline.isNotEmpty()) {
            val (_, state, value) = timeline.poll()
            if (state) {
                maxSum = maxOf(maxSum, value + maxSeenOnLeft)
            } else {
                maxSeenOnLeft = maxOf(maxSeenOnLeft, value)
            }
        }

        return maxSum*/

        // Right!!
        events.sortBy { it[0] }

        var maxSum = 0
        var maxSeenOnLeft = 0
        val timeline = PriorityQueue(compareBy<Pair<Int, Int>> { it.first })

        for ((start, end, value) in events) {
            while (timeline.isNotEmpty() && timeline.peek().first < start) {
                maxSeenOnLeft = maxOf(maxSeenOnLeft, timeline.poll().second)
            }

            maxSum = maxOf(maxSum, value + maxSeenOnLeft)
            timeline.add(Pair(end, value))
        }

        return maxSum
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.maxTwoEvents(
            arrayOf(
                intArrayOf(1, 3, 2),
                intArrayOf(4, 5, 2),
                intArrayOf(2, 4, 3)
            )
        )
    )

    println(
        sol.maxTwoEvents(
            arrayOf(
                intArrayOf(1, 3, 2),
                intArrayOf(4, 5, 2),
                intArrayOf(1, 5, 5)
            )
        )
    )

    println(
        sol.maxTwoEvents(
            arrayOf(
                intArrayOf(1, 5, 3),
                intArrayOf(1, 5, 1),
                intArrayOf(6, 6, 5)
            )
        )
    )
}