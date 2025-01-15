package problems.MinimizeXOR

// https://leetcode.com/problems/minimize-xor/

private class Solution {
    fun minimizeXor(num1: Int, num2: Int): Int {
        var count = num2.countOneBits()
        var result = 0

        // Cancel set bits from highest to lowest weight
        for (i in 31 downTo 0) {
            if ((num1 and (1 shl i)) != 0 && count > 0) {
                count--
                result += (1 shl i)
            }
        }

        // Set bits lowest to highest weight
        for (i in 0..31) {
            if ((num1 and (1 shl i)) == 0 && count > 0) {
                count--
                result += (1 shl i)
            }
        }

        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.minimizeXor(3, 5))
    println(sol.minimizeXor(1, 12))
}