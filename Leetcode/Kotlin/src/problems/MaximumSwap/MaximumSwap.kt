package problems.MaximumSwap

import kotlin.math.max

// https://leetcode.com/problems/maximum-swap/

private class Solution {
    fun maximumSwap(num: Int): Int {
        val n = num.toString().toCharArray().map { it.digitToInt() }.toMutableList()
        val maxs = Array(n.size) { Pair(0, 0) }

        for (i in n.lastIndex downTo 0) {
            if (i == n.lastIndex) maxs[i] = Pair(n[i], i)
            else if (n[i] > maxs[i + 1].first) maxs[i] = Pair(n[i], i)
            else maxs[i] = maxs[i + 1]
        }

        for (i in 0..n.lastIndex) {
            if (n[i] < maxs[i].first) {
                n[maxs[i].second] = n[i]
                n[i] = maxs[i].first
                break
            }
        }

        return n.joinToString("").toInt()
    }
}

fun main() {
    val sol = Solution()
    println(sol.maximumSwap(2736))
    println(sol.maximumSwap(9973))
}