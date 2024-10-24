package problems.ClimbingStairs

// https://leetcode.com/problems/climbing-stairs/

private class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        var a = 1
        var b = 2
        var cur = 0

        repeat(n - 2) {
            cur = a + b
            a = b
            b = cur
        }

        return cur
    }
}

fun main() {
    val sol = Solution()
    println(sol.climbStairs(2))
    println(sol.climbStairs(3))
    println(sol.climbStairs(5))
}