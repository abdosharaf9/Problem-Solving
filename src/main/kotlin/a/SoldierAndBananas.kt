package a

/* Problem Link: https://codeforces.com/problemset/problem/546/A */

fun main() {
    val (k, n, w) = readln().split(" ").map { it.toInt() }
    var dollars = 0

    for (i in 1..w) dollars += i * k
    print(if (dollars <= n) 0 else dollars - n)
}