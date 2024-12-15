package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/750/A */

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var result = 0

    for (i in 1..n) {
        if (5 * (i * (i + 1) / 2) + k <= 240) result++
        else break
    }

    print(result)
}