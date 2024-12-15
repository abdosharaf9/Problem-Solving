package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/1692/A */

fun main() {
    val tests = readln().toInt()
    for (i in 1..tests) {
        val distances = readln().split(" ").map { it.toInt() }
        println(distances.count { it > distances[0] })
    }
}