package problems.MaximumAveragePassRatio

import java.util.PriorityQueue

// https://leetcode.com/problems/maximum-average-pass-ratio/

private class Solution {
    // Time: O(n * log n)
    // Space: O(n)
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        // Stores the classes ordered descending according to the change
        // we can make by adding a student to the class. This is because
        // we need to make the maximum change as we can.
        // Each item will be (change, pass, total).
        val heap = PriorityQueue(compareByDescending<Triple<Double, Int, Int>> { it.first })

        // Adding all the classes to the heap.
        for ((p, t) in classes) {
            val cur = p.toDouble() / t
            val future = (p + 1).toDouble() / (t + 1)
            heap.add(Triple(future - cur, p, t))
        }

        // Adding all the extra students by selecting the maximum change we can
        // make each time, and then calculate the new change and add the item
        // back to the heap.
        repeat(extraStudents) {
            var (_, p, t) = heap.poll()
            // Updating the number of students after adding a student.
            p++
            t++

            // Calculating the new change and add the item back.
            val cur = p.toDouble() / t
            val future = (p + 1).toDouble() / (t + 1)
            heap.add(Triple(future - cur, p, t))
        }

        // Summing all the ratios.
        val sum = heap.sumOf { (_, p, t) -> p.toDouble() / t }

        // Return the average.
        return sum / classes.size
    }

    // The same solution but using the input in-place (kind of 😂).
    /*fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        val heap = PriorityQueue(compareByDescending<Pair<Double, Int>> { it.first })

        fun add(idx: Int) {
            val cur = classes[idx][0].toDouble() / classes[idx][1]
            val future = (classes[idx][0] + 1).toDouble() / (classes[idx][1] + 1)
            heap.add(future - cur to idx)
        }

        for (i in classes.indices) {
            add(i)
        }

        repeat(extraStudents) {
            val (_, idx) = heap.poll()

            classes[idx][0]++
            classes[idx][1]++

            add(idx)
        }

        val sum = classes.sumOf { (p, t) ->
            p.toDouble() / t
        }

        return sum / classes.size
    }*/
}

fun main() {
    val sol = Solution()

    println(
        sol.maxAverageRatio(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 5),
                intArrayOf(2, 2)
            ),
            2
        )
    )

    println(
        sol.maxAverageRatio(
            arrayOf(
                intArrayOf(2, 4),
                intArrayOf(3, 9),
                intArrayOf(4, 5),
                intArrayOf(2, 10)
            ),
            4
        )
    )
}