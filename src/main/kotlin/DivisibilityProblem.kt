package problems

/* Problem Link: https://codeforces.com/problemset/problem/1328/A */

fun main() {
    val tests = readln().toInt()

    for (i in 1..tests) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println(
            if (a % b == 0) 0
            else b - (a % b)
        )
    }
}