package problems.MaximumEmployeesToBeInvitedToAMeeting

import java.util.Queue
import java.util.LinkedList

// https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/

private class Solution {
    // Time: O(n^2), because there can be at most n/2 cycles of length 2 and the BFS takes O(n).
    // Space: O(n), because all the data structures we use will be of size n.
    // The goal is to find the largest possible cycle or the sum of the longest
    // chains that can be formed from pairs of people who mutually favor each other.
    fun maximumInvitations(favorite: IntArray): Int {
        // Get number of nodes
        val n = favorite.size

        // The longest cycle length.
        var longestCycle = 0

        // Keep track of visited nodes.
        val visit = BooleanArray(n)

        // Store pairs of nodes that form cycles of length 2.
        val length2Cycles = mutableListOf<Pair<Int, Int>>()

        // Step 1: Detect cycles and calculate their lengths
        for (i in 0..<n) {
            // Avoid visiting the same node again.
            if (visit[i]) {
                continue
            }

            // Keep track of the starting node and the whole path.
            var start = i
            var cur = i
            val curSet = mutableSetOf<Int>()

            // Move until we reach a visited node.
            while (!visit[cur]) {
                visit[cur] = true
                curSet.add(cur)
                cur = favorite[cur]
            }

            // If we encounter a node already in the current set (path), we have found a cycle.
            if (cur in curSet) {
                // Get the length of the whole path.
                var length = curSet.size

                // Calculate the length of the cycle.
                while (start != cur) {
                    length--
                    start = favorite[start]
                }

                // Update the longest cycle length.
                longestCycle = maxOf(longestCycle, length)

                // If the cycle length is 2, store the pair.
                if (length == 2) {
                    length2Cycles.add(cur to favorite[cur])
                }
            }
        }

        // Step 2: Build an inverted graph to find the longest chains.
        val inverted = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0..<n) {
            inverted.computeIfAbsent(favorite[i]) { mutableListOf() }.add(i)
        }

        // BFS function to find the longest chain starting from a given node, avoiding a specific parent node.
        fun bfs(src: Int, parent: Int): Int {
            val q: Queue<Pair<Int, Int>> = LinkedList(listOf(src to 0))
            var maxLength = 0

            while (q.isNotEmpty()) {
                val (node, length) = q.poll()
                if (node == parent) {
                    continue
                }

                maxLength = maxOf(maxLength, length)
                for (nei in inverted[node] ?: emptyList()) {
                    q.add(nei to length + 1)
                }
            }

            return maxLength
        }

        // Step 3: Calculate the sum of the longest chains for all cycles of length 2.
        var chainSum = 0
        for ((n1, n2) in length2Cycles) {
            chainSum += bfs(n1, n2) + bfs(n2, n1) + 2
        }

        // Step 4: Return the maximum between the longest cycle and the sum of the longest chains.
        return maxOf(chainSum, longestCycle)
    }
}

fun main() {
    val sol = Solution()
    println(sol.maximumInvitations(intArrayOf(2, 2, 1, 2)))
    println(sol.maximumInvitations(intArrayOf(1, 2, 0)))
    println(sol.maximumInvitations(intArrayOf(3, 0, 1, 4, 1)))
}