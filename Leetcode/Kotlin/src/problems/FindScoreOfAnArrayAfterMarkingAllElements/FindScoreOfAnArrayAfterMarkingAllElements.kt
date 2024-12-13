package problems.FindScoreOfAnArrayAfterMarkingAllElements

import java.util.PriorityQueue

// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun findScore(nums: IntArray): Long {
        val n = nums.size
        var score = 0L

        // We loop over the items until we found a small item and then backtrack
        // with two steps each time to take the items we missed.
        var l: Int
        var r = 0
        while (r < n) {
            // Start a new window which will start at the end of the previous.
            l = r

            // Loop to widen the window until we faced a big number.
            while (r + 1 < n && nums[r + 1] < nums[r]) {
                r++
            }

            // Take the numbers inside this window with skipping the neighbors.
            for (i in r downTo l step 2) {
                score += nums[i]
            }

            // To skipp the right neighbor of the current item.
            r += 2
        }

        return score
    }

    // Time: O(n * log n)
    // Space: O(n)
    /*fun findScore(nums: IntArray): Long {
        val n = nums.size

        // Stores the items with its index to easily get the smallest each time,
        // and if there is a tie we get the smallest by index.
        val heap = PriorityQueue(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        for (i in 0..<n) {
            heap.add(Pair(nums[i], i))
        }

        // Stores the marked indices to avoid them later.
        var score = 0L
        val marked = mutableSetOf<Int>()

        while (heap.isNotEmpty()) {
            // Get the smallest number and check if it is not marked to add it.
            val (num, idx) = heap.poll()
            if (!marked.contains(idx)) {
                score += num

                // Mark its index and the two neighbors of it if they exist.
                marked.add(idx)
                if (idx != n - 1) {
                    marked.add(idx + 1)
                }
                if (idx != 0) {
                    marked.add(idx - 1)
                }
            }
        }

        return score
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.findScore(intArrayOf(2, 1, 3, 4, 5, 2)))
    println(sol.findScore(intArrayOf(2, 3, 5, 1, 3, 2)))
}