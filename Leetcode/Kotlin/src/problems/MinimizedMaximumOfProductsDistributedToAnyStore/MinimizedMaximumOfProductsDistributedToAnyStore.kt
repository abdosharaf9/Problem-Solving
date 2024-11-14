package problems.MinimizedMaximumOfProductsDistributedToAnyStore

import kotlin.math.ceil

// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/

private class Solution {
    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        var res = 0

        fun canDistribute(k: Int): Boolean {
            var count = 0

            for (q in quantities) {
                count += ceil(q / k.toDouble()).toInt()
            }

            return count <= n
        }

        var l = 1
        var r = quantities.max()
        while (l <= r) {
            val m = (l + r) / 2
            if (canDistribute(m)) {
                res = m
                r = m - 1
            } else {
                l = m + 1
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.minimizedMaximum(6, intArrayOf(11, 6)))
    println(sol.minimizedMaximum(7, intArrayOf(15, 10, 10)))
    println(sol.minimizedMaximum(1, intArrayOf(100000)))
}