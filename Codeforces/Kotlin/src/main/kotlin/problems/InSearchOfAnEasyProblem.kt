package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/1030/A */

fun main() {
    val n = readln()
    val opinions = readln().split(" ")

    print(if (opinions.count { it == "1" } > 0) "HARD" else "EASY")
}