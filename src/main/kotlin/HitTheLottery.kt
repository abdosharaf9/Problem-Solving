package problems

/* Problem Link: https://codeforces.com/problemset/problem/996/A */

fun main() {
    val n = readln().toInt()
    print((n / 100) + ((n % 100) / 20) + ((n % 20) / 10) + ((n % 10) / 5) + ((n % 5) / 1))
}