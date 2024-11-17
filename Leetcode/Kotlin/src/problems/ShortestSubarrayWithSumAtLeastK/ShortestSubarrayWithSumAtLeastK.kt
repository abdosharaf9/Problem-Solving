package problems.ShortestSubarrayWithSumAtLeastK

import java.util.Deque
import java.util.LinkedList
import java.util.PriorityQueue

// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/

private class Solution {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        var res = Int.MAX_VALUE

        val q: Deque<Pair<Long, Int>> = LinkedList()
        var curSum = 0L

        for (i in nums.indices) {
            curSum += nums[i]
            if (curSum >= k) res = minOf(res, i + 1)

            while (q.isNotEmpty() && curSum - q.first.first >= k) {
                val (_, idx) = q.removeFirst()
                res = minOf(res, i - idx)
            }

            while (q.isNotEmpty() && q.last.first >= curSum) {
                q.removeLast()
            }

            q.add(Pair(curSum, i))
        }

        return if (res == Int.MAX_VALUE) -1 else res
    }

    /*fun shortestSubarray(nums: IntArray, k: Int): Int {
        var res = Int.MAX_VALUE

        val heap = PriorityQueue<Pair<Long, Int>>(compareBy { it.first })
        var curSum = 0L

        for (i in nums.indices) {
            curSum += nums[i]
            if (curSum >= k) res = minOf(res, i + 1)

            while (heap.isNotEmpty() && curSum - heap.peek().first >= k) {
                val (_, idx) = heap.poll()
                res = minOf(res, i - idx)
            }

            heap.add(Pair(curSum, i))
        }

        return if (res == Int.MAX_VALUE) -1 else res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.shortestSubarray(intArrayOf(1), 1))
    println(sol.shortestSubarray(intArrayOf(1, 2), 4))
    println(sol.shortestSubarray(intArrayOf(2, -1, 2), 3))
}