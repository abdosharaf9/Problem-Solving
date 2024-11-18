package problems.DefuseTheBomb

import utils.printArray
import kotlin.math.abs

// https://leetcode.com/problems/defuse-the-bomb/

private class Solution {
    fun decrypt(code: IntArray, k: Int): IntArray {
        val n = code.size
        val answer = IntArray(n) { 0 }
        if (k == 0) return answer

        var l = 0
        var curSum = 0
        for (r in 0..<n + abs(k)) {
            curSum += code[r % n]

            if (r - l + 1 == abs(k)) {
                if (k > 0) answer[(l - 1 + n) % n] = curSum
                else answer[(r + 1) % n] = curSum

                curSum -= code[l]
                l = (l + 1) % n
            }
        }

        return answer
    }

    /*fun decrypt(code: IntArray, k: Int): IntArray {
        val n = code.size
        if (k == 0) return IntArray(n) { 0 }

        val answer = IntArray(n)

        for (i in answer.indices) {
            var sum = 0
            if (k > 0) {
                for (j in 1..k) {
                    sum += code[(i + j) % n]
                }
            } else {
                for (j in k..-1) {
                    sum += code[(i + j + n) % n]
                }
            }

            answer[i] = sum
        }

        return answer
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.decrypt(intArrayOf(5, 7, 1, 4), 3))
    printArray(sol.decrypt(intArrayOf(1, 2, 3, 4), 0))
    printArray(sol.decrypt(intArrayOf(2, 4, 9, 3), -2))
}