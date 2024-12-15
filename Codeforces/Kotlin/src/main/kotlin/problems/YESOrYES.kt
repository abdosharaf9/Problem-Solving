package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/1703/A */

fun main() {
    val n = readln().toInt()
    for (i in 1..n) {
        println(if (readln().lowercase() == "yes") "YES" else "NO")
    }
}