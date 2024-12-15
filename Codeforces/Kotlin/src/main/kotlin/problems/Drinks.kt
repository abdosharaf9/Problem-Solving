package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/200/B */

fun main() {
    val n = readln().toInt()
    val drinks = readln().split(" ").sumOf { it.toDouble() / 100.0 }
    print("%.12f".format(drinks / n * 100))
}