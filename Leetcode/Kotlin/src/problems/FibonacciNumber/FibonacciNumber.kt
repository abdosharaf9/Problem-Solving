package problems.FibonacciNumber

// https://leetcode.com/problems/fibonacci-number/

private class Solution {

    // Linear solution O(n)
    fun fib(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1

        var a = 0
        var b = 1
        var c = 1

        for (i in 2..n) {
            a = b
            b = c
            c = b + a
        }

        return b
    }

    // Recursive solution O(2^n)
    /*fun fib(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        return fib(n - 1) + fib(n - 2)
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.fib(0))
    println(sol.fib(1))
    println(sol.fib(2))
    println(sol.fib(3))
    println(sol.fib(4))
    println(sol.fib(30))
}