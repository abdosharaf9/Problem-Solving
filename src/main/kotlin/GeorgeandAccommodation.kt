package problems

/* Problem Link: https://codeforces.com/problemset/problem/467/A */

fun main() {
    val n = readln().toInt()
    var rooms = 0

    for (i in 1..n) {
        val (p, q) = readln().split(" ").map { it.toInt() }
        if (q >= p + 2) rooms++
    }

    print(rooms)
}