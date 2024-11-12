package problems.MostBeautifulItemForEachQuery

import utils.printArray

// https://leetcode.com/problems/most-beautiful-item-for-each-query/

private class Solution {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        val answer = IntArray(queries.size) { 0 }
        val sortedItems = items.sortedBy { it[0] }
        val sortedQueries = queries.mapIndexed { idx, q -> Pair(q, idx) }.sortedBy { it.first }

        var maxBea = 0
        var j = 0
        for ((q, idx) in sortedQueries) {
            while (j < sortedItems.size && sortedItems[j][0] <= q) {
                maxBea = maxOf(maxBea, sortedItems[j][1])
                j++
            }

            answer[idx] = maxBea
        }

        return answer
    }

    // TLE
    /*fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        val answer = IntArray(queries.size) { 0 }

        for (i in 0..queries.lastIndex) {
            val price = queries[i]

            for (item in items) {
                if (item[0] <= price) {
                    answer[i] = maxOf(answer[i], item[1])
                }
            }
        }

        return answer
    }*/
}

fun main() {
    val sol = Solution()

    printArray(
        sol.maximumBeauty(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 2),
                intArrayOf(2, 4),
                intArrayOf(5, 6),
                intArrayOf(3, 5)
            ),
            intArrayOf(1, 2, 3, 4, 5, 6)
        )
    )

    printArray(
        sol.maximumBeauty(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(1, 4)
            ),
            intArrayOf(1)
        )
    )

    printArray(
        sol.maximumBeauty(
            arrayOf(
                intArrayOf(10, 1000)
            ),
            intArrayOf(5)
        )
    )
}