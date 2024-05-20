package problems

/* Problem Link: https://codeforces.com/problemset/problem/1154/A */

fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }.sorted()
    print("${d - a} ${d - b} ${d - c}")
}