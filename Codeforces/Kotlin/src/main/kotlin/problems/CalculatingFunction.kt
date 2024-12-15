package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/486/A */

fun main() {
    val n = readln().toLong()
    print(if (n % 2 == 0L) n / 2 else -(n + 1) / 2)
}