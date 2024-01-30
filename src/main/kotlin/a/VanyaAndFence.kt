package a

/* Problem Link: https://codeforces.com/problemset/problem/677/A */

fun main() {
    val (n, h) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }
    print(n + a.count { it > h })
}