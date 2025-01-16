package problems.BitwiseXOROfAllPairings

// https://leetcode.com/problems/bitwise-xor-of-all-pairings/

private class Solution {
    // Time: O(n + m)
    // Space: O(1)
    // XOR has a property of cancelling the numbers if they XORed
    // with themselves. If the second array's size is even, this means
    // each number from the first array will be repeated in the pairs
    // even number of times, which will cancel it. Thus, if the second
    // array's size is even, we don't need to include the first array
    // items because they will be canceled anyway. The same thing for
    // the second array.
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        var res = 0

        // Only include the first array items if the second array's size is odd.
        if (nums2.size % 2 == 1) {
            for (x in nums1) {
                res = res xor x
            }
        }

        // Only include the second array items if the first array's size is odd.
        if (nums1.size % 2 == 1) {
            for (x in nums2) {
                res = res xor x
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.xorAllNums(intArrayOf(2, 1, 3), intArrayOf(10, 2, 5, 0)))
    println(sol.xorAllNums(intArrayOf(1, 2), intArrayOf(3, 4)))
}