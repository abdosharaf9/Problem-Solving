package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/228/A */

fun main() {
    val colors = readln().split(" ").toSet()
    print(4 - colors.size)
}