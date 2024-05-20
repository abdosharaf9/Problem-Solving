package problems

/* Problem Link: https://codeforces.com/problemset/problem/41/A */

fun main() {
    val s = readln()
    val t = readln()
    print(if (s == t.reversed()) "YES" else "NO")
}