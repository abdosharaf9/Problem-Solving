package problems.problems

import kotlin.math.pow

// Problem Link: https://codeforces.com/problemset/problem/1352/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        var n = readln().toInt()

        var i = 0
        val numbers = mutableListOf<Int>()

        while (n > 0) {
            val digit = n % 10
            n /= 10

            if (digit != 0) numbers.add((digit * 10.0.pow(i)).toInt())

            i++
        }

        println(numbers.size)
        println(numbers.joinToString(" "))
    }
}