package problems

/* Problem Link: https://codeforces.com/problemset/problem/144/A */

fun main() {
    val n = readln().toInt()
    val order = readln().split(" ").map { it.toInt() }
    val maxIndex = order.indexOf(order.max())
    val minIndex = order.lastIndexOf(order.min())
    print(maxIndex + n - minIndex - if (maxIndex > minIndex) 2 else 1)
}