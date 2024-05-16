package problems

import kotlin.math.pow

// Problem Link: https://codeforces.com/problemset/problem/1560/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val k = readln().toInt()
        var numbs = 0

        for (i in 1..k.toFloat().pow(2).toInt()) {
            if (i % 3 != 0 && i % 10 != 3) numbs++
            if (numbs == k) {
                println(i)
                break
            }
        }
    }
}