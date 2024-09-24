package FindTheLengthOfTheLongestCommonPrefix

import kotlin.math.max

// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/

class Solution {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        var first = arr1
        var second = arr2

        if (first.size > second.size) {
            val temp = first
            first = second
            second = temp
        }

        val set = mutableSetOf<Int>()
        for (x in first) {
            var n = x
            while (n > 0) {
                set.add(n)
                n /= 10
            }
        }

        var result = 0

        for (x in second) {
            var n = x
            while (n > 0 && n !in set) {
                n /= 10
            }

            if (n != 0) {
                result = max(result, n.toString().length)
            }
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestCommonPrefix(intArrayOf(1, 10, 100), intArrayOf(1000)))
    println(sol.longestCommonPrefix(intArrayOf(1, 2, 3), intArrayOf(4, 4, 4)))
}