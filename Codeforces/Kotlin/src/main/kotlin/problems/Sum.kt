package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/1742/A */

fun main() {
    val t = readln().toInt()
    for (i in 1..t) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        println(
            if (a == b + c || b == a + c || c == a + b) "YES"
            else "NO"
        )
    }
}