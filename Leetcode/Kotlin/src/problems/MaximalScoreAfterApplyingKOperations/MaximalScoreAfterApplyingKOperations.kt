package problems.MaximalScoreAfterApplyingKOperations

import java.util.PriorityQueue
import kotlin.math.ceil

// https://leetcode.com/problems/maximal-score-after-applying-k-operations/

private class Solution {
    fun maxKelements(nums: IntArray, k: Int): Long {
        val heap = PriorityQueue<Int>(compareByDescending { it })
        for (num in nums) heap.add(num)

        var res = 0L
        for (i in 1..k) {
            val max = heap.poll()
            res += max
            heap.add(ceil(max / 3.0).toInt())
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxKelements(intArrayOf(10, 10, 10, 10, 10), 5))
    println(sol.maxKelements(intArrayOf(1, 10, 3, 3, 3), 3))
}