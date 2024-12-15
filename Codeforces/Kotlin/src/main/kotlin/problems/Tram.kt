package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/116/A */

fun main() {
    val n = readln().toInt()
    var current = 0
    var max = 0

    for(i in 1..n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        current = current - a + b
        if(current > max) max = current
    }

    print(max)
}