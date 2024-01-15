package a

/* Problem Link: https://codeforces.com/problemset/problem/50/A */

fun main() {
    val inputs = readln().split(" ").map { it.toInt() }
    print((inputs[0] * inputs[1]) / 2)
}