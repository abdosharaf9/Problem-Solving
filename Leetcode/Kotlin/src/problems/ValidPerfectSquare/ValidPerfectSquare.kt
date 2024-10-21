package problems.ValidPerfectSquare

// https://leetcode.com/problems/valid-perfect-square/

private class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        var left: Long = 1
        var right: Long = num.toLong()
        var mid: Long
        var midSquared: Long

        while (left <= right) {
            mid = (left + right) / 2L
            midSquared = mid * mid

            when {
                midSquared == num.toLong() -> return true
                midSquared > num -> right = mid - 1
                else -> left = mid + 1
            }
        }

        return false
    }
}

fun main() {
    val sol = Solution()
//    println(sol.isPerfectSquare(16))
//    println(sol.isPerfectSquare(14))
//    println(sol.isPerfectSquare(1))
    println(sol.isPerfectSquare(2147483647))
}