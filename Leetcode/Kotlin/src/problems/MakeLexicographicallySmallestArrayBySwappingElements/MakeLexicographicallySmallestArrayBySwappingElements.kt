package problems.MakeLexicographicallySmallestArrayBySwappingElements

import utils.printArray
import java.util.Queue
import java.util.LinkedList
import kotlin.math.abs

// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/

private class Solution {
    // Time: O(n * log n), which is the time of sorting the array.
    // Space: O(n)
    // Sort the original array and group items using the limit by adding all
    // the sequential items with difference less than or equal to the limit in
    // the same group. Then, according to those groups, will fill the result.
    fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        // Get the number of items and sort them.
        val n = nums.size
        val sortedNums = nums.sorted()

        // Store the groups as Queues to push and pop easily in O(1).
        val groups = mutableListOf<Queue<Int>>()

        // Store the group index for each item to use it later.
        val groupPositions = mutableMapOf<Int, Int>()

        // Loop over the sorted version of the array.
        for (i in 0..<n) {
            // If there were no groups, or the difference between the current item
            // and the previous one is bigger than the limit, then create a new group.
            if (i == 0 || abs(sortedNums[i] - sortedNums[i - 1]) > limit) {
                groups.add(LinkedList())
            }

            // Add the item to its group and store its index.
            groups.last().add(sortedNums[i])
            groupPositions[sortedNums[i]] = groups.lastIndex
        }

        // Loop over the original array to fill the result using the groups, by
        // popping from the current item's group.
        val res = IntArray(n)
        for (i in 0..<n) {
            // Get its group index and pop from it to get the next item in this group.
            val pos = groupPositions[nums[i]]!!
            res[i] = groups[pos].poll()
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.lexicographicallySmallestArray(intArrayOf(1, 5, 3, 9, 8), 2))
    printArray(sol.lexicographicallySmallestArray(intArrayOf(1, 7, 6, 18, 2, 1), 3))
    printArray(sol.lexicographicallySmallestArray(intArrayOf(1, 7, 28, 19, 10), 3))
}