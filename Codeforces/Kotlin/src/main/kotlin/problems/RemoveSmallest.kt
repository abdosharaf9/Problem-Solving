package problems.problems

import kotlin.math.abs

// Problem Link: https://codeforces.com/problemset/problem/1399/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val n = readln().toInt()
        val numbers = readln().split(" ").map { it.toInt() }.sorted()
        var flag = false

        for (i in 0..<n - 1) {
            if (abs(numbers[i] - numbers[i + 1]) > 1) {
                flag = true
            }
        }

        println(
            if (flag) "NO" else "YES"
        )
    }
}