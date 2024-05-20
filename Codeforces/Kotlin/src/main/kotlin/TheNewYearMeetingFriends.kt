package problems

import kotlin.math.abs

/* Problem Link: https://codeforces.com/problemset/problem/723/A */

fun main() {
    val distances = readln().split(" ").map { it.toInt() }.sorted()
    print(abs(distances[0] - distances[1]) + abs(distances[2] - distances[1]))
}