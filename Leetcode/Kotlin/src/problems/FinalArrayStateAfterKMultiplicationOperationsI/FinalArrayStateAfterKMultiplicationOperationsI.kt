package problems.FinalArrayStateAfterKMultiplicationOperationsI

import utils.printArray
import java.util.PriorityQueue

// https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/

private class Solution {
    /** This is optimal for smaller inputs (like this problem) */
    // Time: O(k * n)
    // Space: O(1), because we just manipulate the input array.
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        // In each time we iterate over all the items and find the minimum
        // item and multiply it in-place.
        repeat(k) {
            var min = 0

            for (i in nums.indices) {
                // Get the minimum item.
                if (nums[i] < nums[min]) {
                    min = i
                }
            }

            // Multiply it by the multiplier.
            nums[min] *= multiplier
        }

        return nums
    }

    /** This is optimal for bigger inputs (not this problem) */
    // Time: O(n * log n), which is the time needed to add all the
    // items to the heap.
    // Space: O(n)
    /*fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val heap = PriorityQueue(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })

        // Add all the items to the heap
        for (i in nums.indices) {
            heap.add(nums[i] to i)
        }

        // Manipulate the minimum item and add it back to the heap.
        repeat(k) {
            val (n, idx) = heap.poll()
            heap.add((n * multiplier) to idx)
        }

        // Assign the final values to the original array.
        for ((n, idx) in heap) {
            nums[idx] = n
        }

        return nums
    }*/
}

fun main() {
    val sol = Solution()

    printArray(
        sol.getFinalState(
            intArrayOf(2, 1, 3, 5, 6),
            5,
            2
        )
    )

    printArray(
        sol.getFinalState(
            intArrayOf(1, 2),
            3,
            4
        )
    )
}