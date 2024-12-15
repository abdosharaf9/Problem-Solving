package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/1807/A */

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        println(
            if (a + b == c) "+"
            else "-"
        )
    }
}