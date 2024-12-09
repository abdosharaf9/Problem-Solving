package problems.TwoBestNonOverlappingEvents

import java.util.PriorityQueue

// https://leetcode.com/problems/two-best-non-overlapping-events/

private class Solution {
    // We will convert the events into a flat timeline to ease the process.
    // Then, we will sort this timeline and scan it. For each time point, we will
    // consider all the events that ends before it and get the maximum of them.
    // After that, we can see if adding the current event with the maximum one ends
    // before it will give us a bigger value to take it. At the end, we will have
    // the maximum possible value we can get.

    // Time: O(n * log n)
    // Space: O(n)
    fun maxTwoEvents(events: Array<IntArray>): Int {
        // Sorting the events according to the start time
        events.sortBy { it[0] }

        // Used to keep track of events that are still active or ended before the current event.
        val timeline = PriorityQueue(compareBy<Pair<Int, Int>> { it.first })

        var maxSum = 0
        var maxSeenOnLeft = 0
        for ((start, end, value) in events) {
            // Before processing a new event, remove all events that ended before its start time,
            // and update maxSeenOnLeft to reflect the maximum value of such events.
            while (timeline.isNotEmpty() && timeline.peek().first < start) {
                maxSeenOnLeft = maxOf(maxSeenOnLeft, timeline.poll().second)
            }

            // Compute the maximum possible sum by combining the current event’s value and maxSeenOnLeft.
            maxSum = maxOf(maxSum, value + maxSeenOnLeft)
            timeline.add(Pair(end, value))
        }

        return maxSum
    }

    // Time: O(n * log n)
    // Space: O(n)
    /*fun maxTwoEvents(events: Array<IntArray>): Int {
        // Convert events into flat timeline points, each item will be
        // (time, status, value) where the status can be 1 for starting
        // event and -1 for ending event.
        val timeline = mutableListOf<Triple<Int, Int, Int>>()
        for ((start, end, value) in events) {
            // Start event point.
            timeline.add(Triple(start, 1, value))

            // End event point, and we added 1 to the time because the end
            // times are inclusive.
            timeline.add(Triple(end + 1, -1, value))
        }

        // Sort events: primary by position, secondary by state (-1 before 1)
        // which is a must when the start and end time are equal
        timeline.sortWith { a, b ->
            when {
                a.first == b.first -> a.second
                else -> a.first - b.first
            }
        }

        var maxSum = 0
        var maxSeenOnLeft = 0 // Stores the max ended event until now

        for ((_, state, value) in timeline) {
            // If it is a start event, we will add it to the max one
            // ended before it. If it isn't, we will see if this is
            // bigger than the last max ended event we founded.
            if (state == 1) {
                maxSum = maxOf(maxSum, maxSeenOnLeft + value)
            } else {
                maxSeenOnLeft = maxOf(maxSeenOnLeft, value)
            }
        }

        return maxSum
    }*/
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