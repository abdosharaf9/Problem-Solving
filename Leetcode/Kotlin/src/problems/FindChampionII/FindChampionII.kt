package problems.FindChampionII

// https://leetcode.com/problems/find-champion-ii/

private class Solution {
    // The champion will be the one with no edges going to it
    fun findChampion(n: Int, edges: Array<IntArray>): Int {
        val counts = IntArray(n) { 0 }

        // Count the incoming edges for each node
        for ((_, to) in edges) {
            counts[to]++
        }

        // Get the node with the 0 edges incoming
        var champ = -1
        for (i in 0..<n) {
            // If we found one before, return -1
            if (counts[i] == 0 && champ != -1) {
                return -1
            }

            if (counts[i] == 0) {
                champ = i
            }
        }

        return champ
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.findChampion(
            3,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2)
            )
        )
    )

    println(
        sol.findChampion(
            4,
            arrayOf(
                intArrayOf(0, 2),
                intArrayOf(1, 3),
                intArrayOf(1, 2)
            )
        )
    )
}