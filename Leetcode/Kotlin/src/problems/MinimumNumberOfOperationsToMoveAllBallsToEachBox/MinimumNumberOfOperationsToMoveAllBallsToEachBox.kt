package problems.MinimumNumberOfOperationsToMoveAllBallsToEachBox

import utils.printArray
import kotlin.math.abs

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

private class Solution {
    // Optimized solution using prefix/suffix sum.
    // Time: O(n)
    // Space: O(1), there is no extra space except the output array.
    fun minOperations(boxes: String): IntArray {
        // Store the output.
        val ans = IntArray(boxes.length) { 0 }

        // Loop over the boxes to count the number of moves we need
        // for the balls on the left of the current box.
        var balls = 0
        var moves = 0
        for (i in boxes.indices) {
            // The same number of moves as the previous box added with the
            // number of balls because they are currently at the previous box
            // and moving each one of them needs only one move.
            ans[i] = balls + moves

            // Update the number of balls and moves.
            moves += balls
            if (boxes[i] == '1') balls++
        }

        // Loop over the boxes in reverse order to count the number of moves
        // we need for the balls on the right of the current box.
        balls = 0
        moves = 0
        for (i in boxes.indices.reversed()) {
            // The same number of moves as the next box added with the
            // number of balls because they are currently at the next box
            // and moving each one of them needs only one move.
            ans[i] += balls + moves

            // Update the number of balls and moves.
            moves += balls
            if (boxes[i] == '1') balls++
        }

        return ans
    }

    // Brute Force solution (works).
    // Time: O(n^2)
    // Space: O(1), there is no extra space except the output array.
    /*fun minOperations(boxes: String): IntArray {
        // Store the output.
        val ans = IntArray(boxes.length) { 0 }

        // Loop over all the indices to calculate the number of operations.
        for (i in boxes.indices) {
            // Get the number of operations needed to move all the balls
            // on the left of the current box.
            for (j in 0..<i) {
                if (boxes[j] == '1') {
                    // Number of operations to move the ball from box "j" to box "i".
                    ans[i] += abs(i - j)
                }
            }

            // Get the number of operations needed to move all the balls
            // on the right of the current box.
            for (j in i + 1..boxes.lastIndex) {
                if (boxes[j] == '1') {
                    // Number of operations to move the ball from box "j" to box "i".
                    ans[i] += abs(i - j)
                }
            }
        }

        return ans
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.minOperations("110"))
    printArray(sol.minOperations("001011"))
}