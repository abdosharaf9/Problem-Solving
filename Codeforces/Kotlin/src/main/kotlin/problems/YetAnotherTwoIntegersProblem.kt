package problems.problems

import kotlin.math.abs

/* Problem Link: https://codeforces.com/problemset/problem/1409/A */

fun main() {
    var tests = readln().toInt()
    while (tests-- > 0) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val diff = abs(a - b)
        println((diff / 10) + if (diff % 10 > 0) 1 else 0)
    }
}