package problems.TakeGiftsFromTheRichestPile

import java.util.PriorityQueue
import kotlin.math.floor
import kotlin.math.sqrt

// https://leetcode.com/problems/take-gifts-from-the-richest-pile/

private class Solution {
    // Time: O(n log n)
    // Space: O(n)
    fun pickGifts(gifts: IntArray, k: Int): Long {
        // Use Max Heap to easily get the maximum element in each iteration
        val heap = PriorityQueue(compareByDescending<Int> { it })
        for (gift in gifts) {
            heap.add(gift)
        }

        // Get the maximum number and add the remaining back to the heap K times.
        repeat(k) {
            val mx = heap.poll() ?: 0
            val remain = floor(sqrt(mx.toDouble())).toInt()
            if (remain > 0) {
                heap.add(remain)
            }
        }

        // Return the sum of all the remaining elements.
        return heap.sumOf { it.toLong() }
    }
}

fun main() {
    val sol = Solution()
    println(sol.pickGifts(intArrayOf(25, 64, 9, 4, 100), 4))
    println(sol.pickGifts(intArrayOf(1, 1, 1, 1), 4))
}