package problems.SlidingPuzzle

import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/sliding-puzzle/

private class Solution {
    fun slidingPuzzle(board: Array<IntArray>): Int {
        // possible moves according to where the '0' is
        val moves = mapOf(
            0 to listOf(1, 3),
            1 to listOf(0, 2, 4),
            2 to listOf(1, 5),
            3 to listOf(0, 4),
            4 to listOf(1, 3, 5),
            5 to listOf(2, 4)
        )

        // Convert the board to a single string to easily use it as a key
        var b = ""
        for (row in board) {
            b += row.joinToString("")
        }

        // The queue will be used to perform BFS search on the possible ways
        // Each item will be a triple of (index of '0', board state, length of the path)
        // We will return that length
        val q: Queue<Triple<Int, String, Int>> = LinkedList()

        // Initial state
        q.add(Triple(b.indexOf('0'), b, 0))

        // Add memoization to avoid searching again in the same direction
        val visited = mutableSetOf<String>()

        while (q.isNotEmpty()) {
            val (i, currentBoard, len) = q.poll()

            // Check if the current state is the desired
            if (currentBoard == "123450") {
                return len
            }

            // If it's not the desired we will add all the possible directions
            // we can go from the current state
            for (move in moves[i]!!) {
                // Convert the string into a list to perform the swap
                val new = currentBoard.toMutableList()
                val temp = new[i]
                new[i] = new[move]
                new[move] = temp

                // The new state we reached after the swap
                val newBoard = new.joinToString("")

                // Avoid visiting the same state again
                if (!visited.contains(newBoard)) {
                    q.add(Triple(move, newBoard, len + 1))
                    visited.add(newBoard)
                }
            }
        }

        return -1
    }
}

fun main() {
    val sol = Solution()
    println(sol.slidingPuzzle(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 0, 5))))
    println(sol.slidingPuzzle(arrayOf(intArrayOf(1, 2, 3), intArrayOf(5, 0, 4))))
    println(sol.slidingPuzzle(arrayOf(intArrayOf(4, 1, 2), intArrayOf(5, 0, 3))))
}