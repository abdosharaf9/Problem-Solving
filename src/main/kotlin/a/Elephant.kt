package a

/* Problem Link: https://codeforces.com/problemset/problem/617/A */

fun main() {
    val n = readln().toInt()
    print(if (n % 5 == 0) n / 5 else (n / 5) + 1)
}