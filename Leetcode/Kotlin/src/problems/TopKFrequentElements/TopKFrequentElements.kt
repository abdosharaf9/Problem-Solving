package problems.TopKFrequentElements

import utils.printArray
import java.util.PriorityQueue

// https://leetcode.com/problems/top-k-frequent-elements/

private class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val mp = mutableMapOf<Int, Int>()

        for (x in nums) {
            mp[x] = mp.getOrPut(x) { 0 } + 1
        }

        val heap = PriorityQueue(compareBy<Pair<Int, Int>> { it.first })

        for (entry in mp.entries) {
            heap.add(Pair(entry.value, entry.key))
            if (heap.size > k) heap.poll()
        }

        val result = IntArray(k)
        for (i in k - 1 downTo 0) {
            result[i] = heap.poll().second
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2))
    printArray(sol.topKFrequent(intArrayOf(1), 1))
}