package problems.LargestCombinationWithBitwiseANDGreaterThanZero

// https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/

private class Solution {
    fun largestCombination(candidates: IntArray): Int {
        var result = 0

        for (i in 0..<32) {
            var count = 0

            for (n in candidates) {
                count += if (n and 1.shl(i) > 0) 1 else 0
            }

            result = maxOf(result, count)
        }

        return result
    }

    /*fun largestCombination(candidates: IntArray): Int {
        val counts = IntArray(32) { 0 }

        for (n in candidates) {
            var num = n
            var i = 0

            while (num > 0) {
                counts[i] += 1 and num
                i++
                num = num.shr(1)
            }
        }

        return counts.max()
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.largestCombination(intArrayOf(16, 17, 71, 62, 12, 24, 14)))
    println(sol.largestCombination(intArrayOf(8, 8)))
}