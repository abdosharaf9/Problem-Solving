package problems.SpecialArrayII

import utils.printArray

// https://leetcode.com/problems/special-array-ii/

private class Solution {

    // Time: O(n)
    // Space: O(n)
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        // Use a prefix array to know what is the longest special sub-array ending
        // at every item. The default is 1 for all sub-arrays (the item itself).
        val prefixes = IntArray(nums.size) { 1 }
        for (i in 1..nums.lastIndex) {
            // If the current item and the one before it are different parity.
            if (nums[i] and 1 != nums[i - 1] and 1) {
                prefixes[i] = prefixes[i - 1] + 1
            }
        }

        // The answer is true if the longest special array ending at the query
        // end is bigger than or equal to the query range size.
        val ans = BooleanArray(queries.size)
        for (i in queries.indices) {
            val (from, to) = queries[i]
            ans[i] = (prefixes[to] >= to - from + 1)
        }

        return ans
    }

    // Time: O(n * log n)
    // Space: O(n)
    /*fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        // Check if two integers are the same parity.
        fun checkNums(x: Int, y: Int): Boolean {
            if (x % 2 == 0 && y % 2 == 0) return false
            if (x % 2 == 1 && y % 2 == 1) return false
            return true
        }

        // Stores all the special sub-arrays using the [start, end]
        // of each one of them.
        val specialSubArrays = mutableListOf<IntArray>()
        var start = 0
        for (i in 1..nums.lastIndex) {
            if (!checkNums(nums[i], nums[i - 1])) {
                specialSubArrays.add(intArrayOf(start, i - 1))
                start = i
            }
        }

        // Add the last sub-array either it contains only the last
        // item, or a long one ends at the last item.
        specialSubArrays.add(intArrayOf(start, nums.lastIndex))

        val ans = BooleanArray(queries.size)

        // For each query, we will search if there is a special sub-array
        // that is same as the query or contains the query inside it.
        for (i in queries.indices) {
            val (from, to) = queries[i]
            // Using the Binary Search to the index if there is a sub-array, or
            // -1 if there is no special sub-array contains this range.
            val idx = specialSubArrays.binarySearch { pair ->
                when {
                    from < pair[0] -> 1
                    from > pair[1] -> -1
                    else -> 0
                }
            }

            // The answer is true if we found a sub-array.
            ans[i] = if (idx >= 0) {
                val (x, y) = specialSubArrays[idx]
                from >= x && to <= y
            } else {
                false
            }
        }

        return ans
    }*/
}

fun main() {
    val sol = Solution()

    printArray(
        sol.isArraySpecial(
            intArrayOf(3, 4, 1, 2, 6),
            arrayOf(
                intArrayOf(0, 4)
            )
        )
    )

    printArray(
        sol.isArraySpecial(
            intArrayOf(4, 3, 1, 6),
            arrayOf(
                intArrayOf(0, 2),
                intArrayOf(2, 3)
            )
        )
    )
}