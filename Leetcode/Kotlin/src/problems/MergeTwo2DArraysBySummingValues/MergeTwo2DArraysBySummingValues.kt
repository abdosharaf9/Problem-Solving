package problems.MergeTwo2DArraysBySummingValues

import utils.printMatrixLikeArray

// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/

private class Solution {
    // Time: O(n + m), where n and m are the sizes of both input arrays.
    // Space: O(1), because we don't need any extra space.
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        // Get both arrays' sizes.
        val n = nums1.size
        val m = nums2.size

        // Initialize the result array.
        val res = ArrayList<IntArray>()

        // Loop over both arrays and pick the minimum id each time to get the sorted result.
        var i = 0
        var j = 0
        while (i < n && j < m) {
            if (nums1[i][0] < nums2[j][0]) {
                // The first id is smaller, so use it and increment the pointer.
                res.add(nums1[i])
                i++
            } else if (nums1[i][0] > nums2[j][0]) {
                // The second id is smaller, so use it and increment the pointer.
                res.add(nums2[j])
                j++
            } else {
                // Both ids are equal, add them and increment both pointers.
                res.add(intArrayOf(nums1[i][0], nums1[i][1] + nums2[j][1]))
                i++
                j++
            }
        }

        // If there are still ids in the first array and the second array is
        // finished, add them directly to the result.
        while (i < n) {
            res.add(nums1[i])
            i++
        }

        // If there are still ids in the second array and the first array is
        // finished, add them directly to the result.
        while (j < m) {
            res.add(nums2[j])
            j++
        }

        return res.toTypedArray()
    }
}

fun main() {
    val sol = Solution()

    printMatrixLikeArray(
        sol.mergeArrays(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(4, 5)
            ),
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(3, 2),
                intArrayOf(4, 1)
            )
        )
    )

    printMatrixLikeArray(
        sol.mergeArrays(
            arrayOf(
                intArrayOf(2, 4),
                intArrayOf(3, 6),
                intArrayOf(5, 5)
            ),
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(4, 3)
            )
        )
    )
}